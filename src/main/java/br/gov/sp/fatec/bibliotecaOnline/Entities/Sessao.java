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
@Table(name = "sessao")
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sessao")
    private Integer IdSessao;

    @Column(name = "nome_sessao")
    private String NomeSessao;

    @Column(name = "estante")
    private Integer Estante;

    @Column(name = "prateleira")
    private Integer Prateleira;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sessao")
    private Set<Livro> Livros;

    @ManytoOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "fk_biblioteca")
    private Biblioteca Biblioteca;


    public Sessao (){

    }

    public Biblioteca GetBiblioteca() {
        return this.Biblioteca;
    }

    public void SetBiblioteca(Biblioteca biblioteca) {
        this.Biblioteca = biblioteca;
    }

    public Set<Livro> GetSessao() {
        return this.Sessao;
    }

    public void SetLivros(Set<Livro> sessao) {
        this.Sessao = sessao;
    }

    public Integer GetIdSessao (){
        return this.IdSessao;
    }

    public void SetIdSessao (Integer id){
        this.IdSessao = id;
    }

    public String GetNomeSessao (){
        return this.NomeSessao;
    }

    public void SetNomeSessao (String nome) {
        this.NomeSessao = nome;
    }

    public Integer GetEstante (){
        return this.Estante;
    }

    public void SetEstante (Integer estante) {
        this.Estante = estante;
    }

    public Integer GetPrateleira (){
        return this.Prateleira;
    }

    public void SetPrateleira (Integer prateleira) {
        this.Prateleira = prateleira;
    }
}
