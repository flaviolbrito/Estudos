package com.fiap.cerveja.security;

import com.fiap.cerveja.entity.Usuario;
import com.fiap.cerveja.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    public JwtUserDetailsService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findFirstByNome(nome);
        if(usuario == null){
            throw new UsernameNotFoundException("usuario.nao.encontrado");
        }

        return new User(
                usuario.getNome(),
                usuario.getSenha(),
                new ArrayList<>() // roles
        );
    }
}
