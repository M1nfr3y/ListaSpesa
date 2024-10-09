package com.lista.spesa.ListaSpesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lista.spesa.ListaSpesa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUser(String username);
}
