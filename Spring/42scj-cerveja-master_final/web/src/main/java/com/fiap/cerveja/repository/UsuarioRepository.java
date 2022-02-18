package com.fiap.cerveja.repository;

import com.fiap.cerveja.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findFirstByNome(String nome);

}
