package br.gov.sp.fatec.bibliotecaOnline.Entities.RequestModels;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Livro;
import br.gov.sp.fatec.bibliotecaOnline.Entities.Sessao;
import br.gov.sp.fatec.bibliotecaOnline.Entities.Autor;


import java.util.List;

public class LivroRequest {
    private List<String> categorias;
    private Livro livro;
    private Autor autor;
    private Sessao sessao;

    public LivroRequest() {

    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
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
    
}
