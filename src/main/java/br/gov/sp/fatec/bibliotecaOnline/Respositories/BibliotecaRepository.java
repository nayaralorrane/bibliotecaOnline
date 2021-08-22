package br.gov.sp.fatec.bibliotecaOnline.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Biblioteca;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Integer>{
    public Biblioteca findByNomeBiblioteca(String nomeBiblioteca);

}

