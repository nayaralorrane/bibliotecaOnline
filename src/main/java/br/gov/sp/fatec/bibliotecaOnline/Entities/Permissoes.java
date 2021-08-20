package br.gov.sp.fatec.bibliotecaOnline.Entities;

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
    private Integer IdPermissoes;

    @Column(name = "nome_permissao")
    private String NomePermissao;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Permissao")
    private Set<Usuario> Usuarios;


    public Permissoes (){

    }

    public Set<Usuario> GetUsuarios() {
        return this.Usuarios;
    }

    public void SetUsuarios(Set<Usuario> usuarios) {
        this.Usuarios = usuarios;
    }

    public Integer GetIdPermissoes (){
        return this.IdPermissoes;
    }

    public void SetIdPermissoes (Integer id){
        this.IdPermissoes = id;
    }

    public String GetNomePermissao (){
        return this.NomePermissoes;
    }

    public void SetNomePermissao (String nome) {
        this.NomePermissao = nome;
    }
}
