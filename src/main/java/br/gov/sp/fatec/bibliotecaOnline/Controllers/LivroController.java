package br.gov.sp.fatec.bibliotecaOnline.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.bibliotecaOnline.Services.LivroService;
import br.gov.sp.fatec.bibliotecaOnline.Entities.Livro;
import br.gov.sp.fatec.bibliotecaOnline.Entities.View;
import br.gov.sp.fatec.bibliotecaOnline.Entities.RequestModels.LivroRequest;
import br.gov.sp.fatec.bibliotecaOnline.Entities.RequestModels.NomeTituloRequest;

@RestController
@CrossOrigin
@RequestMapping(value = "/livro")
public class LivroController{

    @Autowired
    private LivroService livroService;

    @PostMapping(value = "/register", consumes = MediaType.ALL_VALUE)
    @JsonView(View.LivroCompleto.class)
    public Livro CreateLivro(@RequestBody LivroRequest request){
       return livroService.createLivro(request.getLivro().getNomeTitulo(), request.getLivro().getEditora(), request.getLivro().getPreco(), request.getAutor().getAutNome(), request.getSessao().getNomeSessao(), request.getSessao().getBiblioteca().getIdBiblioteca(), request.getCategorias());
    }

    @GetMapping(value = "/")
    @JsonView(View.LivroResumo.class)
    public List<Livro> GetAllLivro(){
        return livroService.getAllLivro();
    }

    @GetMapping(value = "/{id}")
    @JsonView(View.LivroCompleto.class)
    public Livro GetLivro(@PathVariable(value = "id") Integer id){
        return livroService.readLivro(id);
    }

    @PostMapping(value = "/search")
    @JsonView(View.LivroCompleto.class)
    public List<Livro> GetLivroBySearch(@RequestBody NomeTituloRequest search){
        return livroService.getLivroBySearch(search.getSearch());
    }

    @DeleteMapping(value = "/{id}")
    public Boolean DeleteLivro(@PathVariable(value = "id") Integer id){
        return livroService.deleteLivro(id);
    }

    @PutMapping(value = "/update", consumes = MediaType.ALL_VALUE)
    @JsonView(View.LivroCompleto.class)
    public Livro UpdateLivro(@RequestBody Livro request){
       return livroService.updateLivro(request.getIdLivro(), request.getNomeTitulo(), request.getEditora(), request.getPreco());
    }
}