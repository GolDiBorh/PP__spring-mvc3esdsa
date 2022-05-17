package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class HelloController {

	private final UserService userService;
	@Autowired
	public HelloController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {

		model.addAttribute("messages", userService.listUsers());
		return "index";
	}

	@GetMapping(value = "/new")
	public String newUser(@ModelAttribute("user") User user) {
		//model.addAttribute("user", new User());
		return "new";
	}
	@PostMapping
	public String create(@ModelAttribute("user") User user){
		userService.add(user);
		return "redirect:/";
	}
	@GetMapping(value = "/edit/{id}")
	public String editUser( Model model, @PathVariable("id") long id) {
		model.addAttribute("user", userService.show(id));
		return "edit";
	}

	@PatchMapping(value = "/{id}")
	public String update(@ModelAttribute("user") User user,@PathVariable("id") long id){
		userService.update(id,user);

		return "redirect:/";
	}
	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable("id") long id){
		userService.delete(id);
		return "redirect:/";
	}








}