package com.sanmardan.GestionGastosBackend.Repository;

import com.sanmardan.GestionGastosBackend.Model.Presupuesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresupuestoRepository extends JpaRepository<Presupuesto, Integer> {
}
