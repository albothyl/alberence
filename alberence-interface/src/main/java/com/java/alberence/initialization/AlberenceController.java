package com.java.alberence.initialization;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class AlberenceController {

	@RequestMapping("hello2")
	public ModelAndView hello() {
		log.info("come in initialization controller");

		ModelAndView mav = new ModelAndView("index");
		mav.addObject("Title", "Hello Alberence");
		mav.addObject("END", "END Alberence");

		return mav;
	}
}
