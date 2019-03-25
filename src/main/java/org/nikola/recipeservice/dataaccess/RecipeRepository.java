package org.nikola.recipeservice.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.nikola.recipeservice.domain.Recipeml.Recipe;

public class RecipeRepository {

  final List<Recipe> recipes = new ArrayList<>();
  private static RecipeRepository single_instance = null;

  public static RecipeRepository getInstance(final XmlRecipeLoader xmlRecipeLoader) {
    if (single_instance == null) {
      single_instance = new RecipeRepository(xmlRecipeLoader);
    }
    return single_instance;
  }

  public RecipeRepository(final XmlRecipeLoader xmlRecipeLoader) {
    try {
      recipes.add(xmlRecipeLoader.loadRecipe("30_Minute_Chili.xml"));
      recipes.add(xmlRecipeLoader.loadRecipe("Amaretto_Cake.xml"));
      recipes.add(xmlRecipeLoader.loadRecipe("Another_Zucchini_Dish.xml"));
    } catch (final JAXBException e) {
      e.printStackTrace();
    }
  }

  public List<Recipe> getRecipes() {
    return this.recipes;
  }

}
