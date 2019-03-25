package org.nikola.recipeservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.nikola.recipeservice.dataaccess.RecipeRepository;
import org.nikola.recipeservice.dataaccess.XmlRecipeLoader;
import org.nikola.recipeservice.domain.Recipeml.Recipe;
import org.nikola.recipeservice.util.RecipeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

@Path("recipe")
public class RecipeService {

  private static final Logger logger = LoggerFactory.getLogger(RecipeService.class);
  RecipeRepository recipeRepository = RecipeRepository.getInstance(new XmlRecipeLoader());

  @GET
  @Path("all")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllRecipes(@QueryParam("category") final String category) {
    Response response = null;
    try {
      final List<Recipe> allRecipes = recipeRepository.getRecipes(category);
      response = Response.ok(allRecipes).build();
    } catch (final Exception e) {
      logger.error("Error retrieving recipes.", e);
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
      final List<String> distinctCategories = recipeRepository.getDistinctCategories();
      response = Response.ok(distinctCategories).build();
    } catch (final Exception e) {
      logger.error("Error retrieving recipe categories.", e);
      response = Response.serverError().build();
    }
    return response;
  }

  @POST
  @Path("save")
  @Produces(MediaType.APPLICATION_JSON)
  public Response createRecipe(final String recipeJSON) {
    Response response = null;
    try {
      if (recipeJSON != null) {
        final ObjectMapper mapper = new ObjectMapper();
        final Recipe recipe = mapper.readValue(recipeJSON, Recipe.class);
        final String recipeValidationError = RecipeUtils.validateRecipe(recipe);
        if (recipeValidationError != null) {
          throw new IllegalArgumentException(recipeValidationError);
        }
        recipeRepository.saveRecipe(recipe);
        response = Response.ok().build();
      } else {
        throw new IllegalArgumentException("Input not valid.");
      }
    } catch (final IllegalArgumentException e) {
      response = Response.status(400).build();
      logger.error("Invalid input.", e);
    } catch (final Exception e) {
      logger.error("Error saving recipe.", e);
      response = Response.serverError().build();
    }
    return response;
  }

}
