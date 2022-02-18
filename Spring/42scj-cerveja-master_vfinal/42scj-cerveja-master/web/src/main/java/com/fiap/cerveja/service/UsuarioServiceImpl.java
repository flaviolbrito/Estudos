package com.fiap.cerveja.service;

import com.fiap.cerveja.dto.AuthDTO;
import com.fiap.cerveja.dto.TokenDTO;
import com.fiap.cerveja.dto.UsuarioCreateDTO;
import com.fiap.cerveja.dto.UsuarioDTO;
import com.fiap.cerveja.entity.Usuario;
import com.fiap.cerveja.repository.UsuarioRepository;
import com.fiap.cerveja.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                              PasswordEncoder passwordEncoder,
                              JwtUtil jwtUtil,
                              AuthenticationManager authenticationManager) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public UsuarioDTO cadastrar(UsuarioCreateDTO usuarioCreateDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioCreateDTO.getNome());

        String senhaCriptografada = passwordEncoder.encode(usuarioCreateDTO.getSenha());
        usuario.setSenha(senhaCriptografada);

        Usuario usuarioCadastrado = usuarioRepository.save(usuario);

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuarioCadastrado.getId());
        usuarioDTO.setNome(usuarioCadastrado.getNome());

        return usuarioDTO;
    }

    @Override
    public TokenDTO login(AuthDTO authDTO) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authDTO.getNome(), authDTO.getSenha());

        try {
            authenticationManager.authenticate(authenticationToken);
        } catch (DisabledException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário desabilitado");
        } catch (BadCredentialsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Credenciais inválidas");
        }

        String token = jwtUtil.gerarToken(authDTO.getNome());

        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setToken(token);

        return tokenDTO;
    }

}
