package br.gov.sp.fatec.bibliotecaOnline.Services;

import java.util.List;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Categoria;

public interface CategoriaService {
    public Categoria createCategoria(String nomeCategoria);
    public Categoria readCategoria(Integer id);
    public Categoria updateCategoria(Integer id, String nomeCategoria);
    public Boolean deleteCategoria(Integer id);
    public List<Categoria> getAllCategoria();
}
