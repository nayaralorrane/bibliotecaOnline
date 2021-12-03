package br.gov.sp.fatec.bibliotecaOnline.Services;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Livro;
import java.util.List;

public interface LivroService {
    public Livro createLivro(String nomeTitulo, String editora, Double preco, String autor, String sessao, Integer idBiblioteca , List<String> categorias);
    public Livro readLivro(Integer id);
    public Livro updateLivro(Integer id, String nomeTitulo, String editora, Double preco);
    public Boolean deleteLivro(Integer id);
    public List<Livro> getByAutorAndSessao(Integer idAutor, Integer idSessao);
    public List<Livro> getAllLivro();
    public List<Livro> getLivroBySearch(String search);
    public List<Livro> getLivroBySearchCategoria(String search);
    public List<Livro> getLivroBySearchAutor(String search);
    
}
