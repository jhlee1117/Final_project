package com.ch.jobdamoa.controller;

import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ch.jobdamoa.model.Manager;
import com.ch.jobdamoa.model.Member;
import com.ch.jobdamoa.service.ManagerService;
import com.ch.jobdamoa.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService ms;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private ManagerController managerController;
	
	@Autowired
	private JavaMailSender jMailSender; // 이메일을 보내기 위한 객체 생성
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder; // 비밀번호 암호화 객체 생성
	
	/* 로그인 관련 기능 구현 */
	
	@RequestMapping("memberLoginForm")
	public String memberLoginForm(HttpServletRequest request, HttpSession session) {
		String referer = "";
		if (session.getAttribute("referer") == null) {
			referer = request.getHeader("referer");
		} else if (((String) session.getAttribute("referer")).contains("LoginForm")) {
			session.removeAttribute("referer");
		} else {
			referer = (String) session.getAttribute("referer");
		}
		session.setAttribute("referer", referer);
		
		return "login/memberLoginForm";
	}
	
	@RequestMapping("memberLogin")
	public String memberLogin(HttpServletRequest request, Member mem, Model model, HttpSession session) {

		String referer = (String) session.getAttribute("referer");
		String member_id = mem.getMem_id();
		
		int result = 0; // 암호가 다른 경우
		
		Member member = ms.selectLogin(member_id);
		
		// manager 아이디일 경우 managerController의 로그인 메소드 실행
		Manager manager = managerService.login(member_id);
		
		if(member == null && manager != null) {
			return managerController.managerLogin(request, model, session);
		}
		
		else if(member == null || member.getMem_invalid().equals("y"))
			result = -1; // 없는 ID
		else if (passwordEncoder.matches(mem.getMem_password(), member.getMem_password())) {
			result = 1; // ID와 패스워드 일치
			session.setAttribute("mem_num", member.getMem_num());
			session.setAttribute("mem_nickname", member.getMem_nickname());
			session.setAttribute("user_dist", member.getUser_dist());
		}
		model.addAttribute("result", result);
//		model.addAttribute("referer", referer);
		return "login/memberLogin";			
	}
	
	@RequestMapping("memberLogout")
	public String memberLogout(HttpSession session, HttpServletRequest request) {
		String referer = request.getHeader("referer");
		session.invalidate();
		return "redirect:" + referer;
	}
	
	/* 로그인 관련 기능 구현 끝 */
	
	/* 비밀번호 찾기 기능 구현 */
	
	@RequestMapping("findMemIdForm")
	public String findMemIdForm() {
		return "member/findMemIdForm";
	}
	
	@RequestMapping("findMemId")
	public String findMemId(Member mem, Model model, HttpSession session) {
		
		int result = 0;
		
		Member mem2 = ms.findMemId(mem.getMem_email());
		if(mem2 == null || mem2.getMem_invalid().equals("y"))
			result = 0;
		else if (mem2.getMem_email().equals(mem.getMem_email())) {
			result = 1;
			session.setAttribute("mem_id", mem2.getMem_id());
		}
		model.addAttribute("result", result);
		return "member/findMemId";
	}
	
	@RequestMapping("findMemPwForm")
	public String findMemPwForm() {
		return "member/findMemPwForm";
	}
	
	@RequestMapping("pwMemAuth")
	public ModelAndView findMemPw(Member mem, HttpSession session) {
		
		String msg;
		ModelAndView mv = new ModelAndView();
		
		Member mem2 = ms.selectLogin(mem.getMem_id()); // id 조회 여부 판단
		
		if(mem2 == null || mem2.getMem_invalid().equals("y")) {
			msg = "존재하지 않는 ID입니다.";
			mv.setViewName("member/failMemPw");
			mv.addObject("msg", msg);
		}
		else if(!mem2.getMem_email().equals(mem.getMem_email())) {
			msg = "등록되지 않은 이메일입니다.";
			mv.setViewName("member/failMemPw");
			mv.addObject("msg", msg);
		}
		else {
			
			MimeMessage mm = jMailSender.createMimeMessage(); // 이메일 보내는 것을 선언
			
			Random rnd = new Random();
			int num = rnd.nextInt(999999); // 인증번호 보내기 위한 난수 만들기
			
			String title = "Jobdamoa 비밀번호 인증 메일 입니다."; // 제목
			String contents = "안녕하세요. 회원님" + System.getProperty("line.separator") + "비밀번호 인증번호는 다음과 같습니다."
								+ System.getProperty("line.separator") + "[" + num + "]";
			String setFrom = "jobdamoa@gmail.com"; // 보내는 사람
			String setTo = mem2.getMem_email(); // 받는 사람 
			
			try {
				MimeMessageHelper mmh = new MimeMessageHelper(mm, true, "utf-8");
				mmh.setSubject(title);
				mmh.setText(contents);
				mmh.setTo(setTo);
				mmh.setFrom(setFrom);
				jMailSender.send(mm);

			} catch (MessagingException e) {
				System.out.println(e.getMessage());

			}
			session.setAttribute("mem_id", mem2.getMem_id());
			mv.setViewName("member/pwMemAuth"); // 패스워드 체크를 위한 인증페이지 설정
			mv.addObject("num", num);
		}
		return mv;
	}
	
	@RequestMapping("pwMemSet")
	public String pwComSet(@RequestParam(value="auth_num") String auth_num, @RequestParam(value="num") String num, Model model) {
		
		if(auth_num.equals(num)) {
			return "member/newMemPwForm";
		} else {
			String msg = "인증번호가 일치하지 않습니다.";
			model.addAttribute("msg", msg);
			return "member/failMemPw";
		}
	}
	
	@RequestMapping("newMemPw")
	public String newMemPw(Member mem, Model model) {
		String encPassword = passwordEncoder.encode(mem.getMem_password()); // 비밀번호 암호화 설정
		mem.setMem_password(encPassword);
		int result = ms.newMemPw(mem);
		model.addAttribute("result", result);
		return "member/newMemPw";
	}
	/* 비밀번호 찾기 기능 끝 */
	
	/* 회원가입 기능 구현 */	
	@RequestMapping("memberJoinForm")
	public String memberJoinForm() {
		return "join/memberJoinForm";
	}
	
	@RequestMapping(value = "confirmMem", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String confirmMem(HttpServletRequest request) {
		
		String mem_id = request.getParameter("mem_id");
		String msg = "";
		Member mem = ms.selectLogin(mem_id);
		
		if (mem == null)
			msg = "사용 가능한 아이디입니다.";
		else
			msg = "사용 중이니 다른 아이디를 사용하세요.";
		
		return msg;
	}
	
	@RequestMapping("memberJoin.do")
	public String memberJoin(Member mem, Model model) {
		
		int result;
		
		mem.setMem_num(ms.giveMem_num()); // 일련번호 부여
		
		String encPassword = passwordEncoder.encode(mem.getMem_password()); // BCrypt를 활용한 비밀번호 암호화
		mem.setMem_password(encPassword);

		List<Member> mememail = ms.selectMem_email(mem.getMem_email()); // 중복된 이메일 등록 방지
		
		if (mememail.isEmpty()) {
			result = ms.insertMem(mem);
		} else
			result = 0;
		
		model.addAttribute("result", result);
		
		return "join/memberJoin";
	}
	/* 회원가입 기능 구현 끝 */	
	
	/* 회원정보 조회 기능 구현 */
	@RequestMapping("memInfo.do")
	public String memInfo(Member mem, Model model, HttpSession session) {
		int mem_num = (int) session.getAttribute("mem_num");
		mem = ms.selectMem(mem_num);
		model.addAttribute("mem", mem);
		
		return "member/memInfo";
	}
	
	/* 회원정보 수정 기능 구현 */
	@RequestMapping("memUpdateForm.do")
	public String memUpdateForm(Member mem, Model model, HttpSession session) {
		int mem_num = (int) session.getAttribute("mem_num");
		mem = ms.selectMem(mem_num);
		model.addAttribute("mem", mem);
		
		return "member/memUpdateForm";
	}
	
	@RequestMapping(value = "checkMem_email", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String checkMem_email(Member mem) {
		int mem_num = mem.getMem_num();
		String or_mem_email = ms.selectMem(mem_num).getMem_email();
		String mem_email = mem.getMem_email();
		List<Member> mememail = ms.selectMem_email(mem_email); // 중복된 이메일 등록 방지
		String msg = "";
		
		if (mememail.isEmpty() || or_mem_email.equals(mem_email))
			msg = "사용 가능한 이메일입니다.";
		else
			msg = "사용 중이니 다른 이메일을 사용하세요.";
		
		return msg;
	}
	
	@RequestMapping("memUpdate")
	public String memUpdate(Member mem, Model model) {
		String encPassword = passwordEncoder.encode(mem.getMem_password()); // 비밀번호 암호화 설정
		mem.setMem_password(encPassword);
		int result = ms.updateMem(mem);
		model.addAttribute("result", result);
		return "member/memUpdate";
	}
	/* 회원정보 수정 기능 구현 끝 */

	/* 회원탈퇴 기능 구현 */
	@RequestMapping("memDeleteForm")
	public String memDeleteForm(HttpSession session) {
		int mem_num = (int) session.getAttribute("mem_num");
		session.setAttribute("mem_num", mem_num);
		return "member/memDeleteForm";
	}
	
	@RequestMapping("memDelete")
	public String memDelete(HttpSession session, Model model) {
		System.out.println("받기: " + session.getAttribute("mem_num"));
		int mem_num = (int) session.getAttribute("mem_num");
		System.out.println("변환: " + mem_num);
		int result = ms.deleteMem(mem_num);
		model.addAttribute("result", result);
		return "member/memDelete";
	}
	/* 회원탈퇴 기능 구현 끝 */
}
