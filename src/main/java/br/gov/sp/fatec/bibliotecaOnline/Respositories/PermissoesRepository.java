package br.gov.sp.fatec.bibliotecaOnline.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Permissoes;

public interface PermissoesRepository extends JpaRepository<Permissoes, Integer>{
    public Permissoes findByNomePermissao(String nomePermissao);

}

