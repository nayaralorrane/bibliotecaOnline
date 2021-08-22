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

@Entity
@Table(name = "permissoes")
public class Permissoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permissoes")
    private Integer idPermissoes;

    @Column(name = "nome_permissao")
    private String nomePermissao;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "permissao")
    private Set<Usuario> usuarios;


    public Permissoes (){

    }

    public Set<Usuario> GetUsuarios() {
        return this.usuarios;
    }

    public void SetUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Integer GetIdPermissoes (){
        return this.idPermissoes;
    }

    public void SetIdPermissoes (Integer id){
        this.idPermissoes = id;
    }

    public String GetNomePermissao (){
        return this.nomePermissao;
    }

    public void SetNomePermissao (String nome) {
        this.nomePermissao = nome;
    }
}
