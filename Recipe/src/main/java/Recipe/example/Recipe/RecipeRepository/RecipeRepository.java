package Recipe.example.Recipe.RecipeRepository;

import Recipe.example.Recipe.RecipeModel.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
