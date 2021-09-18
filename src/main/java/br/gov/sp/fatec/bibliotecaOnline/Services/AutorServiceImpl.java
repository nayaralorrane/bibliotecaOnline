package br.gov.sp.fatec.bibliotecaOnline.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.bibliotecaOnline.Entities.Autor;
import br.gov.sp.fatec.bibliotecaOnline.Exceptions.NotFoundException;
import br.gov.sp.fatec.bibliotecaOnline.Respositories.AutorRepository;

@Service(value = "autorService")
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public Autor createAutor(String autNome) {
        Autor novoAutor = new Autor(autNome);
        autorRepository.save(novoAutor);
        return novoAutor;
    }

    @Override
    public Autor readAutor(Integer id) {
        Optional<Autor> autorEncontrado = autorRepository.findById(id);
        if (autorEncontrado.isEmpty()) {
            throw new NotFoundException("Autor não encontrado");
        }
        return autorEncontrado.get();
    }

    @Override
    public Autor updateAutor(Integer id, String autNome) {
        Optional<Autor> autorOptional = autorRepository.findById(id);
        if (autorOptional.isEmpty()) {
            throw new NotFoundException("Autor não encontrado");
        }
        Autor autorEncontrado = autorOptional.get();
        autorEncontrado.setAutNome(autNome);
        autorRepository.save(autorEncontrado);
        return autorEncontrado;
    }

    @Override
    public Boolean deleteAutor(Integer id) {
        Optional<Autor> autorEncontrado = autorRepository.findById(id);
        if (autorEncontrado.isEmpty()) {
            throw new NotFoundException("Autor não encontrado");
        }
        autorRepository.delete(autorEncontrado.get());

        return true;
    }

    @Override
    public Autor getByLivro(Integer idLivro) {
        Autor autorEncontrado = autorRepository.findByLivro(idLivro);
        if (autorEncontrado == null) {
            throw new NotFoundException("Autor não encontrado");
        }
        return autorEncontrado;
    }

    @Override
    public List<Autor> getAllAutor() {
        return autorRepository.findAll();
    }
    
}
