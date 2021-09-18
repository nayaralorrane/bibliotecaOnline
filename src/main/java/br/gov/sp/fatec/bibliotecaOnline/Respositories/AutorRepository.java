package br.gov.sp.fatec.bibliotecaOnline.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer>{
    public Autor findByAutNome(String autNome);

    @Query("SELECT a FROM Autor a INNER JOIN a.livros l WHERE l.idLivro = :idLivro")
    public Autor findByLivro(Integer idLivro);
}

