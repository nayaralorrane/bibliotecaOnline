package br.gov.sp.fatec.bibliotecaOnline.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.Set;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    @JsonView({ 
        View.LivroCompleto.class, 
        View.AutorCompleto.class,
        View.CategoriaResumo.class 
    })
    private Integer idCategoria;

    @Column(name = "nome_categoria")
    @JsonView({ 
        View.LivroCompleto.class, 
        View.AutorCompleto.class,
        View.CategoriaResumo.class 
    })
    private String nomeCategoria;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categorias")
    @JsonView(View.CategoriaCompleto.class )
    private Set<Livro> livros;

    public Categoria(){

    }

    public Categoria(String nomeCategoria){
        this.nomeCategoria = nomeCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Set<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Set<Livro> livros) {
        this.livros = livros;
    }

}