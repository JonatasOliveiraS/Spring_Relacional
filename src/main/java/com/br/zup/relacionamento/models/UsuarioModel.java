package com.br.zup.relacionamento.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class UsuarioModel implements Serializable{
	private static final long serialVersion = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Nome não pode ficar em branco")
	@Size(min = 2, message = "Nome tem que ter no mínimo 2 letras")
	private String nome;
	@NotBlank(message = "SobreNome não pode ficar em branco")
	@Size(min = 2, message = "SobreNome tem que ter no mínimo 4 letras")
	private String sobrenome;
	@NotBlank(message = "Email não pode ficar em branco")
	@Email(message = "E-mail inválido")
	private String email;
	
	@OneToOne(mappedBy = "usuario")
	private LoginModel login;
	
	
	public UsuarioModel() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobrenome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobrenome = sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LoginModel getLogin() {
		return login;
	}

	public void setLogin(LoginModel login) {
		this.login = login;
	}
}
