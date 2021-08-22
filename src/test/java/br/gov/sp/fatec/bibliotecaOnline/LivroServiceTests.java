package br.gov.sp.fatec.bibliotecaOnline;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import br.gov.sp.fatec.bibliotecaOnline.Services.LivroService;
import br.gov.sp.fatec.bibliotecaOnline.Entities.Livro;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Rollback
class LivroServiceTests {
    @Autowired
    private LivroService livroService;

    @Test
    void createLivroTest(){
        List<String> categorias = new ArrayList<String>();
        categorias.add("Comedia");
        categorias.add("Aventura");
        categorias.add("Misterio");
        Livro livro = livroService.createLivro("Kiara aventureira", "Nayara", 120.00, "Nayara", "A", categorias);
        assertNotNull(livro);
    }

    @Test
    void getLivroByAutorAndSessao(){
        List<Livro> livrosEncontrados = livroService.getByAutorAndSessao(1, 1);
        assertNotNull(livrosEncontrados);
    }
}
