package br.gov.sp.fatec.bibliotecaOnline.Services;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Livro;
import java.util.List;

public interface LivroService {
    public Livro createLivro(String nomeTitulo, String editora, Float preco, String autor, String sessao, List<String> categorias);
    public Livro readLivro(Integer id);
    public Livro updateLivro(Integer id, String nomeTitulo, String editora, Float preco);
    public Boolean deleteLivro(Integer id);
}
