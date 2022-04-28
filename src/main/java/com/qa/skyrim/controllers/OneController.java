package com.qa.skyrim.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.skyrim.weapons.one_handed.OneHanded;

@RestController
@RequestMapping(path = "/one")
public class OneController {
	
	private static int COUNTER = 1;
    private List<OneHanded> ones = new ArrayList<>(List.of(new OneHanded(COUNTER++, "Sword"), new OneHanded(COUNTER++, "Axe")));
    
    @GetMapping
    public List<OneHanded> getOneHandeds() {
    	return ones;
    }
    
    @GetMapping(path = "/{id}") 
    public OneHanded getOneHanded(@PathVariable(name = "id") int id) {
        for (int i = 0; i < ones.size(); i++) {
            if (this.ones.get(i).getId() == id) {
                return this.ones.get(i);
            }
        }
        return null;
    }

}