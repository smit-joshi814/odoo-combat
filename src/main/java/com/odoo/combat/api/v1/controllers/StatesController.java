package com.odoo.combat.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odoo.combat.entities.States;
import com.odoo.combat.services.StatesService;

@RestController
@RequestMapping("/api/v1/states")
public class StatesController {

    @Autowired
    private StatesService statesService;

    @GetMapping
    public ResponseEntity<List<States>> getAllStates() {
        List<States> states = statesService.getAllStates();
        return new ResponseEntity<>(states, HttpStatus.OK);
    }

    @GetMapping("/{stateId}")
    public ResponseEntity<States> getStateById(@PathVariable Integer stateId) {
        States state = statesService.getStateById(stateId);
        if (state != null) {
            return new ResponseEntity<>(state, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<States> createState(@RequestBody States state) {
        States savedState = statesService.createState(state);
        return new ResponseEntity<>(savedState, HttpStatus.CREATED);
    }

    @DeleteMapping("/{stateId}")
    public ResponseEntity<Void> deleteState(@PathVariable Integer stateId) {
        statesService.deleteState(stateId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
