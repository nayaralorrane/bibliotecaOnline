package br.gov.sp.fatec.bibliotecaOnline.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Sessao;

public interface SessaoRepository extends JpaRepository<Sessao, Integer>{
    public Sessao findByNomeSessao(String nomeSessao);

}

