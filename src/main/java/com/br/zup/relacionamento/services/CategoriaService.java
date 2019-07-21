package com.br.zup.relacionamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.relacionamento.models.CategoriaModel;
import com.br.zup.relacionamento.models.ProdutoModel;
import com.br.zup.relacionamento.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public String salvarCategoria(CategoriaModel category) {
		categoriaRepository.save(category);
		return "Categoria cadastrada";
	}
	public Iterable<CategoriaModel> buscarTodasCategorias() {
		return categoriaRepository.findAll();

}
	}
