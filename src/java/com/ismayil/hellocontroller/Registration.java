package com.ismayil.hellocontroller;

import com.ismayil.model.RegData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ismayil.RegisterWorker;

@Controller
public class Registration {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView getReg() {
		ModelAndView model = new ModelAndView("Register");

		return model;
	}

	@RequestMapping(value = "/registersuccess", method = RequestMethod.POST)
	public ModelAndView getRegSuccess(@ModelAttribute("reg") RegData reg) {
		ModelAndView model;
		RegisterWorker rw = new RegisterWorker();
		String control = rw.RegisterMethod(reg.getName(), reg.getEmail(), reg.getPassword());
		if (control.equals("olmadi")) {
			model = new ModelAndView("Register");
			model.addObject("asd", reg.getPassword());
			model.addObject("msg", "Something Went Wrong");
			
		}else {
			model = new ModelAndView("Success");
			model.addObject("ad", "" + reg.getName());
		}
		

		return model;
	}
        

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getLoginPage() {
		ModelAndView model = new ModelAndView("login");

		return model;
	}
}
