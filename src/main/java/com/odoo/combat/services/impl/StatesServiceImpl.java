package com.odoo.combat.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odoo.combat.entities.States;
import com.odoo.combat.repositories.StatesRepository;
import com.odoo.combat.services.StatesService;

@Service
public class StatesServiceImpl implements StatesService{
    @Autowired
    private StatesRepository statesRepository;

    @Override
    public List<States> getAllStates() {
        return statesRepository.findAll();
    }

    @Override
    public States getStateById(Integer stateId) {
        Optional<States> optionalState = statesRepository.findById(stateId);
        return optionalState.orElse(null);
    }

    @Override
    public States createState(States state) {
        return statesRepository.save(state);
    }

    @Override
    public void deleteState(Integer stateId) {
        statesRepository.deleteById(stateId);
    }

}
