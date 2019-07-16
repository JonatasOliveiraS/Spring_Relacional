package com.br.zup.relacionamento.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class LoginModel implements Serializable{
	private static final long serialVersion = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Apelido não pode ficar em branco")
	@Size(min = 4, message = "Apelido tem que ter 4 caracteres")
	private String apelido;
	@NotBlank(message = "Senha não pode ficar em branco")
	@Size(min = 8, message = "Senha tem que ter no mínimo 8 letras")
	private String senha;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private UsuarioModel usuario;

	public LoginModel() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
	
	
}
