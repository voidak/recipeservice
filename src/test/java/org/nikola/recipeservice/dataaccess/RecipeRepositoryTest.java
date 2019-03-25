package org.nikola.recipeservice.dataaccess;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.nikola.recipeservice.domain.Recipeml.Recipe;
import org.nikola.recipeservice.domain.Recipeml.Recipe.Head;
import org.nikola.recipeservice.domain.Recipeml.Recipe.Head.Categories;

public class RecipeRepositoryTest {

  @Test
  public void testGetRecipes_multipleInputs_outputOK() {
    final RecipeRepository recipeRepository = new RecipeRepository();
    final List<Recipe> recipes = new ArrayList<>();

    final Recipe recipe1 = new Recipe();
    recipe1.setHead(new Head());
    recipe1.getHead().setCategories(new Categories());
    recipe1.getHead().getCategories().getCat().addAll(Arrays.asList("Cat1","Cat2","Cat3"));
    recipes.add(recipe1);

    final Recipe recipe2 = new Recipe();
    recipe2.setHead(new Head());
    recipe2.getHead().setCategories(new Categories());
    recipe2.getHead().getCategories().getCat().addAll(Arrays.asList("Cat3","Cat4","Cat5"));
    recipes.add(recipe2);

    recipeRepository.setRecipes(recipes);

    assertEquals(2, recipeRepository.getRecipes(null).size());
    assertEquals(2, recipeRepository.getRecipes("").size());
    assertEquals(2, recipeRepository.getRecipes("  ").size());
    assertEquals(1, recipeRepository.getRecipes("Cat1").size());
    assertEquals(2, recipeRepository.getRecipes("Cat3").size());
    assertEquals(1, recipeRepository.getRecipes("Cat5").size());
  }

}
