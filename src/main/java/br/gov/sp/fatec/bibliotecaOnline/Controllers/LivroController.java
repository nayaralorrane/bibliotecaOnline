package br.gov.sp.fatec.bibliotecaOnline.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


import br.gov.sp.fatec.bibliotecaOnline.Services.LivroService;
import br.gov.sp.fatec.bibliotecaOnline.Entities.Livro;
import br.gov.sp.fatec.bibliotecaOnline.Entities.RequestModels.LivroRequest;



@RestController
@CrossOrigin
@RequestMapping(value = "/livro")
public class LivroController{

    @Autowired
    private LivroService livroService;

    @PostMapping(value = "/register", consumes = MediaType.ALL_VALUE)
    public Livro CreateLivro(@RequestBody LivroRequest request){
       return livroService.createLivro(request.getLivro().getNomeTitulo(), request.getLivro().getEditora(), request.getLivro().getPreco(), request.getAutor().getAutNome(), request.getSessao().getNomeSessao(), request.getCategorias());
        
    }

    @GetMapping(value = "/")
    public List<Livro> GetAllLivro(){
        return livroService.getAllLivro();
    }

    @GetMapping(value = "/{id}")
    public Livro GetLivro(@PathVariable(value = "id") Integer id){
        return livroService.readLivro(id);
    }
}