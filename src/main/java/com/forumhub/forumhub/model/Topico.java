package com.forumhub.forumhub.model; // Pacote corrigido para o seu projeto

import com.forumhub.forumhub.dto.DadosAtualizacaoTopico; // Import corrigido
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    private String estado;
    private String autor;
    private String curso;

    // MÉTODO DE ATUALIZAÇÃO AGORA DENTRO DA CLASSE
    public void atualizarInformacoes(DadosAtualizacaoTopico dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
    }

} // A CHAVE FINAL QUE FECHA A CLASSE