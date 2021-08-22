package br.gov.sp.fatec.bibliotecaOnline.Services;

import com.fasterxml.jackson.core.sym.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Usuario;
import br.gov.sp.fatec.bibliotecaOnline.Entities.Permissoes;
import br.gov.sp.fatec.bibliotecaOnline.Respositories.UsuarioRepository;
import br.gov.sp.fatec.bibliotecaOnline.Respositories.PermissoesRepository;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private PermissoesRepository permissoesRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario createUsuario(String nome, String email, String documento, String senha, String permissao) {
        Permissoes permissaoEscolhida = permissoesRepository.findByNomePermissao(permissao);
        if(permissaoEscolhida == null) return null;

        Usuario novoUsuario = new Usuario(nome, email, documento, senha);
        novoUsuario.SetPermissao(permissaoEscolhida);

        usuarioRepository.save(novoUsuario);
        return novoUsuario;
    }

    @Override
    public Usuario readUsuario(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).get();
    }

    @Override
    public Usuario updateUsuario(Integer idUsuario, String nome, String email, String documento, String senha) {
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        if(usuario == null) return null;
        usuario.SetNome(nome);
        usuario.SetSenha(senha);
        usuario.SetEmail(email);
        usuario.SetDocumento(documento);
        usuarioRepository.save(usuario);
        return usuario;
    }

    @Override
    public Boolean deleteUsuario(Integer idUsuario) {
        usuarioRepository.deleteById(idUsuario);
        Usuario deletedUsuario = usuarioRepository.findById(idUsuario).get();
        if(deletedUsuario == null){
            return true;
        } else {
            return false;
        }
    }
    
}
