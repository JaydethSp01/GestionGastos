package com.sanmardan.GestionGastosBackend.Controller;

import com.sanmardan.GestionGastosBackend.Model.Presupuesto;
import com.sanmardan.GestionGastosBackend.Services.PresupuestoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/presupuestos")
public class PresupuestoController {

    private final PresupuestoService presupuestoService;

    public PresupuestoController(PresupuestoService presupuestoService) {
        this.presupuestoService = presupuestoService;
    }

    @GetMapping("/get")
    public List<Presupuesto> listarPresupuestos() {
        return presupuestoService.listarPresupuestos();
    }

    @GetMapping("/get/{id}")
    public Presupuesto buscarPresupuestoPorId(@PathVariable int id) {
        return presupuestoService.buscarPresupuestoPorId(id);
    }

    @PostMapping("/create")
    public Presupuesto crearPresupuesto(@RequestBody Presupuesto presupuesto) {
        return presupuestoService.crearPresupuesto(presupuesto);
    }

    @PutMapping("/update/{id}")
    public Presupuesto actualizarPresupuesto(@PathVariable int id, @RequestBody Presupuesto presupuesto) {
        return presupuestoService.actualizarPresupuesto(id, presupuesto);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarPresupuesto(@PathVariable int id) {
        presupuestoService.eliminarPresupuesto(id);
    }
}
