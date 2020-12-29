package guru.springframework.recipeapp.services;

import guru.springframework.recipeapp.commands.IngredientCommand;
import guru.springframework.recipeapp.converters.IngredientToIngredientCommand;
import guru.springframework.recipeapp.domain.Ingredient;
import guru.springframework.recipeapp.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;

    public IngredientServiceImpl(IngredientRepository ingredientRepository, IngredientToIngredientCommand ingredientToIngredientCommand) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
    }

    @Override
    public IngredientCommand findById(Long id) {
        Ingredient ingredient =  ingredientRepository.findById(id).orElse(new Ingredient());
        return ingredientToIngredientCommand.convert(ingredient);
    }
}
