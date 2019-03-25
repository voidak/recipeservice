package org.nikola.recipeservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("recipe")
public class RecipeService {

  @GET
  @Path("all")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllRecipes() {
    Response response = null;
    try {
      final String testResponse = "Test response";
      response = Response.ok(testResponse).build();
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
