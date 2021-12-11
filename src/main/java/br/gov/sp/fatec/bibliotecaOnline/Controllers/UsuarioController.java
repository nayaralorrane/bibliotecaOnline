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
import org.springframework.http.HttpStatus;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Usuario;
import br.gov.sp.fatec.bibliotecaOnline.Entities.View;
import br.gov.sp.fatec.bibliotecaOnline.Entities.RequestModels.LoginRequest;
import br.gov.sp.fatec.bibliotecaOnline.Entities.RequestModels.UsuarioRequest;
import br.gov.sp.fatec.bibliotecaOnline.Security.JwtUtils;
import br.gov.sp.fatec.bibliotecaOnline.Services.UsuarioService;
import br.gov.sp.fatec.bibliotecaOnline.Exceptions.ExceedTentativasException;
import br.gov.sp.fatec.bibliotecaOnline.Exceptions.UserNotFoundException;


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
    public LoginRequest LoginUsuario(@RequestBody LoginRequest request) throws JsonProcessingException, ExceedTentativasException, UserNotFoundException  {
        Authentication auth = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha());
        Usuario user = usuarioService.getUsuarioByEmail(request.getEmail());
        
        if(user == null) {
            throw new UserNotFoundException("Usuário não existente");
        }

        if(user.getTentativa() >= 3) {
            throw new ExceedTentativasException("Usuário ultrapassou o limite de tentativas");
        }

        try {
            auth = authManager.authenticate(auth);
            usuarioService.resetTetativa(user);
        } catch(Exception error) {
            usuarioService.incrementTetativa(user);
            Integer tentativa = new Integer(3 - user.getTentativa());
            if (tentativa == 0) {
                throw new ExceedTentativasException("Senha incorreta, usuário bloqueado, contate o administrador");
            }
            throw new ExceedTentativasException("Senha incorreta, tentativas restantes = " + tentativa.toString());
        }

        request.setNome(user.getNome());
        request.setSenha(null);
        request.setToken(JwtUtils.generateToken(auth));
        request.setPermissao(auth.getAuthorities().toArray()[0].toString());
        return request;
    }
}

