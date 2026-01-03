 package com.fitness.service;

import com.fitness.model.FitnessPlan;
import com.fitness.model.User;
import org.springframework.stereotype.Service;

@Service
public class FitnessService {
    
    public FitnessPlan generateFitnessPlan(User user) {
        FitnessPlan plan = new FitnessPlan();
        
        double bmi = calculateBMI(user.getWeight(), user.getHeight());
        plan.setBmi(bmi);
        plan.setBmiCategory(getBMICategory(bmi));
        
        plan.setWorkoutPlan(generateWorkoutPlan(user));
        plan.setDietPlan(generateDietPlan(user));
        plan.setRecommendations(generateRecommendations(user, bmi));
        
        return plan;
    }
    
    private double calculateBMI(double weight, double height) {
        return weight / ((height / 100) * (height / 100));
    }
    
    private String getBMICategory(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal weight";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }
    
    private String generateWorkoutPlan(User user) {
        StringBuilder workout = new StringBuilder();
        String goal = user.getGoal().toLowerCase();
        
        if (goal.contains("weight loss") || goal.contains("lose weight")) {
            workout.append("High-Intensity Interval Training (HIIT):\n");
            workout.append("- 30 minutes cardio (5 days/week)\n");
            workout.append("- Strength training (3 days/week)\n");
            workout.append("- Core exercises daily\n");
        } else if (goal.contains("muscle") || goal.contains("gain")) {
            workout.append("Strength Training Program:\n");
            workout.append("- Weight training (4-5 days/week)\n");
            workout.append("- Progressive overload focus\n");
            workout.append("- Compound exercises priority\n");
        } else {
            workout.append("Balanced Fitness Program:\n");
            workout.append("- Cardio (3 days/week)\n");
            workout.append("- Strength training (3 days/week)\n");
            workout.append("- Flexibility exercises daily\n");
        }
        
        return workout.toString();
    }
    
    private String generateDietPlan(User user) {
        StringBuilder diet = new StringBuilder();
        String restrictions = user.getDietaryRestrictions().toLowerCase();
        String goal = user.getGoal().toLowerCase();
        
        diet.append("Personalized Nutrition Plan:\n\n");
        
        if (goal.contains("weight loss")) {
            diet.append("Caloric Deficit: 500 calories below maintenance\n");
            diet.append("Protein: 1.6-2.2g per kg body weight\n");
            diet.append("Carbs: Moderate, focus on complex carbs\n");
            diet.append("Fats: 20-30% of total calories\n\n");
        } else if (goal.contains("muscle")) {
            diet.append("Caloric Surplus: 300-500 calories above maintenance\n");
            diet.append("Protein: 2-2.5g per kg body weight\n");
            diet.append("Carbs: High, for energy and recovery\n");
            diet.append("Fats: 25-35% of total calories\n\n");
        }
        
        diet.append("Meal Suggestions:\n");
        if (restrictions.contains("vegetarian")) {
            diet.append("- Legumes, tofu, tempeh for protein\n");
            diet.append("- Quinoa, brown rice, whole grains\n");
            diet.append("- Plenty of vegetables and fruits\n");
        } else if (restrictions.contains("vegan")) {
            diet.append("- Plant-based proteins: beans, lentils, nuts\n");
            diet.append("- Fortified plant milks\n");
            diet.append("- Diverse vegetables and whole grains\n");
        } else {
            diet.append("- Lean proteins: chicken, fish, eggs\n");
            diet.append("- Complex carbs: oats, sweet potato\n");
            diet.append("- Healthy fats: avocado, nuts, olive oil\n");
        }
        
        return diet.toString();
    }
    
    private String generateRecommendations(User user, double bmi) {
        StringBuilder rec = new StringBuilder();
        
        rec.append("AI-Powered Recommendations:\n\n");
        rec.append("- Drink 3-4 liters of water daily\n");
        rec.append("- Get 7-9 hours of quality sleep\n");
        rec.append("- Track your progress weekly\n");
        
        if (bmi < 18.5) {
            rec.append("- Focus on calorie surplus with nutrient-dense foods\n");
            rec.append("- Consult healthcare provider for personalized advice\n");
        } else if (bmi > 25) {
            rec.append("- Create sustainable caloric deficit\n");
            rec.append("- Prioritize whole foods over processed\n");
        }
        
        rec.append("- Consider consulting a nutritionist for detailed plan\n");
        
        return rec.toString();
    }
}
 
