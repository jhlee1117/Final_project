package com.ch.jobdamoa.controller;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ch.jobdamoa.model.Member;
import com.ch.jobdamoa.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService ms;
	
	@Autowired
	private JavaMailSender jMailSender; // 이메일을 보내기 위한 객체 생성
	
	@RequestMapping("memberLoginForm")
	public String memberLoginForm() {
		return "member/memberLoginForm";
	}
	
	@RequestMapping("memberLogin")
	public String memberLogin(Member mem, Model model, HttpSession session) {
		
		int result = 0; // 암호가 다른 경우
		
		Member mem2 = ms.selectLogin(mem.getMem_id());
		
		if(mem2 == null || mem2.getMem_invalid().equals("y"))
			result = -1; // 없는 ID
		else if (mem2.getMem_password().equals(mem.getMem_password())) {
			result = 1; // ID와 패스워드 일치
			session.setAttribute("mem_id", mem.getMem_id());
			session.setAttribute("mem_nickname", mem.getMem_nickname());
			session.setAttribute("user_dist", mem.getUser_dist());
		}
		model.addAttribute("result", result);
		return "member/memberLogin";		
	}
	
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
		int result = ms.newMemPw(mem);
		model.addAttribute("result", result);
		return "member/newMemPw";
	}
}
