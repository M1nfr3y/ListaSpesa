package com.lista.spesa.ListaSpesa.service.speseSerice;

import java.util.List;

import com.lista.spesa.ListaSpesa.model.Spese;

public interface SpeseService {

    public List<Spese> getAllSpeseByUser(User user);
    
    public Spese getSpeseById(Long id);

    public Spese createSpesa(Spese spese);

    public void deleteSpesaById(Long id);

    public Spese updateSpesa(Spese spesa);
    
}
