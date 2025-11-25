package com.exemple.api.movel.apirestmobile.service;

import com.exemple.api.movel.apirestmobile.entity.Diretor;
import com.exemple.api.movel.apirestmobile.repository.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository diretorRepository;

    public Diretor save(Diretor diretor){
        return diretorRepository.save(diretor);
    }

    public List<Diretor> findAll (){
        return diretorRepository.findAll();
    }

    public Diretor findById (Long id){
        return diretorRepository.findById(id).orElse(null);
    }

    public void delete(Long id){
        diretorRepository.deleteById(id);
    }



}
