package com.example.demo.repository;

import com.example.demo.domain.Hero;
import com.example.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
    List<Hero> findHeroesByNameStartingWith(String searchterm);
}
