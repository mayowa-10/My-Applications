package Recipe.example.Recipe.RecipeController;

import Recipe.example.Recipe.RecipeModel.Recipe;
import Recipe.example.Recipe.RecipeService.RecipeImpl;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("recipe/api/post")
public class RecipeController {
    @Autowired
    private RecipeImpl recipeimpl;
    @GetMapping
    public List<Recipe> getAllRecipe(){
        return recipeimpl.getAllRecipe();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id){
        Optional<Recipe> post = recipeimpl.getRecipeById(id);
        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping()
    public Recipe createRecipe (@RequestBody Recipe recipe) {
        return recipeimpl.createRecipe(recipe);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe (@PathVariable Long id, @RequestBody Recipe newPost){
        Recipe updateRecipe = recipeimpl.updateRecipe(newPost,id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id){
        recipeimpl.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }

}
