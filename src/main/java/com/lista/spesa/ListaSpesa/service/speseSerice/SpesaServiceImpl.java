package com.lista.spesa.ListaSpesa.service.speseSerice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lista.spesa.ListaSpesa.model.Spese;
import com.lista.spesa.ListaSpesa.repository.SpeseRepository;

public class SpesaServiceImpl implements SpeseService {

    @Autowired
    private SpeseRepository speseRepository;

    @Override
    public List<Spese> getAllSpese() {
       speseRepository.findAll();
        throw new UnsupportedOperationException("Unimplemented method 'getAllSpese'");
    }

    @Override
    public Spese getSpeseById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSpeseById'");
    }

    @Override
    public Spese createSpesa(Spese spese) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createSpesa'");
    }

    @Override
    public void deleteSpesaById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSpesaById'");
    }

    @Override
    public Spese updateSpesa(Spese spesa) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSpesa'");
    }
    
}
