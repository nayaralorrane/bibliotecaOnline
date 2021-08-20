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
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer IdCategoria;

    @Column(name = "nome_categoria")
    private String NomeCategoria;

    @ManytoMany(fetch = FetchType.LAZY, mappedBy = "Categorias")
    private Set<Livro> Livros;

    public Autor (){

    }

    public Set<Livro> GetLivros(){
        return this.Livros;
    }

    public void SetLivros (Set<Livro> livros){
        this.Livros = livros;
    }



    public Integer GetIdCategoria (){
        return this.IdCategoria;
    }

    public void SetIdCategoria (Integer id){
        this.IdCategoria = id;
    }

    public String GetNomeCategoria (){
        return this.NomeCategoria;
    }

    public void SetNomeCategoria (String nomeCategoria) {
        this.NomeCategoria = nomeCategoria;
    }
}
