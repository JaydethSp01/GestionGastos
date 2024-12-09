package com.sanmardan.GestionGastosBackend.Controller;

import com.sanmardan.GestionGastosBackend.Model.Gasto;
import com.sanmardan.GestionGastosBackend.Services.GastoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/gastos")
public class GastoController {

    private final GastoService gastoService;

    public GastoController(GastoService gastoService) {
        this.gastoService = gastoService;
    }

    @GetMapping("/get")
    public List<Gasto> listarGastos() {
        return gastoService.listarGastos();
    }

    @GetMapping("/get/{id}")
    public Gasto buscarGastoPorId(@PathVariable int id) {
        return gastoService.buscarGastoPorId(id);
    }

    @PostMapping("/create")
    public Gasto crearGasto(@RequestBody Gasto gasto) {
        return gastoService.crearGasto(gasto);
    }

    @PutMapping("/update/{id}")
    public Gasto actualizarGasto(@PathVariable int id, @RequestBody Gasto gasto) {
        return gastoService.actualizarGasto(id, gasto);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarGasto(@PathVariable int id) {
        gastoService.eliminarGasto(id);
    }
}
