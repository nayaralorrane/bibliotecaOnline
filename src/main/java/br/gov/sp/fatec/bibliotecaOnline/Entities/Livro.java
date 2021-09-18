package br.gov.sp.fatec.bibliotecaOnline.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livro")
    @JsonView({ View.LivroResumo.class, View.AutorCompleto.class, View.CategoriaCompleto.class })
    private Integer idLivro;

    @Column(name = "titulo")
    @JsonView({ View.LivroResumo.class, View.AutorCompleto.class, View.CategoriaCompleto.class })
    private String nomeTitulo;

    @Column(name = "editora")
    @JsonView({ View.LivroResumo.class, View.AutorCompleto.class, View.CategoriaCompleto.class })
    private String editora;

    @Column(name = "preco")
    @JsonView({ View.LivroResumo.class, View.AutorCompleto.class, View.CategoriaCompleto.class })
    private Double preco;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "id_autor")
    @JsonView(View.LivroResumo.class)
    private Autor autor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "id_sessao")
    @JsonView({ View.LivroResumo.class, View.AutorCompleto.class })
    private Sessao sessao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "livro_categoria", 
        joinColumns = {@JoinColumn(name = "id_livro")},
        inverseJoinColumns = {@JoinColumn(name = "id_categoria")})
    @JsonView({ View.LivroResumo.class, View.AutorCompleto.class })
    private Set<Categoria> categorias;



    public Livro (){

    }

    public Livro (String nomeTitulo, String editora, Double preco){
        this.nomeTitulo = nomeTitulo;
        this.editora = editora;
        this.preco = preco;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeTitulo() {
        return nomeTitulo;
    }

    public void setNomeTitulo(String nomeTitulo) {
        this.nomeTitulo = nomeTitulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }
    
}