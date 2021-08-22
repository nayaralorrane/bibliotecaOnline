package br.gov.sp.fatec.bibliotecaOnline.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sessao")
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sessao")
    private Integer idSessao;

    @Column(name = "nome_sessao")
    private String nomeSessao;

    @Column(name = "estante")
    private Integer estante;

    @Column(name = "prateleira")
    private Integer prateleira;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sessao")
    private Set<Livro> livros;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "id_biblioteca")
    private Biblioteca biblioteca;


    public Sessao (){

    }

    public Biblioteca GetBiblioteca() {
        return this.biblioteca;
    }

    public void SetBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Set<Livro> GetSessao() {
        return this.livros;
    }

    public void SetLivros(Set<Livro> livros) {
        this.livros = livros;
    }

    public Integer GetIdSessao (){
        return this.idSessao;
    }

    public void SetIdSessao (Integer id){
        this.idSessao = id;
    }

    public String GetNomeSessao (){
        return this.nomeSessao;
    }

    public void SetNomeSessao (String nome) {
        this.nomeSessao = nome;
    }

    public Integer GetEstante (){
        return this.estante;
    }

    public void SetEstante (Integer estante) {
        this.estante = estante;
    }

    public Integer GetPrateleira (){
        return this.prateleira;
    }

    public void SetPrateleira (Integer prateleira) {
        this.prateleira = prateleira;
    }
}
