package br.gov.sp.fatec.bibliotecaOnline.Entities.RequestModels;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Livro;
import br.gov.sp.fatec.bibliotecaOnline.Entities.Autor;
import br.gov.sp.fatec.bibliotecaOnline.Entities.Sessao;

import java.util.List;

public class LivroRequest {
    private Livro livro;
    private Autor autor;
    private Sessao sessao;
    private List<String> categorias;
    public String test;

    public LivroRequest() {

    }

    public LivroRequest(Livro livro, Autor autor, Sessao sessao, List<String> categorias) {
        this.livro = livro;
        this.autor = autor;
        this.sessao = sessao;
        this.categorias = categorias;
    }

    public Livro GetLivro(){
        return this.livro;
    }

    public void SetLivro(Livro livro){
        this.livro = livro;
    }

    public Autor GetAutor(){
        return this.autor;
    }

    public void SetAutor(Autor autor){
        this.autor = autor;
    }

    public Sessao GetSessao(){
        return this.sessao;
    }

    public void SetSessao(Sessao sessao){
        this.sessao = sessao;
    }

    public List<String> GetCategorias(){
        return this.categorias;
    }


    public void SetCategorias(List<String> categorias){
        this.categorias = categorias;
    }
}
