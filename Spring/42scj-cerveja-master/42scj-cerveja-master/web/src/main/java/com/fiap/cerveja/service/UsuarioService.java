package com.fiap.cerveja.service;

import com.fiap.cerveja.dto.AuthDTO;
import com.fiap.cerveja.dto.TokenDTO;
import com.fiap.cerveja.dto.UsuarioCreateDTO;
import com.fiap.cerveja.dto.UsuarioDTO;

public interface UsuarioService {

    UsuarioDTO cadastrar(UsuarioCreateDTO usuarioCreateDTO);
    TokenDTO login(AuthDTO authDTO);

}
