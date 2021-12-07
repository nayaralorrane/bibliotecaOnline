package br.gov.sp.fatec.bibliotecaOnline.Controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Usuario;
import br.gov.sp.fatec.bibliotecaOnline.Entities.View;
import br.gov.sp.fatec.bibliotecaOnline.Entities.RequestModels.LoginRequest;
import br.gov.sp.fatec.bibliotecaOnline.Entities.RequestModels.UsuarioRequest;
import br.gov.sp.fatec.bibliotecaOnline.Security.JwtUtils;
import br.gov.sp.fatec.bibliotecaOnline.Services.UsuarioService;


@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping(value = "/register")
    @JsonView(View.Usuario.class)
    public Usuario CreateUsuario(@RequestBody UsuarioRequest request){
        return usuarioService.createUsuario(request.nome, request.email, request.documento, request.senha, request.permissao);
    }

    @GetMapping(value = "/{id}")
    @JsonView(View.Usuario.class)
    public Usuario GetUsuario(@PathVariable(value = "id") Integer id){
        return usuarioService.readUsuario(id);
    }

    @PostMapping(value = "/login")
    public LoginRequest LoginUsuario(@RequestBody LoginRequest request) throws JsonProcessingException, Exception  {
        Authentication auth = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha());
        Usuario user = usuarioService.getUsuarioByEmail(request.getEmail());
        
        if(user == null) {
            throw new Exception("Usuário não existente");
        }

        if(user.getTentativa() >= 3) {
            throw new Exception("Usuário ultrapassou o limite de tentativas");
        }

        try {
            auth = authManager.authenticate(auth);
        } catch(Exception error) {
            usuarioService.incrementTetativa(user);
            throw error;
        }

        request.setNome(user.getNome());
        request.setSenha(null);
        request.setToken(JwtUtils.generateToken(auth));
        request.setPermissao(auth.getAuthorities().toArray()[0].toString());
        return request;
    }
}

