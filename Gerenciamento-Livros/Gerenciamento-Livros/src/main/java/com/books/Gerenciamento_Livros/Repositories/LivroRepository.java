package com.books.Gerenciamento_Livros.Repositories;

import com.books.Gerenciamento_Livros.Models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {

}