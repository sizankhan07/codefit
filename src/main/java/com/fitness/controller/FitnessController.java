package com.fitness.controller;

import com.fitness.model.FitnessPlan;
import com.fitness.model.User;
import com.fitness.repository.UserRepository;
import com.fitness.service.FitnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fitness")
public class FitnessController {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private FitnessService fitnessService;
    
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        return userRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userRepository.findById(id)
            .map(user -> {
                user.setHeight(userDetails.getHeight());
                user.setWeight(userDetails.getWeight());
                user.setDietaryRestrictions(userDetails.getDietaryRestrictions());
                user.setGoal(userDetails.getGoal());
                return ResponseEntity.ok(userRepository.save(user));
            })
            .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("/generate/{id}")
    public ResponseEntity<?> generatePlan(@PathVariable Long id) {
        return userRepository.findById(id)
            .map(user -> {
                FitnessPlan plan = fitnessService.generateFitnessPlan(user);
                return ResponseEntity.ok(plan);
            })
            .orElse(ResponseEntity.notFound().build());
    }
}
