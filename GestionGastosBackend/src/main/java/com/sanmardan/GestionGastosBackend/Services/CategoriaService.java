package com.sanmardan.GestionGastosBackend.Services;

import com.sanmardan.GestionGastosBackend.Model.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> listarCategorias();
    Categoria buscarCategoriaPorId(int id);
    Categoria crearCategoria(Categoria categoria);
    Categoria actualizarCategoria(int id, Categoria categoria);
    void eliminarCategoria(int id);
}
