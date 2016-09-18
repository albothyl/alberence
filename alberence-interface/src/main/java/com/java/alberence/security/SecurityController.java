package com.java.alberence.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class SecurityController {

	@RequestMapping("/login")
	public ModelAndView login() {
		log.info("==== Login ===");

		return new ModelAndView("loginForm");
	}

	@RequestMapping("/loginSuccess")
	public ModelAndView loginSuccess() {
		log.info("==== Login success ===");

		ModelAndView mav = new ModelAndView("index");
		mav.addObject("Title", "Login success");
		mav.addObject("Content", "Login success");

		return mav;
	}

	@RequestMapping("/loginFail")
	public ModelAndView loginFail() {
		log.info("==== Login fail ===");

		ModelAndView mav = new ModelAndView("index");
		mav.addObject("Title", "Login fail");
		mav.addObject("Content", "Login fail");

		return mav;
	}

	@RequestMapping("/logout")
	public ModelAndView logout() {
		log.info("==== Logout ===");

		ModelAndView mav = new ModelAndView("index");
		mav.addObject("Title", "Logout");
		mav.addObject("Content", "Logout");

		return mav;
	}

	@RequestMapping("/logoutSuccess")
	public ModelAndView logoutSuccess() {
		log.info("==== Logout success ===");

		ModelAndView mav = new ModelAndView("index");
		mav.addObject("Title", "Logout success");
		mav.addObject("Content", "Logout success");

		return mav;
	}

	@Secured("ADMIN")
	@RequestMapping("/admin/main")
	public ModelAndView main() {
		log.info("==== main ===");

		ModelAndView mav = new ModelAndView("index");
		mav.addObject("Title", "main");
		mav.addObject("Content", "main");

		return mav;
	}
}
