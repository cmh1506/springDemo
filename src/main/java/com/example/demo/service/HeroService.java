package com.example.demo.service;

import com.example.demo.domain.Hero;
import com.example.demo.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HeroService {
    private final HeroRepository heroRepository;
    @Autowired
    public HeroService(HeroRepository heroRepository){
        this.heroRepository = heroRepository;
    }
    public List<Hero> getHeros(){
        return heroRepository.findAll();
    }
    public void addNewHero(Hero hero) {
        heroRepository.save(hero);
    }

    public void deleteHero(Long heroId) {
        heroRepository.existsById(heroId);
        if(!heroRepository.existsById(heroId)){
            throw new IllegalStateException("hero with id " + heroId + " does not exist.");
        }
        heroRepository.deleteById(heroId);
    }



    @Transactional
    public void updateHero(Hero hero) {
        heroRepository.saveAndFlush(hero);
    }

    public Hero findById(Long heroId) {
        Hero toReturn = null;
        Optional<Hero> x = heroRepository.findById(heroId);
        toReturn = x.orElse(null);
        return toReturn;
    }
}
