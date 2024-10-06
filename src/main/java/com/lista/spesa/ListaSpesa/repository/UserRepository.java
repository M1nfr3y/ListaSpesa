package com.lista.spesa.ListaSpesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lista.spesa.ListaSpesa.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
