package com.br.zup.relacionamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.relacionamento.models.ProdutoModel;
import com.br.zup.relacionamento.repositories.CategoriaRepository;
import com.br.zup.relacionamento.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
public String cadastrarProduto(ProdutoModel produto) {
		
		produtoRepository.save(produto);
		
		return "Produto Cadastrado com Sucesso";
	}
	
	public Iterable<ProdutoModel> buscarTodosProdutos(){
return produtoRepository.findAll();
	}
}
