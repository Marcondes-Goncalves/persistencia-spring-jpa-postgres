package com.postgres.aprender.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.postgres.aprender.model.UsuarioSpringData;

import jakarta.persistence.LockModeType;

@Repository
public interface interfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long> {
    
    @Query(value = "select p from UsuarioSpringData p where p.nome like %?1%")
    public List<UsuarioSpringData> buscaPornome (String nome);

    @Lock(LockModeType.READ)
    @Transactional(readOnly = true)
    @Query(value = "select p from UsuarioSpringData p where p.nome = :paramnome")
    public UsuarioSpringData buscaPorNomeParam (@Param("paramnome") String paramnome);

    default <S extends UsuarioSpringData> S saveAtual(S entity) {
        // processa qualquer coisa
        return save(entity);
    }

    @Modifying //diz ao spring que vamos fazer uma alteração no banco
    @Transactional
    @Query(value = "delete from UsuarioSpringData u where u.nome = ?1")
    public void deletePorNome(String nome);

    @Modifying //diz ao spring que vamos fazer uma alteração no banco
    @Transactional
    @Query(value = "update UsuarioSpringData u set u.email = ?1 where u.nome = ?2")
    public void updateEmailPorNome(String email, String nome);
}
