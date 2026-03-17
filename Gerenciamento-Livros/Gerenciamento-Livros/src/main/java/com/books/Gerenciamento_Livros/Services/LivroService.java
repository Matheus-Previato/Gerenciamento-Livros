package com.books.Gerenciamento_Livros.Services;

import com.books.Gerenciamento_Livros.Models.LivroModel;
import com.books.Gerenciamento_Livros.Repositories.LivroRepository; // Certifique-se de que o pacote do Repository está com este nome
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public LivroModel salvar(LivroModel livro) {
        return repository.save(livro);
    }


    public List<LivroModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<LivroModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}