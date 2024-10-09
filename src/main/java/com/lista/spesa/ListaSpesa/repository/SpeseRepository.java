package com.lista.spesa.ListaSpesa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lista.spesa.ListaSpesa.model.Spese;
import com.lista.spesa.ListaSpesa.model.User;

@Repository
public interface SpeseRepository extends JpaRepository<Spese, Long>{
    
    List<Spese> speseFindByUser(User user);
}
