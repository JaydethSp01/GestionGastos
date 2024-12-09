package com.sanmardan.GestionGastosBackend.ServicesImpl;

import com.sanmardan.GestionGastosBackend.Model.Presupuesto;
import com.sanmardan.GestionGastosBackend.Repository.PresupuestoRepository;
import com.sanmardan.GestionGastosBackend.Services.PresupuestoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresupuestoServiceImpl implements PresupuestoService {

    private final PresupuestoRepository presupuestoRepository;

    public PresupuestoServiceImpl(PresupuestoRepository presupuestoRepository) {
        this.presupuestoRepository = presupuestoRepository;
    }

    @Override
    public List<Presupuesto> listarPresupuestos() {
        return presupuestoRepository.findAll();
    }

    @Override
    public Presupuesto buscarPresupuestoPorId(int id) {
        return presupuestoRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Presupuesto no encontrado con ID: " + id));
    }

    @Override
    public Presupuesto crearPresupuesto(Presupuesto presupuesto) {
        return presupuestoRepository.save(presupuesto);
    }

    @Override
    public Presupuesto actualizarPresupuesto(int id, Presupuesto presupuesto) {
        Presupuesto presupuestoExistente = buscarPresupuestoPorId(id);
        presupuestoExistente.setIdUsuario(presupuesto.getIdUsuario());
        presupuestoExistente.setIdCategoria(presupuesto.getIdCategoria());
        presupuestoExistente.setMonto(presupuesto.getMonto());
        presupuestoExistente.setFechaInicio(presupuesto.getFechaInicio());
        presupuestoExistente.setFechaFin(presupuesto.getFechaFin());
        return presupuestoRepository.save(presupuestoExistente);
    }

    @Override
    public void eliminarPresupuesto(int id) {
        presupuestoRepository.deleteById(id);
    }
}
