package com.br.zup.relacionamento.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.zup.relacionamento.models.LoginModel;
import com.br.zup.relacionamento.models.UsuarioModel;
import com.br.zup.relacionamento.services.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/cadastro/login")
	public ModelAndView exibirFormulario() {
		ModelAndView modelAndView = new ModelAndView("cadastro.html");
		return modelAndView;
	}
	@PostMapping("/cadastro/login")
	public ModelAndView cadastrarLogin(@Valid UsuarioModel user, BindingResult bindingUser, @Valid LoginModel login, BindingResult bindingLogin) {
		ModelAndView modelAndView = new ModelAndView("cadastro.html");
		if(bindingUser.hasErrors() || bindingLogin.hasErrors()) {
			List<String> msgs = new ArrayList<String>();
			for (ObjectError objerro : bindingUser.getAllErrors()) {
				msgs.add(objerro.getDefaultMessage());
			}
			for (ObjectError objerro : bindingLogin.getAllErrors()) {
				msgs.add(objerro.getDefaultMessage());
			}
			modelAndView.addObject("msgs", msgs);
		}else {
			modelAndView.addObject("msgs", loginService.salvarLogin(user, login));
		}
		return modelAndView;
	}
}