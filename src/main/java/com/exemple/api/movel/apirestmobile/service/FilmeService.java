package com.exemple.api.movel.apirestmobile.service;

import com.exemple.api.movel.apirestmobile.entity.Filme;
import com.exemple.api.movel.apirestmobile.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public Filme save (Filme filme){
        return filmeRepository.save(filme);
    }

    public List<Filme> findAll() {
        return filmeRepository.findAll();
    }

    public Filme findById(Long id){
        return filmeRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        filmeRepository.deleteById(id);
    }


    public boolean existsByDiretorId(Long diretorId) {
        return filmeRepository.existsByDiretorId(diretorId);
    }
}
