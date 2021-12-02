package br.gov.sp.fatec.bibliotecaOnline.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Categoria;
import br.gov.sp.fatec.bibliotecaOnline.Exceptions.NotFoundException;
import br.gov.sp.fatec.bibliotecaOnline.Respositories.CategoriaRepository;

@Service(value = "categoriaService")
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria createCategoria(String nomeCategoria) {
        Categoria novaCategoria = new Categoria(nomeCategoria);
        categoriaRepository.save(novaCategoria);
        return novaCategoria;
    }

    @Override
    public Categoria readCategoria(Integer id) {
        Optional<Categoria> categoriaEncontrada = categoriaRepository.findById(id);
        if(!categoriaEncontrada.isPresent()) {
            throw new NotFoundException("Categoria não encontrada");
        }

        return categoriaEncontrada.get();
    }

    @Override
    public Categoria updateCategoria(Integer id, String nomeCategoria) {
        Optional<Categoria> categoriaEncontrada = categoriaRepository.findById(id);
        if(!categoriaEncontrada.isPresent()) {
            throw new NotFoundException("Categoria não encontrada");
        }
        Categoria categoria = categoriaEncontrada.get();
        categoria.setNomeCategoria(nomeCategoria);
        categoriaRepository.save(categoria);
        return categoria;
    }

    @Override
    public Boolean deleteCategoria(Integer id) {
        Optional<Categoria> categoriaEncontrada = categoriaRepository.findById(id);
        if(!categoriaEncontrada.isPresent()) {
            throw new NotFoundException("Categoria não encontrada");
        }
        categoriaRepository.delete(categoriaEncontrada.get());
        return true;
    }

    @Override
    public List<Categoria> getAllCategoria() {
        return categoriaRepository.findAll();
    }
    
}
