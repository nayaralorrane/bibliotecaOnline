package br.gov.sp.fatec.bibliotecaOnline.Services;

import java.util.List;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Autor;

public interface AutorService {
    public Autor createAutor(String autNome);
    public Autor readAutor(Integer id);
    public Autor updateAutor(Integer id, String autNome);
    public Boolean deleteAutor(Integer id);
    public Autor getByLivro(Integer idLivro);
    public List<Autor> getAllAutor();
}
