package br.gov.sp.fatec.bibliotecaOnline.Controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.bibliotecaOnline.Services.AutorService;
import br.gov.sp.fatec.bibliotecaOnline.Entities.Autor;
import br.gov.sp.fatec.bibliotecaOnline.Entities.View;

@RestController
@CrossOrigin
@RequestMapping(value = "/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping(value = "/register")
    @JsonView(View.AutorCompleto.class)
    public Autor CreateAutor(@RequestBody Autor autor) {
        return autorService.createAutor(autor.getAutNome());
    }

    @GetMapping(value = "/")
    @JsonView(View.AutorResumo.class)
    public List<Autor> GetAllAutor(){
        return autorService.getAllAutor();
    }

    @GetMapping(value = "/{id}")
    @JsonView(View.AutorCompleto.class)
    public Autor GetAutorById(@PathVariable(value = "id") Integer id){
        return autorService.readAutor(id);
    }

    @GetMapping(value = "/byLivro/{id}")
    @JsonView(View.AutorCompleto.class)
    public Autor GetAutorByLivro(@PathVariable(value = "id") Integer id){
        return autorService.getByLivro(id);
    }

    @DeleteMapping(value = "/{id}")
    public Boolean DeleteAutor(@PathVariable(value = "id") Integer id){
        return autorService.deleteAutor(id);
    }

    @PutMapping(value = "/update")
    @JsonView(View.AutorCompleto.class)
    public Autor UpdateAutor(@RequestBody Autor autor){
        return autorService.updateAutor(autor.getIdAutor(), autor.getAutNome());
    }
}
