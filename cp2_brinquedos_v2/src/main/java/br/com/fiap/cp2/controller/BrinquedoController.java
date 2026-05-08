package br.com.fiap.cp2.controller;

import br.com.fiap.cp2.entity.Brinquedo;
import br.com.fiap.cp2.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoRepository repository;

    // CREATE - POST
    @PostMapping
    public ResponseEntity<Brinquedo> create(@RequestBody Brinquedo brinquedo) {
        Brinquedo savedBrinquedo = repository.save(brinquedo);
        return new ResponseEntity<>(savedBrinquedo, HttpStatus.CREATED);
    }

    // READ ALL - GET
    @GetMapping
    public List<Brinquedo> getAll() {
        return repository.findAll();
    }

    // READ BY ID - GET
    @GetMapping("/{id}")
    public ResponseEntity<Brinquedo> getById(@PathVariable Long id) {
        Optional<Brinquedo> brinquedo = repository.findById(id);
        return brinquedo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE - PUT
    @PutMapping("/{id}")
    public ResponseEntity<Brinquedo> update(@PathVariable Long id, @RequestBody Brinquedo brinquedoDetails) {
        return repository.findById(id).map(brinquedo -> {
            brinquedo.setNome(brinquedoDetails.getNome());
            brinquedo.setTipo(brinquedoDetails.getTipo());
            brinquedo.setClassificacao(brinquedoDetails.getClassificacao());
            brinquedo.setTamanho(brinquedoDetails.getTamanho());
            brinquedo.setPreco(brinquedoDetails.getPreco());
            Brinquedo updatedBrinquedo = repository.save(brinquedo);
            return ResponseEntity.ok(updatedBrinquedo);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE - DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
