package com.sanmardan.GestionGastosBackend.Repository;

import com.sanmardan.GestionGastosBackend.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
