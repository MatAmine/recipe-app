package guru.springframework.recipeapp.services;

import guru.springframework.recipeapp.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findById(Long id);
}
