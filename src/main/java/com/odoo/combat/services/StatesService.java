package com.odoo.combat.services;

import java.util.List;

import com.odoo.combat.entities.States;

public interface StatesService {

    List<States> getAllStates();

    States getStateById(Integer stateId);

    States createState(States state);

    void deleteState(Integer stateId);

}
