package br.gov.sp.fatec.bibliotecaOnline.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/livro")
public class LivroController{

    @Autowired
    private LivroService livroService;

    @PostMapping(value = "/register")
    public Livro CreateLivro(@RequestBody LivroRequest request){
        return livroService.createLivro(request.GetLivro().GetNomeTitulo(), request.GetLivro().GetEditora(), request.GetLivro().GetPreco(), request.GetAutor().GetAutNome(), request.GetSessao().GetNomeSessao(), request.GetCategorias());
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