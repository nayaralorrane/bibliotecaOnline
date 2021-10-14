package br.gov.sp.fatec.bibliotecaOnline.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    public Usuario findByNome(String nome);
    public Usuario findByEmail(String email);

}
