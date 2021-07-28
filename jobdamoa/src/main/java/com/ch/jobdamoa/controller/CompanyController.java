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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ch.jobdamoa.model.Company;
import com.ch.jobdamoa.service.CompanyService;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService cs;
	
	@Autowired
	private JavaMailSender jMailSender; // 이메일을 보내기 위한 객체 생성

	@Autowired
	private BCryptPasswordEncoder passwordEncoder; // 비밀번호 암호화 객체 생성

	/* 로그인을 위한 기능 구현 */
	
	@RequestMapping("companyLoginForm")
	public String companyLoginForm(HttpServletRequest request, HttpSession session) {
		String referer = "";
		if (session.getAttribute("referer") == null) {
			referer = request.getHeader("referer");
		} else {
			referer = (String) session.getAttribute("referer");
		}
		referer = referer.replace("comInfo.do", "home.do");
		referer = referer.replace("myAnnList.do", "home.do");
		session.setAttribute("referer", referer);
		return "login/companyLoginForm";
	}
	
	@RequestMapping("companyLogin")
	public String companyLogin(Company com, Model model, HttpServletRequest request, HttpSession session) {
		int result = 0; // 암호가 다른 경우
		
		Company com2 = cs.selectLogin(com.getCom_id());
		
		if(com2 == null || com2.getCom_invalid().equals("y"))
			result = -1; // 없는 ID
		else if (passwordEncoder.matches(com.getCom_password(), com2.getCom_password())) {
			result = 1; // ID와 패스워드가 일치
			session.setAttribute("com_num", com2.getCom_num());
			session.setAttribute("com_name", com2.getCom_name());
			session.setAttribute("user_dist", com2.getUser_dist());
		}
		model.addAttribute("result", result);
		
		return "login/companyLogin";
	}
	
	@RequestMapping("companyLogout")
	public String companyLogout(HttpServletRequest request, HttpSession session) {
		String referer = request.getHeader("referer");
		session.invalidate();
		return "redirect: " + referer;
	}
	
	/* 로그인 관련 기능 끝 */
	
	/* 비밀번호 찾기 기능 구현 */
	
	@RequestMapping("findComIdForm")
	public String findComIdForm() {
		return "company/findComIdForm";
	}
	
	@RequestMapping("findComId")
	public String findComId(Company com, Model model, HttpSession session) {
		
		int result = 0;
		
		Company com2 = cs.findComId(com.getCom_email());
		if(com2 == null || com2.getCom_invalid().equals("y"))
			result = 0;
		else if (com2.getCom_email().equals(com.getCom_email())) {
			result = 1;
			session.setAttribute("com_id", com2.getCom_id());
		}
		model.addAttribute("result", result);
		return "company/findComId";
	}
	
	@RequestMapping("findComPwForm")
	public String fincComPwForm() {
		return "company/findComPwForm";
	}
	
	@RequestMapping("pwComAuth")
	public ModelAndView findComPw(Company com, HttpSession session) {
		
		String msg;
		ModelAndView mv = new ModelAndView();
		
		Company com2 = cs.selectLogin(com.getCom_id()); // id 조회 여부 판단
		
		if(com2 == null || com2.getCom_invalid().equals("y")) {
			msg = "존재하지 않는 ID입니다.";
			mv.setViewName("company/failComPw");
			mv.addObject("msg", msg);
		}
		else if(!com2.getCom_email().equals(com.getCom_email())) {
			msg = "등록되지 않은 이메일입니다.";
			mv.setViewName("company/failComPw");
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
			String setTo = com2.getCom_email(); // 받는 사람 
			
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
			session.setAttribute("com_id", com2.getCom_id());
			mv.setViewName("company/pwComAuth"); // 패스워드 체크를 위한 인증페이지 설정
			mv.addObject("num", num);
		}
		return mv;
	}
	
	@RequestMapping("pwComSet")
	public String pwComSet(@RequestParam(value="auth_num") String auth_num, @RequestParam(value="num") String num, Model model) {
		
		if(auth_num.equals(num)) {
			return "company/newComPwForm";
		} else {
			String msg = "인증번호가 일치하지 않습니다.";
			model.addAttribute("msg", msg);
			return "company/failComPw";
		}
	}
	
	@RequestMapping("newComPw")
	public String newComPw(Company com, Model model) {
		String encPassword = passwordEncoder.encode(com.getCom_password()); // 비밀번호 암호화 설정
		com.setCom_password(encPassword);
		int result = cs.newComPw(com);
		model.addAttribute("result", result);
		return "company/newComPw";
	}
	
	/* 비밀번호 찾기 기능 끝 */
	
	/* 회원가입 기능 구현 */
	
	@RequestMapping("companyJoinForm")
	public String companyJoinForm() {
		return "join/companyJoinForm";
	}
	
	@RequestMapping(value = "confirmCom", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String confirmCom(HttpServletRequest request) {
		
		String com_id = request.getParameter("com_id");
		String msg = "";
		Company com = cs.selectLogin(com_id);
		
		if (com == null)
			msg = "사용 가능한 아이디입니다.";
		else
			msg = "사용 중이니 다른 아이디를 사용하세요.";
		
		return msg;
	}
	
	@RequestMapping("companyJoin.do")
	public String companyJoin(Company com, Model model) {
		
		int result;
		
		com.setCom_num(cs.giveCom_num()); // 일련번호 부여
		
		String encPassword = passwordEncoder.encode(com.getCom_password()); // BCrypt를 활용한 비밀번호 암호화
		com.setCom_password(encPassword);

		List<Company> combnm = cs.selectCom_bnm(com.getCom_business_num()); // 중복된 사업자번호 등록 방지
		List<Company> comemail = cs.selectCom_email(com.getCom_email()); // 중복된 이메일 등록 방지
		List<Company> compno = cs.selectCom_pno(com.getCom_pno()); // 중복된 전화번호 등록 방지
		
		if (combnm.isEmpty() && comemail.isEmpty() && compno.isEmpty()) {
			result = cs.insertCom(com);
		} else
			result = 0;
		
		model.addAttribute("result", result);
		
		return "join/companyJoin";
	}
	
	/* 회원가입 기능 끝 */
	
	/* 회원정보 조회 기능 구현 */
	@RequestMapping("comInfo.do")
	public String memInfo(Company com, Model model, HttpSession session) {
		int com_num = (int) session.getAttribute("com_num");
		com = cs.selectCom(com_num);
		model.addAttribute("com", com);
		
		return "company/comInfo";
	}
	
	/* 회원정보 수정 기능 구현 */
	@RequestMapping("comUpdateForm.do")
	public String comUpdateForm(Company com, Model model, HttpSession session) {
		int com_num = (int) session.getAttribute("com_num");
		com = cs.selectCom(com_num);
		model.addAttribute("com", com);
		
		return "company/comUpdateForm";
	}
	@RequestMapping(value = "checkCom_pno", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String checkCom_pno(Company com) {
		int com_num = com.getCom_num();
		String or_com_pno = cs.selectCom(com_num).getCom_pno();
		String com_pno = com.getCom_pno();
		List<Company> compno = cs.selectCom_pno(com_pno);
		String msg = "";
		
		if (compno.isEmpty() || or_com_pno.equals(com_pno))
			msg = "사용 가능한 전화번호입니다.";
		else
			msg = "사용 중이니 다른 전화번호를 사용하세요.";
		
		return msg;
	}
	
	@RequestMapping(value = "checkCom_email", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String checkCom_email(Company com) {
		int com_num = com.getCom_num();
		String or_com_email = cs.selectCom(com_num).getCom_email();
		String com_email = com.getCom_email();
		List<Company> comemail = cs.selectCom_email(com_email);
		String msg = "";
		
		if (comemail.isEmpty() || or_com_email.equals(com_email))
			msg = "사용 가능한 이메일입니다.";
		else
			msg = "사용 중이니 다른 이메일을 사용하세요.";
		
		return msg;
	}
	
	@RequestMapping("comUpdate")
	public String comUpdate(Company com, Model model) {
		String encPassword = passwordEncoder.encode(com.getCom_password()); // 비밀번호 암호화 설정
		com.setCom_password(encPassword);
		int result = cs.updateCom(com);
		model.addAttribute("result", result);
		return "company/comUpdate";
	}
	/* 회원정보 수정 기능 구현 끝 */
	
	/* 회원탈퇴 기능 구현 */
	@RequestMapping("comDeleteForm")
	public String comDeleteForm(HttpSession session) {
		int com_num = (int) session.getAttribute("com_num");
		session.setAttribute("com_num", com_num);
		return "company/comDeleteForm";
	}
	
	@RequestMapping("comDelete")
	public String memDelete(HttpSession session, Model model) {
		System.out.println("받기: " + session.getAttribute("com_num"));
		int com_num = (int) session.getAttribute("com_num");
		System.out.println("변환: " + com_num);
		int result = cs.deleteCom(com_num);
		model.addAttribute("result", result);
		return "company/comDelete";
	}
	/* 회원탈퇴 기능 구현 끝 */	
	
	@RequestMapping(value = "confirmAnnDel", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String confirmAnnDel(String com_password, HttpSession session) {
		String result="";
		Company com = cs.selectCom((int) session.getAttribute("com_num"));
		if (passwordEncoder.matches(com_password, com.getCom_password())) {
			System.out.println("성공");
			result = "1";
		} else {
			System.out.println("실패");
			result = "-1";
		}
		return result;
	}
}
