package br.gov.sp.fatec.bibliotecaOnline.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Categoria;
import br.gov.sp.fatec.bibliotecaOnline.Entities.Livro;
import br.gov.sp.fatec.bibliotecaOnline.Entities.Sessao;
import br.gov.sp.fatec.bibliotecaOnline.Entities.Autor;
import br.gov.sp.fatec.bibliotecaOnline.Entities.Biblioteca;
import br.gov.sp.fatec.bibliotecaOnline.Respositories.CategoriaRepository;
import br.gov.sp.fatec.bibliotecaOnline.Respositories.LivroRepository;
import br.gov.sp.fatec.bibliotecaOnline.Respositories.SessaoRepository;
import br.gov.sp.fatec.bibliotecaOnline.Respositories.AutorRepository;
import br.gov.sp.fatec.bibliotecaOnline.Respositories.BibliotecaRepository;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service("livroService")
public class LivroServiceImpl implements LivroService{

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Override
    @Transactional
    @PreAuthorize("hasRole('FUNCIONARIO')")
    public Livro createLivro(String nomeTitulo, String editora, Double preco, String autor, String sessao, Integer idBiblioteca, List<String> categorias) {
        HashSet<Categoria> listaCategorias = new HashSet<Categoria>();
        for (String categoria : categorias) {
            Categoria categoriaEscolhida = categoriaRepository.findByNomeCategoria(categoria);
            if (categoriaEscolhida == null){
                categoriaEscolhida = new Categoria();
                categoriaEscolhida.setNomeCategoria(categoria);
                categoriaRepository.save(categoriaEscolhida);
            } 
            listaCategorias.add(categoriaEscolhida);
        }

        Sessao sessaoEscolhida = sessaoRepository.findByNomeSessao(sessao);
        Optional<Biblioteca> bibliotecaEscolhida = bibliotecaRepository.findById(idBiblioteca);
        if(bibliotecaEscolhida.isEmpty()) {
            return null;
        }

        if(sessaoEscolhida == null) {
            sessaoEscolhida = new Sessao();
            sessaoEscolhida.setNomeSessao(sessao);
            sessaoEscolhida.setBiblioteca(bibliotecaEscolhida.get());
            sessaoRepository.save(sessaoEscolhida);
        }

        Autor autorEscolhido = autorRepository.findByAutNome(autor);
        if(autorEscolhido == null){
            autorEscolhido = new Autor();
            autorEscolhido.setAutNome(autor);
            autorRepository.save(autorEscolhido);
        }

        Livro novoLivro = new Livro(nomeTitulo, editora, preco);
        novoLivro.setCategorias(listaCategorias);
        novoLivro.setSessao(sessaoEscolhida);
        novoLivro.setAutor(autorEscolhido);
        livroRepository.save(novoLivro);
        return novoLivro;
    }

    @Override
    @PreAuthorize("isAutheticated()")
    public Livro readLivro(Integer id) {
        return livroRepository.findById(id).get();
    }

    @Override
    @PreAuthorize("hasRole('FUNCIONARIO')")
    public Livro updateLivro(Integer id, String nomeTitulo, String editora, Double preco) {
        Livro livro = livroRepository.findById(id).get();
        livro.setNomeTitulo(nomeTitulo);
        livro.setEditora(editora);
        livro.setPreco(preco);
        livroRepository.save(livro);
        return livro;
    }

    @Override
    @PreAuthorize("hasRole('FUNCIONARIO')")
    public Boolean deleteLivro(Integer id) {
        livroRepository.deleteById(id);
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.isEmpty();
    }

    @Override
    @PreAuthorize("isAutheticated()")
    public List<Livro> getByAutorAndSessao(Integer idAutor, Integer idSessao){
        return livroRepository.findAllByAutorAndSessao(idAutor, idSessao);
    }

    @Override
    @PreAuthorize("isAutheticated()")
    public List<Livro> getAllLivro() {
        return livroRepository.findAll();
    }
    
}
