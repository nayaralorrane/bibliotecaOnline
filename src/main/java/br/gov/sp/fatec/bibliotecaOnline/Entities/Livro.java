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
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livro")
    private Integer IdLivro;

    @Column(name = "titulo")
    private String NomeTitulo;

    @Column(name = "editora")
    private String Editora;

    @Column(name = "preco")
    private Float Preco;

    @ManytoOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "fk_autor")
    private Autor autor;

    @ManytoOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "fk_sessao")
    private Sessao sessao;

    @ManytoMany(fetch = FetchType.EAGER)
    @JoinTable(name = "livro_categoria", 
        joinColumns = {@JoinColumn(name = "id_livro")},
        inverseJoinColumns = {@JoinColumn(name = "id_categoria")})
    private Set<Categoria> Categorias;



    public Livro (){

    }

    public Set<Categoria> GetCategorias (){
        return this.Categorias;
    }

    public void SetCategorias(Set<Categoria> categorias){
        this.Categorias =  categorias;
    }


    public Sessao GetSessao (){
        return this.Sessao;
    }

    public void SetSessao(Sessao sessao){
        this.Sessao =  sessao;
    }

    public Permissoes GetAutor (){
        return this.Autor;
    }

    public void SetAutor(Autor autor){
        this.Autor =  autor;
    }

    public Integer GetIdLivro (){
        return this.IdLivro;
    }

    public void SetIdLivro (Integer id){
        this.IdLivro = id;
    }

    public String GetNomeTitulo (){
        return this.NomeTitulo;
    }

    public void SetNomeTitulo (String titulo) {
        this.NomeTitulo = titulo;
    }

    public String GetEditora (){
        return this.Editora;
    }

    public void SetEditora (String editora) {
        this.Editora = editora;
    }

    public Float GetPreco (){
        return this.Preco;
    }

    public void SetPreco (Float preco) {
        this.Preco = preco;
    }


    
}
