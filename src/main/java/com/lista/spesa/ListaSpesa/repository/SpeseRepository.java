package com.lista.spesa.ListaSpesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lista.spesa.ListaSpesa.model.Spese;

public interface SpeseRepository extends JpaRepository<Spese, Long>{
    
}
