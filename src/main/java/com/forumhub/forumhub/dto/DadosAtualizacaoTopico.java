package com.forumhub.forumhub.dto;

// Validação pode ser adicionada aqui se necessário, como @Length
public record DadosAtualizacaoTopico(
        String titulo,
        String mensagem
) {
}