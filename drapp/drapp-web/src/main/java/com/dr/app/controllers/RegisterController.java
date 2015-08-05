package com.dr.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dr.app.repo.entity.User;
import com.dr.app.service.UserService;


@Controller
public class RegisterController {

	@Autowired
	private UserService userService;

	@ModelAttribute
	public User create() {
		return new User();
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String show(Map<String, Object> model) {
		System.out.println("---------------------inside register.GET method------------------");
		User user = new User();
		model.put("user", user);
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String save(@ModelAttribute @Valid User user,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "register";
		}
		int result = userService.register(user);
		if(result > 0){
			System.out.println("Registration Successfull.....");
		}else{
			System.out.println("Registration Un-successfull....");
		}
		return "success";
	}
}
