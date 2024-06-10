package com.example.PixelWebStudioTask.repository;

import com.example.PixelWebStudioTask.Model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
