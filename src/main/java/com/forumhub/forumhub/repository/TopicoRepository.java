package com.forumhub.forumhub.repository;

import com.forumhub.forumhub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// A interface estende JpaRepository<Entidade, TipoDoId>
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Método para verificar se já existe um tópico com o mesmo título E a mesma mensagem.
    // O Spring Data JPA cria a consulta automaticamente a partir do nome do método.
    Optional<Topico> findByTituloAndMensagem(String titulo, String mensagem);
}