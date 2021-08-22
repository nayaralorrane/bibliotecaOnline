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

@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livro")
    private Integer idLivro;

    @Column(name = "titulo")
    private String nomeTitulo;

    @Column(name = "editora")
    private String editora;

    @Column(name = "preco")
    private Double preco;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "id_autor")
    private Autor autor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "id_sessao")
    private Sessao sessao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "livro_categoria", 
        joinColumns = {@JoinColumn(name = "id_livro")},
        inverseJoinColumns = {@JoinColumn(name = "id_categoria")})
    private Set<Categoria> categorias;



    public Livro (){

    }

    public Livro (String nomeTitulo, String editora, Double preco){
        this.nomeTitulo = nomeTitulo;
        this.editora = editora;
        this.preco = preco;
    }


    public Set<Categoria> GetCategorias (){
        return this.categorias;
    }

    public void SetCategorias(Set<Categoria> categorias){
        this.categorias =  categorias;
    }


    public Sessao GetSessao (){
        return this.sessao;
    }

    public void SetSessao(Sessao sessao){
        this.sessao =  sessao;
    }

    public Autor GetAutor (){
        return this.autor;
    }

    public void SetAutor(Autor autor){
        this.autor =  autor;
    }

    public Integer GetIdLivro (){
        return this.idLivro;
    }

    public void SetIdLivro (Integer id){
        this.idLivro = id;
    }

    public String GetNomeTitulo (){
        return this.nomeTitulo;
    }

    public void SetNomeTitulo (String titulo) {
        this.nomeTitulo = titulo;
    }

    public String GetEditora (){
        return this.editora;
    }

    public void SetEditora (String editora) {
        this.editora = editora;
    }

    public Double GetPreco (){
        return this.preco;
    }

    public void SetPreco (Double preco) {
        this.preco = preco;
    }


    
}
