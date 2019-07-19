package com.br.zup.relacionamento.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zup.relacionamento.models.ProdutoModel;
@Repository
public interface ProdutoRepository extends CrudRepository<ProdutoModel, Integer>{

}
