package Recipe.example.Recipe.RecipeService;

import Recipe.example.Recipe.RecipeModel.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    List<Recipe> getAllRecipe();
    Optional<Recipe> getRecipeById(Long id);
    Recipe createRecipe(Recipe recipe);

    void deleteRecipe(Long id);
    Recipe updateRecipe(Recipe recipe , Long id);
}
