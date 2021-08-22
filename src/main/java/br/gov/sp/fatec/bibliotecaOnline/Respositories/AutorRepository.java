package br.gov.sp.fatec.bibliotecaOnline.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer>{
    public Autor findByAutNome(String autNome);

}

