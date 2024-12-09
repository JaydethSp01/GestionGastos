package com.sanmardan.GestionGastosBackend.Controller;

import com.sanmardan.GestionGastosBackend.Model.Categoria;
import com.sanmardan.GestionGastosBackend.Services.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/get")
    public List<Categoria> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    @GetMapping("/get/{id}")
    public Categoria buscarCategoriaPorId(@PathVariable int id) {
        return categoriaService.buscarCategoriaPorId(id);
    }

    @PostMapping("/create")
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return categoriaService.crearCategoria(categoria);
    }

    @PutMapping("/update/{id}")
    public Categoria actualizarCategoria(@PathVariable int id, @RequestBody Categoria categoria) {
        return categoriaService.actualizarCategoria(id, categoria);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarCategoria(@PathVariable int id) {
        categoriaService.eliminarCategoria(id);
    }
}
