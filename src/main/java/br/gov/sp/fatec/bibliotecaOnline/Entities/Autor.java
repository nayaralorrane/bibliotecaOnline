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

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    private Integer idAutor;

    @Column(name = "aut_nome")
    private String autNome;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "autor")
    private Set<Livro> livros;

    public Autor (){

    }

    public Set<Livro> GetLivros() {
        return this.livros;
    }

    public void SetLivros(Set<Livro> livros) {
        this.livros = livros;
    }


    public Integer GetIdAutor (){
        return this.idAutor;
    }

    public void SetIdAutor (Integer id){
        this.idAutor = id;
    }

    public String GetAutNome (){
        return this.autNome;
    }

    public void SetAutNome (String autNome) {
        this.autNome = autNome;
    }
}
