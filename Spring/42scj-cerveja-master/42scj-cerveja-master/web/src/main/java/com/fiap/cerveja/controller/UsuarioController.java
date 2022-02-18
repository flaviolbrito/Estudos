package com.fiap.cerveja.controller;

import com.fiap.cerveja.dto.AuthDTO;
import com.fiap.cerveja.dto.TokenDTO;
import com.fiap.cerveja.dto.UsuarioCreateDTO;
import com.fiap.cerveja.dto.UsuarioDTO;
import com.fiap.cerveja.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO cadastrar(@RequestBody UsuarioCreateDTO usuarioCreateDTO){
        return usuarioService.cadastrar(usuarioCreateDTO);
    }

    @PostMapping("login")
    public TokenDTO login(@RequestBody AuthDTO authDTO){
        return usuarioService.login(authDTO);
    }

}
