package org.nikola.recipeservice.util;

import org.nikola.recipeservice.domain.Recipeml.Recipe;

public final class RecipeUtils {

  private static final String INVALID_INPUT = "Invalid input.";
  private static final String INVALID_TITLE = "Invalid title.";
  private static final String INVALID_INSTRUCTIONS = "Invalid instruction steps.";

  private RecipeUtils() {
    // prevent instantiating of util class
  }

  public static String validateRecipe(final Recipe recipe) {
    String result = null;
    if (recipe == null || recipe.getHead() == null || recipe.getDirections() == null) {
      result = INVALID_INPUT;
    } else if (recipe.getHead().getTitle() == null || recipe.getHead().getTitle().isEmpty()) {
      result = INVALID_TITLE;
    } else if (recipe.getDirections().getStep() == null || recipe.getDirections().getStep().isEmpty()) {
      result = INVALID_INSTRUCTIONS;
    }
    return result;
  }

}
