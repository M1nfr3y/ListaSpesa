package com.lista.spesa.ListaSpesa.service.speseSerice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lista.spesa.ListaSpesa.model.Spese;
import com.lista.spesa.ListaSpesa.model.User;
import com.lista.spesa.ListaSpesa.repository.SpeseRepository;

@Service
public class SpesaService {

    @Autowired
    private SpeseRepository speseRepository;

    
    public Spese createSpesa(Spese spese) {
        return speseRepository.save(spese);
    }

  
    public void deleteSpesaById(Long id) {
      speseRepository.deleteById(id);
    }
    
 
    public Spese updateSpesa(Long id, Spese spesa) {
        return speseRepository.findById(id).map(expense ->{
            expense.setAmount(spesa.getAmount());
            expense.setDescription(spesa.getDescription());
            expense.setDate(spesa.getDate());
            return speseRepository.save(expense);
        }).orElse(null);
    }


    public List<Spese> getAllSpeseByUser(User user) {
       return speseRepository.speseFindByUser(user);
    }
    
}
