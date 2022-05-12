package com.example.Controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;
import com.example.form.UserForm;

@Controller
@RequestMapping("/ex04")
public class exam04Controller {
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	@RequestMapping("")
	public String index() {
		return "exam04";
	}
	
	@RequestMapping("/result")
	public String result(
			@Validated UserForm form
			, BindingResult result
			, RedirectAttributes redirectAttributes
			, Model model) {
		
		if(result.hasErrors()) {
			return index();
		}
		
		User user = new User();
		BeanUtils.copyProperties(form, user);
		user.setName(form.getName());
		user.setAge(form.getAge());
		user.setComment(form.getComment());
//		model.addAttribute("user", user);
		redirectAttributes.addFlashAttribute("user", user);
		
		return "redirect:/ex04/toresult";
	}
	
	@RequestMapping("/toresult")
	public String toresult() {
		return "exam04-result";
	}

}
