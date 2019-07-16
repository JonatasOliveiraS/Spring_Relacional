package com.br.zup.relacionamento.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zup.relacionamento.models.LoginModel;

@Repository
public interface LoginRepository extends CrudRepository<LoginModel, Integer> {

}
