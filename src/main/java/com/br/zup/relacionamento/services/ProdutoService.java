package com.br.zup.relacionamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.relacionamento.models.ProdutoModel;
import com.br.zup.relacionamento.repositories.CategoriaRepository;
import com.br.zup.relacionamento.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public String salvarProduto(ProdutoModel produto) {
		
		produtoRepository.save(produto);
		
		return "Produto salvo com Sucesso";
	}
	
	public Iterable<ProdutoModel> buscarTodosProdutos(){
		return produtoRepository.findAll();
	}
	
	public void deleteProduto(Integer id) {
		produtoRepository.deleteById(id);
	}
	
	public ProdutoModel buscarProduto(Integer id) {
		return produtoRepository.findById(id).get();
		
	}
	
}
