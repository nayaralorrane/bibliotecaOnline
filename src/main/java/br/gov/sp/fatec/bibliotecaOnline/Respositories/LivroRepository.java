package br.gov.sp.fatec.bibliotecaOnline.Respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{
    public Livro findByNomeTitulo(String nomeTitulo);

    @Query("SELECT l FROM Livro l INNER JOIN  l.Autor a INNER JOIN l.Sessao s WHERE a.IdAutor = :idAutor AND s.IdSessao = :idSessao")
    public List<Livro> findAllByAutorAndSessao(Integer idAutor, Integer idSessao);

}
