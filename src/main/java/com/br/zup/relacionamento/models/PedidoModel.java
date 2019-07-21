package com.br.zup.relacionamento.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javassist.SerialVersionUID;

@Entity
public class PedidoModel implements Serializable{
	private static final long SerialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(mappedBy = "pedido")
	private List<ProdutoModel> pedidos;
	
	@ManyToOne
	private UsuarioModel usuario;

	public PedidoModel() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ProdutoModel> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<ProdutoModel> pedidos) {
		this.pedidos = pedidos;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
	
}
