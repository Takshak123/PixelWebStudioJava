package com.example.PixelWebStudioTask.service;


import com.example.PixelWebStudioTask.Model.Animal;
import com.example.PixelWebStudioTask.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id).orElse(null);
    }
}
