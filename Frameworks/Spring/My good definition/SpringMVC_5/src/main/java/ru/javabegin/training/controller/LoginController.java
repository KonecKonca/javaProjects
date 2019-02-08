package ru.javabegin.training.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import ru.javabegin.training.objects.User;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
//@SessionAttributes("user")
@SessionAttributes(types = {User.class})
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@ModelAttribute
	private User defaultUser(){
		return new User().builder().name("name").password("*****").isAdmin(true).build();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main(@ModelAttribute User user , SessionStatus sessionStatus) {

		// удалить объекты текущей
//		sessionStatus.setComplete();

		user.setName("defaultName");
		return new ModelAndView("login", "user", new User());
	}
//	WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());

	@RequestMapping(value = "/check-user", method = RequestMethod.POST)
	public String checkUser(
			@Valid @ModelAttribute("user") User user,
			BindingResult bindingResult,
			Model model
	) {
		if(bindingResult.hasErrors()){
			return "login";
		}

		// нужно добавдять, только если вносим изменения (т.е здесь не надо)
		model.addAttribute("user", user);

		return "main";
	}

	@RequestMapping(value = "/failed", method = RequestMethod.GET)
	public ModelAndView failed(){
		return new ModelAndView("login-failed", "message", "Login failed");
	}

}