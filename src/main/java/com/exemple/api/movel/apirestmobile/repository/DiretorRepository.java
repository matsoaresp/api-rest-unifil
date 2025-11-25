package com.exemple.api.movel.apirestmobile.repository;

import com.exemple.api.movel.apirestmobile.entity.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Long> {

}
