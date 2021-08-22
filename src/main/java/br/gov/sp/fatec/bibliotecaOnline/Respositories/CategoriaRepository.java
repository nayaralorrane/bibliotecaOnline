package br.gov.sp.fatec.bibliotecaOnline.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    public Categoria findByNomeCategoria(String nomeCategoria);

}