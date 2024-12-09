package com.sanmardan.GestionGastosBackend.ServicesImpl;

import com.sanmardan.GestionGastosBackend.Model.Gasto;
import com.sanmardan.GestionGastosBackend.Repository.GastoRepository;
import com.sanmardan.GestionGastosBackend.Services.GastoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoServiceImpl implements GastoService {

    private final GastoRepository gastoRepository;

    public GastoServiceImpl(GastoRepository gastoRepository) {
        this.gastoRepository = gastoRepository;
    }

    @Override
    public List<Gasto> listarGastos() {
        return gastoRepository.findAll();
    }

    @Override
    public Gasto buscarGastoPorId(int id) {
        return gastoRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Gasto no encontrado con ID: " + id));
    }

    @Override
    public Gasto crearGasto(Gasto gasto) {
        return gastoRepository.save(gasto);
    }

    @Override
    public Gasto actualizarGasto(int id, Gasto gasto) {
        Gasto gastoExistente = buscarGastoPorId(id);
        gastoExistente.setIdUsuario(gasto.getIdUsuario());
        gastoExistente.setIdCategoria(gasto.getIdCategoria());
        gastoExistente.setMonto(gasto.getMonto());
        gastoExistente.setDescripcion(gasto.getDescripcion());
        gastoExistente.setFechaGasto(gasto.getFechaGasto());
        return gastoRepository.save(gastoExistente);
    }

    @Override
    public void eliminarGasto(int id) {
        gastoRepository.deleteById(id);
    }
}
