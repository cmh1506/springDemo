package com.example.demo.controller;

import com.example.demo.domain.Hero;
import com.example.demo.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HeroController {
    private final HeroService heroService;
    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/heros")
    public List<Hero> getHeros(){
        return heroService.getHeros();
    }

    @GetMapping( "/getHero/{id}")
    public Hero getHero(@PathVariable("id") Long id){
        Hero toReturn = heroService.findById(id);
        toReturn.setName(toReturn.getName() + " Baby");
        return toReturn;
    }

    @PutMapping(path = "/heros")
    public void updateStudent(@RequestBody Hero hero){
        heroService.updateHero(hero);
    }

}
