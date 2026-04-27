package com.my.recipebook.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false)
    private String name;

    //When you load a Recipe, JPA reads those rows and assembles them into a List<Ingredient> for you in Java.
    //It's a mapping illusion — the list never actually exists in the DB.
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<RecipeIngredient> ingredients;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @PrePersist
    private void onCreate() {
        createdAt = Instant.now();
    }
}
