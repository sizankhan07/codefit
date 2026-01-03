package com.fitness.model;

public class FitnessPlan {
    private String workoutPlan;
    private String dietPlan;
    private String recommendations;
    private double bmi;
    private String bmiCategory;
    
    public FitnessPlan() {}
    
    public String getWorkoutPlan() { return workoutPlan; }
    public void setWorkoutPlan(String workoutPlan) { this.workoutPlan = workoutPlan; }
    
    public String getDietPlan() { return dietPlan; }
    public void setDietPlan(String dietPlan) { this.dietPlan = dietPlan; }
    
    public String getRecommendations() { return recommendations; }
    public void setRecommendations(String recommendations) { 
        this.recommendations = recommendations; 
    }
    
    public double getBmi() { return bmi; }
    public void setBmi(double bmi) { this.bmi = bmi; }
    
    public String getBmiCategory() { return bmiCategory; }
    public void setBmiCategory(String bmiCategory) { this.bmiCategory = bmiCategory; }
}
 
