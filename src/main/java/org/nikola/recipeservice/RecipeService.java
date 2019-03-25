package org.nikola.recipeservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.nikola.recipeservice.dataaccess.RecipeRepository;
import org.nikola.recipeservice.dataaccess.XmlRecipeLoader;
import org.nikola.recipeservice.domain.Recipeml.Recipe;

@Path("recipe")
public class RecipeService {

  RecipeRepository recipeRepository = RecipeRepository.getInstance(new XmlRecipeLoader());

  @GET
  @Path("all")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllRecipes() {
    Response response = null;
    try {
      final List<Recipe> allRecipes = recipeRepository.getRecipes();
      response = Response.ok(allRecipes).build();
    } catch (final Exception e) {
      response = Response.serverError().build();
    }
    return response;
  }

  @GET
  @Path("categories")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getCategories() {
    Response response = null;
    try {
      final String testResponse = "Test response";
      response = Response.ok(testResponse).build();
    } catch (final Exception e) {
      response = Response.serverError().build();
    }
    return response;
  }

}
