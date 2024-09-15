package com.example.baseProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.baseProject.models.Usuario;

public interface  UsuarioRepository extends JpaRepository<Usuario, Long>{
    
 Optional<Usuario> findByLoginAndSenha(String login, String senha);

 UserDetails findByLogin(String login);
}
