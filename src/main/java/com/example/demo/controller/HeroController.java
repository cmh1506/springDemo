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

    @GetMapping( "/getHero/{heroId}")
    public Hero getHero(@PathVariable("heroId") Long heroId){
        return heroService.findById(heroId);
    }

}
