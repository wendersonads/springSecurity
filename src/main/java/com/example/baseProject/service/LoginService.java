package com.example.baseProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.baseProject.dto.registerDTO;
import com.example.baseProject.models.Usuario;
import com.example.baseProject.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
    
    @Autowired
    private final UsuarioRepository usuarioRepository;

//   private void verificaUsuarioCadastrado(String login){
//     if (login != null) {
//         try {
//         UserDetails usuarioCadastrado = usuarioRepository.findByLogin(login);
//             if (usuarioCadastrado.) {
//                 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já cadastrado");
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//             System.out.println("Erro ao validar usuário cadastrado!" + e.getMessage());
//         }
//     }
//   }

  public ResponseEntity<Usuario> cadastrar(registerDTO novo) {
    // verificaUsuarioCadastrado(novo.getLogin());
    
    if (novo == null) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todos os dados são obrigatórios!");
    }

    if (novo.getLogin() == null || novo.getLogin().trim().isEmpty()) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O login é obrigatório e não pode estar vazio ou conter apenas espaços.");
    }

    if (novo.getNome() == null || novo.getNome().trim().isEmpty()) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome é obrigatório e não pode estar vazio ou conter apenas espaços.");
    }

    if (novo.getSenha() == null || novo.getSenha().trim().isEmpty()) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha é obrigatória e não pode estar vazio ou conter apenas espaços.");
    }
    
    Usuario novoUsuario = new Usuario();
    novoUsuario.setLogin(novo.getLogin().trim());
    novoUsuario.setNome(novo.getNome());
    novoUsuario.setSenha(novo.getSenha());
    
    usuarioRepository.save(novoUsuario);
    return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
}

}
