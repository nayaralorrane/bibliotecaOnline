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

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "sessao")
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sessao")
    @JsonView({ View.LivroCompleto.class, View.AutorCompleto.class })
    private Integer idSessao;

    @Column(name = "nome_sessao")
    @JsonView({ View.LivroCompleto.class, View.AutorCompleto.class })
    private String nomeSessao;

    @Column(name = "estante")
    @JsonView({ View.LivroCompleto.class, View.AutorCompleto.class })
    private Integer estante;

    @Column(name = "prateleira")
    @JsonView({ View.LivroCompleto.class, View.AutorCompleto.class })
    private Integer prateleira;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sessao")
    private Set<Livro> livros;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "id_biblioteca")
    @JsonView({ View.LivroCompleto.class, View.AutorCompleto.class })
    private Biblioteca biblioteca;


    public Sessao (){

    }


    public Integer getIdSessao() {
        return idSessao;
    }


    public void setIdSessao(Integer idSessao) {
        this.idSessao = idSessao;
    }


    public String getNomeSessao() {
        return nomeSessao;
    }


    public void setNomeSessao(String nomeSessao) {
        this.nomeSessao = nomeSessao;
    }


    public Integer getEstante() {
        return estante;
    }


    public void setEstante(Integer estante) {
        this.estante = estante;
    }


    public Integer getPrateleira() {
        return prateleira;
    }


    public void setPrateleira(Integer prateleira) {
        this.prateleira = prateleira;
    }


    public Set<Livro> getLivros() {
        return livros;
    }


    public void setLivros(Set<Livro> livros) {
        this.livros = livros;
    }


    public Biblioteca getBiblioteca() {
        return biblioteca;
    }


    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

}