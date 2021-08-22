package br.gov.sp.fatec.bibliotecaOnline;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.gov.sp.fatec.bibliotecaOnline.Service.LivroService;

@SpringBootTest
public class LivroServiceTests {
    @Autowired
    private LivroService livroService;

    @Test
    void createLivroTest(){
        
    }
}
