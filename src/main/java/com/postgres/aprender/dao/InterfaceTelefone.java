package com.postgres.aprender.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.postgres.aprender.model.Telefone;

@Repository
public interface InterfaceTelefone extends CrudRepository<Telefone, Long> {
    
}
