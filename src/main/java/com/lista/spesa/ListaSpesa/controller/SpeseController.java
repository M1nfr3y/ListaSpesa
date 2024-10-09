package com.lista.spesa.ListaSpesa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lista.spesa.ListaSpesa.model.Spese;
import com.lista.spesa.ListaSpesa.model.User;
import com.lista.spesa.ListaSpesa.service.speseSerice.SpesaService;
import com.lista.spesa.ListaSpesa.service.speseSerice.UserService;

//Il controller gestirà le richieste HTTP e interagirà con il servizio per operare sulle spese dell'utente autenticato.
@Controller
@RequestMapping("/api/spese")
public class SpeseController {

    @Autowired
    private SpesaService spesaService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Spese> getSpese(Authentication authentication){
        User user = userService.findByUsername(authentication.getName());
        return spesaService.getAllSpeseByUser(user);
    }
}
