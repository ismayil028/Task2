package com.ismayil.hellocontroller;

import com.ismayil.model.Query;
import com.ismayil.model.Data;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ismayil.LoginWorker;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginForm() {
		ModelAndView model = new ModelAndView("login");

		return model;
	}

	@RequestMapping(value = "/success", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("data") Data data) {
		LoginWorker lw = new LoginWorker();
		ModelAndView model = new ModelAndView("Success");
		if (lw.LoginYoxla(data.getUsername(), data.getPassword())) {
			model.addObject("ad", data.getUsername());
		} else {
			model = new ModelAndView("login");
		}
		return model;

	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public ModelAndView result(@ModelAttribute("query") Query query) throws Exception {
		ModelAndView model = new ModelAndView("Result");
		return model;

	}

}
