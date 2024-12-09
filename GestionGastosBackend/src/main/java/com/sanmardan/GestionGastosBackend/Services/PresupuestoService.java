package com.sanmardan.GestionGastosBackend.Services;

import com.sanmardan.GestionGastosBackend.Model.Presupuesto;
import java.util.List;

public interface PresupuestoService {
    List<Presupuesto> listarPresupuestos();
    Presupuesto buscarPresupuestoPorId(int id);
    Presupuesto crearPresupuesto(Presupuesto presupuesto);
    Presupuesto actualizarPresupuesto(int id, Presupuesto presupuesto);
    void eliminarPresupuesto(int id);
}
