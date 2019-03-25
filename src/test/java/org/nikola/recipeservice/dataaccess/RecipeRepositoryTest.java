package org.nikola.recipeservice.dataaccess;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.nikola.recipeservice.domain.Recipeml.Recipe;
import org.nikola.recipeservice.domain.Recipeml.Recipe.Head;
import org.nikola.recipeservice.domain.Recipeml.Recipe.Head.Categories;

public class RecipeRepositoryTest {

  @Rule public final ExpectedException exception = ExpectedException.none();

  @Test
  public void testGetRecipes_multipleInputs_outputOK() {
    final RecipeRepository recipeRepository = new RecipeRepository();

    recipeRepository.setRecipes(getSampleRecipes());

    assertEquals(2, recipeRepository.getRecipes(null).size());
    assertEquals(2, recipeRepository.getRecipes("").size());
    assertEquals(2, recipeRepository.getRecipes("  ").size());
    assertEquals(1, recipeRepository.getRecipes("Cat1").size());
    assertEquals(2, recipeRepository.getRecipes("Cat3").size());
    assertEquals(1, recipeRepository.getRecipes("Cat5").size());
  }

  @Test
  public void testGetDistinctCategories_outputOK() {
    final RecipeRepository recipeRepository = new RecipeRepository();
    recipeRepository.setRecipes(getSampleRecipes());
    assertEquals(5, recipeRepository.getDistinctCategories().size());
  }

  @Test
  public void testSaveRecipe_alredyExistingTitle_exceptionThrown() {
    final RecipeRepository recipeRepository = new RecipeRepository();
    final Recipe recipe1 = new Recipe();
    recipe1.setHead(new Head());
    recipe1.getHead().setTitle("recipe1");
    try {
      recipeRepository.saveRecipe(recipe1);
    } catch (final IllegalArgumentException e) {
      // if execution reaches here,
      // it indicates this exception was occured - test passed
    }
  }

  private List<Recipe> getSampleRecipes() {
    final List<Recipe> recipes = new ArrayList<>();

    final Recipe recipe1 = new Recipe();
    recipe1.setHead(new Head());
    recipe1.getHead().setTitle("recipe1");
    recipe1.getHead().setCategories(new Categories());
    recipe1.getHead().getCategories().getCat().addAll(Arrays.asList("Cat1", "Cat2", "Cat3"));
    recipes.add(recipe1);

    final Recipe recipe2 = new Recipe();
    recipe2.setHead(new Head());
    recipe1.getHead().setTitle("recipe2");
    recipe2.getHead().setCategories(new Categories());
    recipe2.getHead().getCategories().getCat().addAll(Arrays.asList("Cat3", "Cat4", "Cat5"));
    recipes.add(recipe2);

    return recipes;
  }

}
