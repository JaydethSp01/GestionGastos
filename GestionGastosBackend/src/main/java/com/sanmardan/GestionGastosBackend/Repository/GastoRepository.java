package com.sanmardan.GestionGastosBackend.Repository;

import com.sanmardan.GestionGastosBackend.Model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gasto, Integer> {
}
