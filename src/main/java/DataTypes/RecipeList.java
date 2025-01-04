package DataTypes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RecipeList {
    @JsonProperty("recipelist")
    List<Recipe> recipelist;


    
    public RecipeList(){
        // empty constructor
        this.recipelist = new ArrayList<>();
    }

    public RecipeList(ArrayList<Recipe> recipelist) {
        this.recipelist = recipelist;
    }

    public RecipeList(List<Recipe> recipelist) {
        this.recipelist = recipelist;
    }

    public int size(){
        return recipelist.size();
    }



    public void add(Recipe recipe){
        recipelist.add(recipe);
    }

    public void set(int i, Recipe recipe){
        recipelist.set(i, recipe);
    }

    public Recipe get(int i){
        return recipelist.get(i);
    }

    public List<Recipe> getRecipeList() {
        return recipelist;
    }

    /*public void setRecipelist(ArrayList<Recipe> recipelist) {
        this.recipelist = recipelist;
    }*/
    public void setRecipelist(List<Recipe> recipelist) {
        this.recipelist = recipelist;
    }


    
    // DATA RELATED ================================================================================
    public String[] getRecipeListNames(){
        String[] RecipeListNames = new String[recipelist.size()];
        for (int i = 0; i < recipelist.size(); i++) {
            RecipeListNames[i] = recipelist.get(i).getName();
        }
        return RecipeListNames;
    }


    // RETURNS -1 IF ITEM NOT IN
    public int getIndexOfRecipeByName(String recipe_name){
        boolean found = false;
        int i = 0;
        int n_recipes = recipelist.size();
        while(!found && i < n_recipes){
            if(recipelist.get(i).getName() == null ? recipe_name == null : recipelist.get(i).getName().equals(recipe_name)){
                found = true;
            } else { i++; }
        }
        if(!found){System.out.println("[NAME NOT FOUND]"); i=-1;}
        return i;
    }
    


    // FILE HANDLING ============================================================================
    // WRITE TO FILE
    public void SaveRecipes(String FILENAME){ // "SavedData/recipelist.json"
        
        // DEFINE MAPPER AND PRINTER
        ObjectMapper om = new ObjectMapper();
        //om.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        printer.indentArraysWith(new DefaultIndenter("  ", "\n"));
        printer.withObjectIndenter(new DefaultIndenter("  ", "\n"));
        
        om.setVisibility(om.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(Visibility.ANY)
                .withGetterVisibility(Visibility.NONE)
                .withSetterVisibility(Visibility.NONE)
                .withCreatorVisibility(Visibility.NONE));

        // PRINT EACH ENTRY:
        System.out.println("\n[Print each entry] =====");
        for (int i = 0; i < recipelist.size(); i++) {
            Recipe recipe_ = recipelist.get(i); 
            try {
                String json = om.writer(printer).writeValueAsString(recipe_);
                System.out.println(json);

            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("[ATTEMPTING TO WRITE EVERYTHING]");
        try {
            om.writeValue(new File(FILENAME), this);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public RecipeList LoadFromFile(String FILENAME){
        // DEFINE MAPPER AND PRINTER
        ObjectMapper om = new ObjectMapper();
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        printer.indentArraysWith(new DefaultIndenter("  ", "\n"));
        printer.withObjectIndenter(new DefaultIndenter("  ", "\n"));
        
        RecipeList ITEMLIST_;

        try {

            ITEMLIST_ = om.readValue(new File(FILENAME), RecipeList.class);
            JOptionPane.showMessageDialog(null,
                "Recipes data loaded successfully",
                "Success",
                JOptionPane.WARNING_MESSAGE);

        } catch (IOException e) {            
            JOptionPane.showMessageDialog(null,
                "Data loading failed! Check the code",
                "Warning",
                JOptionPane.WARNING_MESSAGE);

            throw new RuntimeException(e);
        }

        return ITEMLIST_;
    }


}
