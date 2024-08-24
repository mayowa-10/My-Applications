package Recipe.example.Recipe.RecipeService;

import Recipe.example.Recipe.RecipeModel.Recipe;
import Recipe.example.Recipe.RecipeRepository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeImpl implements RecipeService{
    @Autowired
    private RecipeRepository recipeRepository;
    @Override
    public List<Recipe> getAllRecipe() {
        return recipeRepository.findAll();
    }

    @Override
    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }


    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public Recipe updateRecipe(Recipe recipe, Long id) {
        recipeRepository.findById(id)
                .map(post -> {
                    post.setName(recipe.getName());
                    post.setDescription(recipe.getDescription());
                    post.setIngredients(recipe.getIngredients());
                    return recipeRepository.save(post);
                } )
                .orElseGet(()->{
                    recipe.setId(id);
                    return recipeRepository.save(recipe);
                });
        return recipeRepository.findById(id).get();
    }
}
