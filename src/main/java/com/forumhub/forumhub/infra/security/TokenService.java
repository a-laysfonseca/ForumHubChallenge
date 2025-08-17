package com.forumhub.forumhub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.forumhub.forumhub.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario) {
        // LOG DE VERIFICAÇÃO 1: O método foi chamado?
        System.out.println(">>> TOKEN SERVICE: Método gerarToken foi chamado para o usuário: " + usuario.getLogin());
        // LOG DE VERIFICAÇÃO 2: A chave secreta foi lida do application.properties?
        System.out.println(">>> TOKEN SERVICE: A chave secreta é: [" + secret + "]");

        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API ForumHub")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            // LOG DE ERRO: Se algo der errado na criação, veremos esta mensagem.
            System.err.println(">>> TOKEN SERVICE: Erro ao GERAR token JWT!");
            exception.printStackTrace();
            throw new RuntimeException("Erro ao gerar token JWT", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API ForumHub")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            // LOG DE ERRO: Se algo der errado na verificação, veremos esta mensagem.
            System.err.println(">>> TOKEN SERVICE: Erro ao VERIFICAR token JWT!");
            exception.printStackTrace();
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}