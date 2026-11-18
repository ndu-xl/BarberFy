package com.nduxl.BarberFy.controller;

import com.nduxl.BarberFy.model.Corte;
import com.nduxl.BarberFy.repository.CorteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corte")
public class CorteController {
    private final CorteService service;

    public CorteController(CorteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Corte> listar() {
        return service.listar();
    }
    @PostMapping
    public Corte criar(@Valid @RequestBody Corte corte) {
        return service.criar(corte);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping("/{id}")
    public Corte buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Corte atualizar(@PathVariable Long id, @Valid @RequestBody Corte corte) {
        return service.atualizar(id, corte);
    }
}
