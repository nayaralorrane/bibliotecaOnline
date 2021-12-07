package br.gov.sp.fatec.bibliotecaOnline.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Biblioteca;
import br.gov.sp.fatec.bibliotecaOnline.Entities.View;
import br.gov.sp.fatec.bibliotecaOnline.Services.BibliotecaService;


@RestController
@CrossOrigin
@RequestMapping(value = "/biblioteca")
public class BibliotecaController { 

    @Autowired
    private BibliotecaService bibliotecaService;

    @GetMapping(value = "/")
    @JsonView(View.Biblioteca.class)
    public List<Biblioteca> GetAll() {
        return bibliotecaService.getAllBiblioteca();
    }

}