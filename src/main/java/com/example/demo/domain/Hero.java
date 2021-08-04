package com.example.demo.domain;

import javax.persistence.*;

@Entity
@Table(name = "hero", schema = "student")
public class Hero {
    @Id
    @SequenceGenerator(
            name = "hero_sequence",
            sequenceName = "hero_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hero_sequence"
    )
    private Long id;
    private String name;

    public Hero(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Hero(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hero() {
    }
}
