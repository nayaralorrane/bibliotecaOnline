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
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    @JsonView({ View.LivroCompleto.class, View.AutorResumo.class })
    private Integer idAutor;

    @Column(name = "aut_nome")
    @JsonView({ View.LivroCompleto.class, View.AutorResumo.class })
    private String autNome;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "autor")
    @JsonView(View.AutorCompleto.class)
    private Set<Livro> livros;

    public Autor (){

    }

    public Autor (String autNome){
        this.autNome = autNome;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public String getAutNome() {
        return autNome;
    }

    public void setAutNome(String autNome) {
        this.autNome = autNome;
    }

    public Set<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Set<Livro> livros) {
        this.livros = livros;
    }

}

