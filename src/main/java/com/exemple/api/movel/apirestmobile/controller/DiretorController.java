package com.exemple.api.movel.apirestmobile.controller;

import com.exemple.api.movel.apirestmobile.entity.Diretor;
import com.exemple.api.movel.apirestmobile.entity.Filme;
import com.exemple.api.movel.apirestmobile.service.DiretorService;
import com.exemple.api.movel.apirestmobile.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diretor")
public class DiretorController {

    @Autowired
    private DiretorService diretorService;
    @Autowired
    private FilmeService filmeService;

    @PostMapping("/criarDiretor")
    public ResponseEntity<?> criarDiretor(@RequestBody Diretor diretor) {
        return ResponseEntity.ok(diretorService.save(diretor));
    }

    @GetMapping()
    public ResponseEntity<?> listarDiretores() {
        return ResponseEntity.ok(diretorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Diretor diretor = diretorService.findById(id);
        if (diretor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(diretor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarDiretorById(@PathVariable long id){
        Diretor diretor = diretorService.findById(id);
        if(diretor == null){
            return ResponseEntity.notFound().build();
        }
        if (filmeService.existsByDiretorId(id)) {
            throw new IllegalStateException("Não é possível deletar: existem filmes associados a este diretor.");
        }
        diretorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
