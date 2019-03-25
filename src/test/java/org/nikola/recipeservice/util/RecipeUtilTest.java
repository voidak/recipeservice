package org.nikola.recipeservice.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.nikola.recipeservice.domain.Recipeml.Recipe;
import org.nikola.recipeservice.domain.Recipeml.Recipe.Directions;
import org.nikola.recipeservice.domain.Recipeml.Recipe.Head;

public class RecipeUtilTest {

  @Test
  public void testValidateRecipe_RecipeNull_InvalidInput() {
    final Recipe recipe = null;
    assertEquals("Invalid input.", RecipeUtils.validateRecipe(recipe));
  }

  @Test
  public void testValidateRecipe_HeadNull_InvalidInput() {
    final Recipe recipe = new Recipe();
    assertEquals("Invalid input.", RecipeUtils.validateRecipe(recipe));
  }

  @Test
  public void testValidateRecipe_DirectionsNull_InvalidInput() {
    final Recipe recipe = new Recipe();
    recipe.setHead(new Head());
    assertEquals("Invalid input.", RecipeUtils.validateRecipe(recipe));
  }

  @Test
  public void testValidateRecipe_TitleNull_InvalidTitle() {
    final Recipe recipe = new Recipe();
    recipe.setHead(new Head());
    recipe.setDirections(new Directions());
    assertEquals("Invalid title.", RecipeUtils.validateRecipe(recipe));
  }

  @Test
  public void testValidateRecipe_TitleEmpty_InvalidTitle() {
    final Recipe recipe = new Recipe();
    recipe.setHead(new Head());
    recipe.setDirections(new Directions());
    recipe.getHead().setTitle("");
    assertEquals("Invalid title.", RecipeUtils.validateRecipe(recipe));
  }

  @Test
  public void testValidateRecipe_StepNull_InvalidInstructionSteps() {
    final Recipe recipe = new Recipe();
    recipe.setHead(new Head());
    recipe.setDirections(new Directions());
    recipe.getHead().setTitle("Title");
    assertEquals("Invalid instruction steps.", RecipeUtils.validateRecipe(recipe));
  }

  @Test
  public void testValidateRecipe_StepEmpty_InvalidInstructionSteps() {
    final Recipe recipe = new Recipe();
    recipe.setHead(new Head());
    recipe.setDirections(new Directions());
    recipe.getHead().setTitle("Title");
    recipe.getDirections().setStep("");
    assertEquals("Invalid instruction steps.", RecipeUtils.validateRecipe(recipe));
  }

  @Test
  public void testValidateRecipe_RecipeOK() {
    final Recipe recipe = new Recipe();
    recipe.setHead(new Head());
    recipe.setDirections(new Directions());
    recipe.getHead().setTitle("Title");
    recipe.getDirections().setStep("Step");
    assertNull(RecipeUtils.validateRecipe(recipe));
  }

}
