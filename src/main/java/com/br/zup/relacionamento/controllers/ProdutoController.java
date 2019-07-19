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

import com.br.zup.relacionamento.models.ProdutoModel;
import com.br.zup.relacionamento.services.CategoriaService;
import com.br.zup.relacionamento.services.ProdutoService;

@Controller
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/produtos")
	public ModelAndView exibirProdutos() {
		ModelAndView modelAndView = new ModelAndView("produtos.html");
		modelAndView.addObject("produtos", produtoService.buscarTodosProdutos());
		return modelAndView;
	}
	
	@GetMapping("/cadastrar/produtos")
	public ModelAndView exibirFormulario() {
		ModelAndView modelAndView = new ModelAndView("cadastroProduto.html");
		modelAndView.addObject("categorias", categoriaService.buscarTodasCategorias());
			return modelAndView;
		}
	
	@PostMapping("/cadastrar/produtos")
	public ModelAndView cadastrarProduto(@Valid ProdutoModel produto, BindingResult bindingProduto) {
		ModelAndView modelAndView = new ModelAndView("cadastroProduto.html");
		modelAndView.addObject("categorias", categoriaService.buscarTodasCategorias());
		if(bindingProduto.hasErrors()) {
			List<String> mensagens = new ArrayList<String>();
			for(ObjectError erros : bindingProduto.getAllErrors()) {
				mensagens.add(erros.getDefaultMessage());
			}
			modelAndView.addObject("mensagens", mensagens);
		}else {
			modelAndView.addObject("mensagens", produtoService.cadastrarProduto(produto));
		}
		return modelAndView;
	}

}
