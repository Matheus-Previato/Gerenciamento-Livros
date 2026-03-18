package com.books.Gerenciamento_Livros.Controllers;

import com.books.Gerenciamento_Livros.Models.LivroModel;
import com.books.Gerenciamento_Livros.Services.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    
    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    //POST - criar novo livro
    @PostMapping
    public ResponseEntity<LivroModel> criar(@RequestBody LivroModel livro) {
        // Retorna Status 201 (Created)
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(livro));
    }

    //GET - listar todos os livros
    @GetMapping
    public ResponseEntity<List<LivroModel>> listar() {
        // Retorna Status 200 (OK)
        return ResponseEntity.ok(service.listarTodos());
    }

    //GET - buscar livro por ID
    @GetMapping("/{id}")
    public ResponseEntity<LivroModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok) // Se achar, retorna 200 (OK)
                .orElse(ResponseEntity.notFound().build()); // Se não achar, retorna 404 (Not Found)
    }

    //DELETE /livros/{id} - deletar livro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        // Retorna Status 204 (No Content)
        return ResponseEntity.noContent().build();
    }
}