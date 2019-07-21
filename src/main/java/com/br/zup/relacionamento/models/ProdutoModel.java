package com.br.zup.relacionamento.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ProdutoModel implements Serializable{
	private static final long serialVersion = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Nome é obrigatório")
	@NotNull
	private String nome;
	
	@DecimalMin(value = "0.5", message = "Valor inválido")
	private double valor;
	
	@NotBlank(message = "Validade é obrigatório")
	@NotNull
	private String validade;
	
	@ManyToMany
	@JoinColumn(name = "categoria_id")
	private List<CategoriaModel> categorias = new ArrayList<CategoriaModel>();
	
	@ManyToOne
	private PedidoModel pedido;

	public ProdutoModel() {
	}

	public Integer getId() {
		return id;
	}

	public PedidoModel getPedido() {
		return pedido;
	}

	public void setPedido(PedidoModel pedido) {
		this.pedido = pedido;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public List<CategoriaModel> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaModel> categorias) {
		this.categorias = categorias;
	}
	
	
}

