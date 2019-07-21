package com.br.zup.relacionamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.relacionamento.models.LoginModel;
import com.br.zup.relacionamento.models.UsuarioModel;
import com.br.zup.relacionamento.repositories.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;
	
	public String salvarLogin(UsuarioModel user, LoginModel login) {
		login.setUsuario(user);
		loginRepository.save(login);
		return "Cadastro bem sucedido";
	}
	
	public void update(LoginModel login) {
		loginRepository.save(login);
	}
	
	public LoginModel buscarPorApelidoESenha(LoginModel login) {
		return loginRepository.findByApelidoAndSenha(login.getApelido(), login.getSenha()).get();
	}

}
