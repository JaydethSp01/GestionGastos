package com.sanmardan.GestionGastosBackend.Services;

import com.sanmardan.GestionGastosBackend.Model.Gasto;
import java.util.List;

public interface GastoService {
    List<Gasto> listarGastos();
    Gasto buscarGastoPorId(int id);
    Gasto crearGasto(Gasto gasto);
    Gasto actualizarGasto(int id, Gasto gasto);
    void eliminarGasto(int id);
}
