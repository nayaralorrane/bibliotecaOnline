package br.gov.sp.fatec.bibliotecaOnline.Respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{
    public Livro findByNomeTitulo(String nomeTitulo);

    @Query("SELECT l FROM Livro l INNER JOIN  l.autor a INNER JOIN l.sessao s WHERE a.idAutor = :idAutor AND s.idSessao = :idSessao")
    public List<Livro> findAllByAutorAndSessao(Integer idAutor, Integer idSessao);

}
