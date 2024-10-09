package com.lista.spesa.ListaSpesa.service.speseSerice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lista.spesa.ListaSpesa.model.User;
import com.lista.spesa.ListaSpesa.repository.UserRepository;

@Service
public class UserService {
     @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUser(username);
    }
}
