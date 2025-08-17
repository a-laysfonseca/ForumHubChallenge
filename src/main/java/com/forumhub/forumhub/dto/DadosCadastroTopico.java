package com.forumhub.forumhub.dto;

import jakarta.validation.constraints.NotBlank;

// Este record modela exatamente os dados que esperamos receber no corpo da requisição POST
public record DadosCadastroTopico(

        @NotBlank // Validação: não pode ser nulo nem vazio
        String titulo,

        @NotBlank
        String mensagem,

        @NotBlank
        String autor,

        @NotBlank
        String curso
) {
}