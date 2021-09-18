package br.gov.sp.fatec.bibliotecaOnline.Controllers;

import java.util.List;

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

import br.gov.sp.fatec.bibliotecaOnline.Entities.Categoria;
import br.gov.sp.fatec.bibliotecaOnline.Entities.View;
import br.gov.sp.fatec.bibliotecaOnline.Services.CategoriaService;

@RestController
@CrossOrigin
@RequestMapping(value = "/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping(value = "/register")
    @JsonView(View.CategoriaCompleto.class)
    public Categoria CreateCategoria(@RequestBody Categoria categoria){
        return categoriaService.createCategoria(categoria.getNomeCategoria());
    }

    @GetMapping(value = "/")
    @JsonView(View.CategoriaResumo.class)
    public List<Categoria> GetAllCategoria(){
        return categoriaService.getAllCategoria();
    }

    @GetMapping(value = "/{id}")
    @JsonView(View.CategoriaCompleto.class)
    public Categoria GetCategoriaById(@PathVariable(value = "id") Integer id){
        return categoriaService.readCategoria(id);
    }

    @DeleteMapping(value = "/{id}")
    public Boolean DeleteCategoriaById(@PathVariable(value = "id") Integer id){
        return categoriaService.deleteCategoria(id);
    }

    @PutMapping(value = "/update")
    @JsonView(View.CategoriaCompleto.class)
    public Categoria UpdateCategoria(@RequestBody Categoria categoria){
        return categoriaService.updateCategoria(categoria.getIdCategoria(), categoria.getNomeCategoria());
    }

}
