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
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    private Integer IdAutor;

    @Column(name = "aut_nome")
    private String AutNome;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "autor")
    private Set<Livro> Livros;

    public Autor (){

    }

    public Set<Livro> GetLivros() {
        return this.Livros;
    }

    public void SetLivros(Set<Livro> livros) {
        this.Livros = livros;
    }


    public Integer GetIdAutor (){
        return this.IdAutor;
    }

    public void SetIdAutor (Integer id){
        this.IdAutor = id;
    }

    public String GetAutNome (){
        return this.AutNome;
    }

    public void SetAutNome (String autNome) {
        this.AutNome = autNome;
    }
}
