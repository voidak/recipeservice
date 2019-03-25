package org.nikola.recipeservice.dataaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBException;

import org.nikola.recipeservice.domain.Recipeml.Recipe;
import org.nikola.recipeservice.domain.Recipeml.Recipe.Head.Categories;

public class RecipeRepository {

  private List<Recipe> recipes = new ArrayList<>();
  private static RecipeRepository single_instance = null;

  public void setRecipes(final List<Recipe> recipes) {
    this.recipes = recipes;
  }

  public static RecipeRepository getInstance(final XmlRecipeLoader xmlRecipeLoader) {
    if (single_instance == null) {
      single_instance = new RecipeRepository(xmlRecipeLoader);
    }
    return single_instance;
  }

  public RecipeRepository() {

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

  public List<Recipe> getRecipes(final String category) {
    return (category == null || category.trim().isEmpty())
        ? this.recipes
        : this.recipes.stream()
            .filter(r -> r.getHead().getCategories().getCat().contains(category))
            .collect(Collectors.toList());
  }

  public List<String> getDistinctCategories() {
    final List<Categories> categories = recipes.stream().map(r -> r.getHead().getCategories()).collect(Collectors.toList());
    final List<String> allCateogries = new ArrayList<>();
    for (final Categories cat : categories) {
      allCateogries.addAll(cat.getCat().stream().collect(Collectors.toList()));
    }
    final List<String> distinctCateogries = new ArrayList<>();
    distinctCateogries.addAll(allCateogries.stream().distinct().collect(Collectors.toList()));
    return distinctCateogries;
  }

}
