package com.sanmardan.GestionGastosBackend.ServicesImpl;

import com.sanmardan.GestionGastosBackend.Model.Categoria;
import com.sanmardan.GestionGastosBackend.Repository.CategoriaRepository;
import com.sanmardan.GestionGastosBackend.Services.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarCategoriaPorId(int id) {
        return categoriaRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Categoría no encontrada con ID: " + id));
    }

    @Override
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(int id, Categoria categoria) {
        Categoria categoriaExistente = buscarCategoriaPorId(id);
        categoriaExistente.setNombreCategoria(categoria.getNombreCategoria());
        categoriaExistente.setDescripcion(categoria.getDescripcion());
        return categoriaRepository.save(categoriaExistente);
    }

    @Override
    public void eliminarCategoria(int id) {
        categoriaRepository.deleteById(id);
    }
}
