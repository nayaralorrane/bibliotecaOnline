package br.gov.sp.fatec.bibliotecaOnline.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "permissoes")
public class Permissoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permissoes")
    private Integer idPermissoes;

    @JsonView(View.Usuario.class)
    @Column(name = "nome_permissao")
    private String nomePermissao;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "permissao")
    private Set<Usuario> usuarios;


    public Permissoes (){

    }


    public Integer getIdPermissoes() {
        return idPermissoes;
    }


    public void setIdPermissoes(Integer idPermissoes) {
        this.idPermissoes = idPermissoes;
    }


    public String getNomePermissao() {
        return nomePermissao;
    }


    public void setNomePermissao(String nomePermissao) {
        this.nomePermissao = nomePermissao;
    }


    public Set<Usuario> getUsuarios() {
        return usuarios;
    }


    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}