package com.forumhub.forumhub.controller;

import com.forumhub.forumhub.dto.DadosAutenticacao;
import com.forumhub.forumhub.dto.DadosTokenJWT;
import com.forumhub.forumhub.infra.security.TokenService;
import com.forumhub.forumhub.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        try {
            var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
            var authentication = manager.authenticate(token);

            // LOG DE VERIFICAÇÃO: O login funcionou, vamos chamar o serviço de token.
            System.out.println(">>> AUTENTICACAO CONTROLLER: Autenticação bem-sucedida. Chamando o serviço para gerar token...");

            var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
        } catch (Exception e) {
            // LOG DE ERRO: Se a autenticação falhar, veremos o erro aqui.
            System.err.println(">>> AUTENTICACAO CONTROLLER: Erro na autenticação!");
            e.printStackTrace();
            return ResponseEntity.status(401).build();
        }
    }
}