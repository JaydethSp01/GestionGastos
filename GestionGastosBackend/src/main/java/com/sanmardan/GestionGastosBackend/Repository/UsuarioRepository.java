package com.sanmardan.GestionGastosBackend.Repository;

import com.sanmardan.GestionGastosBackend.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
