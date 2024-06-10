package com.example.PixelWebStudioTask.Model;

import jakarta.persistence.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private String description;
    private String lifeExpectancy; // Change this from Integer to String

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

    // Getters and setters

    public Animal(Long id, String name, String category, String description, String lifeExpectancy, byte[] image) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.lifeExpectancy = lifeExpectancy;
        this.image = image;
    }

    public Animal() {

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(String lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
