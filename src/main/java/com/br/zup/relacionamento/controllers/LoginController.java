package com.br.zup.relacionamento.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
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
	
	@GetMapping("/login")
	public ModelAndView exibirLoginForm() {
		ModelAndView modelAndView = new ModelAndView("login.html");
		return modelAndView;
	}
	
	@PostMapping("/login")
	public ModelAndView logar(LoginModel login, HttpSession session) {
		ModelAndView modelAndView = null;
		if(session.getAttribute("ultimoURL") != null) {
			modelAndView = new ModelAndView("redirect:"+ session.getAttribute("ultimoURL"));
		}else {
			modelAndView = new ModelAndView("login.html");
		}
		
		LoginModel objetoLogin = loginService.buscarPorApelidoESenha(login);
		if (objetoLogin != null) {
			session.setAttribute("usuario", objetoLogin.getUsuario());
			String saudacao = "Olá " + objetoLogin.getUsuario().getNome() + "! Seja bem vindo.";
			modelAndView.addObject("mensagem", saudacao);
		}else {
			String deuRuim = "Deu ruim ai parceiro!";
			modelAndView.addObject("mensagem", deuRuim);
		}
		return modelAndView;
	}
	
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
	@PostMapping("/sair")
	public ModelAndView sair(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("redirect:/login");
		session.removeAttribute("usuario");
		return modelAndView;
	}
	
	
	
	
	
}