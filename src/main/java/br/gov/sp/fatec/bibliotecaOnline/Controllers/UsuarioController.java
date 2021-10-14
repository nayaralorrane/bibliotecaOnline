package br.gov.sp.fatec.bibliotecaOnline.Controllers;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Usuario;
import br.gov.sp.fatec.bibliotecaOnline.Entities.RequestModels.UsuarioRequest;
import br.gov.sp.fatec.bibliotecaOnline.Services.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/register")
    @JsonView()
    public Usuario CreateUsuario(@RequestBody UsuarioRequest request){
        return usuarioService.createUsuario(request.nome, request.email, request.documento, request.senha, request.permissao);
    }

    @GetMapping(value = "/{id}")
    @JsonView()
    public Usuario GetUsuario(@PathVariable(value = "id") Integer id){
        return usuarioService.readUsuario(id);
    }

    @PostMapping(value = "/login")
    @JsonView()
    public Usuario LoginUsuario(@RequestBody LoginRequest request){
        return usuarioService.LoginUsuario(request.email, request.senha);
    }
}

