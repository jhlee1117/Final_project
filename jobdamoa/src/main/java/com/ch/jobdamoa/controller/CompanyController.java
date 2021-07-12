package com.ch.jobdamoa.controller;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ch.jobdamoa.model.Company;
import com.ch.jobdamoa.service.CompanyService;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService cs;
	
	@Autowired
	private JavaMailSender jMailSender; // 이메일을 보내기 위한 객체 생성
	
	@RequestMapping("companyLoginForm")
	public String companyLoginForm() {
		return "company/companyLoginForm";
	}
	
	@RequestMapping("companyLogin")
	public String companyLogin(Company com, Model model, HttpSession session) {
		
		int result = 0; // 암호가 다른 경우
		
		Company com2 = cs.selectLogin(com.getCom_id());

		if(com2 == null || com2.getCom_invalid().equals("y"))
			result = -1; // 없는 ID
		else if (com2.getCom_password().equals(com.getCom_password())) {
			result = 1; // ID와 패스워드가 일치
			session.setAttribute("com_num", com2.getCom_num());
			session.setAttribute("com_name", com2.getCom_name());
			session.setAttribute("user_dist", com2.getUser_dist());
		}
		model.addAttribute("result", result);
		return "company/companyLogin";
	}
	
	@RequestMapping("companyLogout")
	public String companyLogout(HttpSession session) {
		session.invalidate();
		return "home/home";
	}
	
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
		int result = cs.newComPw(com);
		model.addAttribute("result", result);
		return "company/newComPw";
	}
}
