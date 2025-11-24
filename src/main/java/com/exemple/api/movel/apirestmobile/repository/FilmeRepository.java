package com.exemple.api.movel.apirestmobile.repository;

import com.exemple.api.movel.apirestmobile.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository  extends JpaRepository<Filme, Long> {



}
