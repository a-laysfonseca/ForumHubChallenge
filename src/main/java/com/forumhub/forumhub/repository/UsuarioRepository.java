package com.forumhub.forumhub.repository;

import com.forumhub.forumhub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método que o Spring Security usará para consultar um usuário pelo login
    UserDetails findByLogin(String login);
}