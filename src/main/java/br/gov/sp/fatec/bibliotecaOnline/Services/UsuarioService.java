package br.gov.sp.fatec.bibliotecaOnline.Services;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Usuario;

public interface UsuarioService extends UserDetailsService {
    public Usuario createUsuario(String nome, String email, String documento, String senha, String permissao);
    public Usuario readUsuario(Integer idUsuario);
    public Usuario updateUsuario(Integer idUsuario, String nome, String email, String documento, String senha);
    public Boolean deleteUsuario(Integer idUsuario);
}
