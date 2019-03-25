package org.nikola.recipeservice.dataaccess;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.nikola.recipeservice.domain.Recipeml;
import org.nikola.recipeservice.domain.Recipeml.Recipe;

public class XmlRecipeLoader {

  public Recipe loadRecipe(final String title) throws JAXBException {
    final ClassLoader classLoader = getClass().getClassLoader();
    final File file = new File(classLoader.getResource(title).getFile());
    final JAXBContext jaxbContext = JAXBContext.newInstance(Recipeml.class);
    final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    final Recipeml unmarshalled1 = (Recipeml) jaxbUnmarshaller.unmarshal(file);
    return unmarshalled1.getRecipe();
  }

}
