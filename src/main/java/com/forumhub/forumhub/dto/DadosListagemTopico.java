package com.forumhub.forumhub.dto;

import com.forumhub.forumhub.model.Topico;

import java.time.LocalDateTime;

// DTO atualizado para incluir todos os campos pedidos na listagem
public record DadosListagemTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String estado, // NOVO CAMPO
        String autor,  // NOVO CAMPO
        String curso   // NOVO CAMPO
) {
    // Construtor atualizado para mapear os novos campos
    public DadosListagemTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getEstado(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}