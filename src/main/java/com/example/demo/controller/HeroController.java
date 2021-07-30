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

    @GetMapping("/searchHeroes/{name}")
    public List<Hero> getHerosBySearchterm(@PathVariable("name") String name){
        return heroService.getHerosBySearchterm(name);
    }

    @GetMapping( "/getHero/{id}")
    public Hero getHero(@PathVariable("id") Long id){
        Hero toReturn = heroService.findById(id);
        toReturn.setName(toReturn.getName() + " Baby");
        return toReturn;
    }

    @PutMapping(path = "/heros")
    public void updateHero(@RequestBody Hero hero){
        heroService.updateHero(hero);
    }

    @PostMapping(path = "/heros")
    public Hero addHero(@RequestBody Hero hero){
        heroService.addNewHero(hero);
        return hero;
    }
    @DeleteMapping(path = "/heros/{id}")
    public void deleteHero(@PathVariable("id") Long id){
        heroService.deleteHero(id);
    }

}
