package br.gov.sp.fatec.bibliotecaOnline.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Categoria;
import br.gov.sp.fatec.bibliotecaOnline.Entities.Livro;
import br.gov.sp.fatec.bibliotecaOnline.Entities.Sessao;
import br.gov.sp.fatec.bibliotecaOnline.Entities.Autor;

import br.gov.sp.fatec.bibliotecaOnline.Respositories.CategoriaRepository;
import br.gov.sp.fatec.bibliotecaOnline.Respositories.LivroRepository;
import br.gov.sp.fatec.bibliotecaOnline.Respositories.SessaoRepository;
import br.gov.sp.fatec.bibliotecaOnline.Respositories.AutorRepository;


import java.util.HashSet;
import java.util.List;

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
    private AutorRepository autorRepository;

    @Override
    @Transactional
    public Livro createLivro(String nomeTitulo, String editora, Float preco, String autor, String sessao, List<String> categorias) {
        HashSet<Categoria> listaCategorias = new HashSet<Categoria>();
        for (String categoria : categorias) {
            Categoria categoriaEscolhida = categoriaRepository.findByNomeCategoria(categoria);
            if (categoriaEscolhida == null){
                categoriaEscolhida = new Categoria();
                categoriaEscolhida.SetNomeCategoria(categoria);
                categoriaRepository.save(categoriaEscolhida);
            } 
            listaCategorias.add(categoriaEscolhida);
        }

        Sessao sessaoEscolhida = sessaoRepository.findByNomeSessao(sessao);
        if(sessaoEscolhida == null) {
            sessaoEscolhida = new Sessao();
            sessaoEscolhida.SetNomeSessao(sessao);
            sessaoRepository.save(sessaoEscolhida);
        }

        Autor autorEscolhido = autorRepository.findByAutNome(autor);
        if(autorEscolhido == null){
            autorEscolhido = new Autor();
            autorEscolhido.SetAutNome(autor);
            autorRepository.save(autorEscolhido);
        }

        Livro novoLivro = new Livro(nomeTitulo, editora, preco);
        novoLivro.SetCategorias(listaCategorias);
        novoLivro.SetSessao(sessaoEscolhida);
        novoLivro.SetAutor(autorEscolhido);
        livroRepository.save(novoLivro);
        return novoLivro;
    }

    @Override
    public Livro readLivro(Integer id) {
        return livroRepository.findById(id).get();
    }

    @Override
    public Livro updateLivro(Integer id, String nomeTitulo, String editora, Float preco) {
        Livro livro = livroRepository.findById(id).get();
        livro.SetNomeTitulo(nomeTitulo);
        livro.SetEditora(editora);
        livro.SetPreco(preco);
        livroRepository.save(livro);
        return livro;
    }

    @Override
    public Boolean deleteLivro(Integer id) {
        livroRepository.deleteById(id);
        Livro livro = livroRepository.findById(id).get();
        if(livro == null) return true;
        return false;
    }
    
}
