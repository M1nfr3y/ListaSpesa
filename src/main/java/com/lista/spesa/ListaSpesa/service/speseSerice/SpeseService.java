package com.lista.spesa.ListaSpesa.service.speseSerice;

import java.util.List;

import com.lista.spesa.ListaSpesa.model.Spese;
import com.lista.spesa.ListaSpesa.model.User;

public interface SpeseService {

    public List<Spese> getAllSpeseByUser(User user);
    
    public Spese createSpesa(Spese spese);

    public void deleteSpesaById(Long id);

    public Spese updateSpesa(Long id, Spese spesa);
    
}
