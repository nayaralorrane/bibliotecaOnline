package br.gov.sp.fatec.bibliotecaOnline.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "nome_categoria")
    private String nomeCategoria;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categorias")
    private Set<Livro> livros;

    public Categoria(){

    }

    public Set<Livro> GetLivros(){
        return this.livros;
    }

    public void SetLivros (Set<Livro> livros){
        this.livros = livros;
    }



    public Integer GetIdCategoria (){
        return this.idCategoria;
    }

    public void SetIdCategoria (Integer id){
        this.idCategoria = id;
    }

    public String GetNomeCategoria (){
        return this.nomeCategoria;
    }

    public void SetNomeCategoria (String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
