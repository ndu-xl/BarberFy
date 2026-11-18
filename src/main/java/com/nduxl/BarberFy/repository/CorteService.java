package com.nduxl.BarberFy.repository;

import com.nduxl.BarberFy.exception.CorteNaoEncontradoException;
import com.nduxl.BarberFy.model.Corte;
import com.nduxl.BarberFy.service.CorteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorteService {
    private final CorteRepository repository;

    public CorteService(CorteRepository repository) {
        this.repository = repository;
    }

    public List<Corte> listar() {
        return repository.findAll();
    }
    public Corte criar(Corte corte) {
        return repository.save(corte);
    }
    public Corte buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new CorteNaoEncontradoException(id));
    }
    public void deletar(Long id) {
        Corte corte = buscarPorId(id);
        repository.delete(corte);
    }
    public Corte atualizar(Long id, Corte corteAtualizado){
        Corte corte = buscarPorId(id);
        corte.setCorte(corteAtualizado.getCorte());
        corte.setDia(corteAtualizado.getDia());
        corte.setNome(corteAtualizado.getNome());
        return repository.save(corte);
    }

}
