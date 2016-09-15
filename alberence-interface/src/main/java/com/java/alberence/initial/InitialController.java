package com.java.alberence.initial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class InitialController {

	@RequestMapping("/hello")
	public ModelAndView hello() {
		log.info("come in initial controller");

		ModelAndView mav = new ModelAndView("index");
		mav.addObject("Title", "Alberence");
		mav.addObject("Content", "Hello Alberence");

		return mav;
	}
}
