package br.gov.sp.fatec.bibliotecaOnline.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Biblioteca;
import br.gov.sp.fatec.bibliotecaOnline.Respositories.BibliotecaRepository;


@Service(value = "bibliotecaService")
public class BibliotecaServiceImpl implements BibliotecaService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    @Override
    public List<Biblioteca> getAllBiblioteca() {
        return bibliotecaRepository.findAll();
    }

}