package com.nmurray.mealplannerbackend;

import com.nmurray.mealplannerbackend.data.Recipe;
import com.nmurray.mealplannerbackend.data.RecipeRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalTime;
import java.util.Arrays;

@SpringBootApplication
@EntityScan(basePackages={"com.nmurray.mealplannerbackend" })
@EnableMongoRepositories(basePackages={"com.nmurray.mealplannerbackend"})
public class MealPlannerBackendApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MealPlannerBackendApplication.class, args);
        //RecipeRepository repo = context.getBean(RecipeRepository.class);
        //repo.save(new Recipe( "Burgers and Chips", LocalTime.of(0,30), Arrays.asList( "Mince", "Buns", "Potatoes"), Arrays.asList("Make patties from mince", "Cut potatoes into chips", "Cook", "Assemble burgers")));
        //repo.save(new Recipe( "Chicken Curry", LocalTime.of(0,45), Arrays.asList( "Chicken", "Sauce", "Rice"), Arrays.asList("Prepare chicken", "Make sauce", "Add ingredients", "Cook rice")));
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("PUT", "GET", "OPTIONS","DELETE", "POST");
            }
        };
    }
}
