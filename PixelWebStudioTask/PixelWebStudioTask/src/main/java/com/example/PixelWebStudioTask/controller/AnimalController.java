package com.example.PixelWebStudioTask.controller;


import com.example.PixelWebStudioTask.Model.Animal;
import com.example.PixelWebStudioTask.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping("/animals")
    public String listAnimals(Model model) {
        List<Animal> animals = animalService.getAllAnimals();
        model.addAttribute("animals", animals);
        return "animal_list";
    }

    @GetMapping("/animals/new")
    public String createAnimalForm(Model model) {
        Animal animal = new Animal();
        model.addAttribute("animal", animal);
        return "create_animal";
    }

    @PostMapping("/animals")
    public String saveAnimal(@ModelAttribute("animal") Animal animal, @RequestParam("imageFile") MultipartFile imageFile) {
        try {
            animal.setImage(imageFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        animalService.saveAnimal(animal);
        return "redirect:/animals";
    }

    @GetMapping("/animals/edit/{id}")
    public String editAnimalForm(@PathVariable Long id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        model.addAttribute("animal", animal);
        return "edit_animal";
    }

    @PostMapping("/animals/{id}")
    public String updateAnimal(@PathVariable Long id, @ModelAttribute("animal") Animal animal, @RequestParam("imageFile") MultipartFile imageFile) {
        try {
            animal.setImage(imageFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        animalService.saveAnimal(animal);
        return "redirect:/animals";
    }

    @GetMapping("/animals/delete/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return "redirect:/animals";
    }
}
