package com.exemple.api.movel.apirestmobile.controller;

import com.exemple.api.movel.apirestmobile.entity.Diretor;
import com.exemple.api.movel.apirestmobile.entity.Filme;
import com.exemple.api.movel.apirestmobile.service.DiretorService;
import com.exemple.api.movel.apirestmobile.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @Autowired
    private DiretorService diretorService;

    @PostMapping("/criarFilme")
    public ResponseEntity<?> criarFilme(@RequestBody Filme filme) {
        if (filme.getTitulo() == null || filme.getTitulo().isBlank()) {
            return ResponseEntity.badRequest().body("O título do filme é obrigatório.");
        }
        if (filme.getDiretor() != null && filme.getDiretor().getId() != null) {

            Diretor diretor = diretorService.findById(filme.getDiretor().getId());
            if (diretor == null) {
                return ResponseEntity.badRequest().body("Diretor inválido.");
            }
            filme.setDiretor(diretor);
        }

        Filme createdFilm = filmeService.save(filme);

        return ResponseEntity.ok(createdFilm);
    }


    @GetMapping
    public ResponseEntity<List<Filme>> getAllFilmes (){
        List<Filme> filmes = filmeService.findAll();
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFilmById(@PathVariable long id){
        Filme filme = filmeService.findById(id);
        if (filme == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(filme);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAlbumById(@PathVariable long id){
        Filme filme = filmeService.findById(id);
        if(filme == null){
            return ResponseEntity.notFound().build();
        }
        filmeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarFilme(@PathVariable long id, @RequestBody Filme filme) {

        Filme existingFilme = filmeService.findById(id);

        if (existingFilme == null) {
            return ResponseEntity.notFound().build();
        }

        if (filme.getTitulo() != null && !filme.getTitulo().isBlank()) {
            existingFilme.setTitulo(filme.getTitulo());
        }

        if (filme.getGenero() != null && !filme.getGenero().isBlank()) {
            existingFilme.setGenero(filme.getGenero());
        }

        if (filme.getAnoLancamento() != null && !filme.getAnoLancamento().isBlank()) {
            existingFilme.setAnoLancamento(filme.getAnoLancamento());
        }

        Filme updated = filmeService.save(existingFilme);

        return ResponseEntity.ok(updated);
    }

}
