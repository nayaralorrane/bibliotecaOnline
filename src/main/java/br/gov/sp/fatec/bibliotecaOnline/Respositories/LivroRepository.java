package br.gov.sp.fatec.bibliotecaOnline.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{
    public Livro findByNomeTitulo(String nomeTitulo);

}
