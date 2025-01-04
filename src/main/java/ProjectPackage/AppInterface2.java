package ProjectPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import DataTypes.Building;
import DataTypes.BuildingList;
import DataTypes.IngredientPair;
import DataTypes.IngredientsList;
import DataTypes.Item;
import DataTypes.ItemList;
import DataTypes.Recipe;
import DataTypes.RecipeList;
import DataTypes.UpgradeRecipesPair;
import InterfacePackage.DialogForm;
import InterfacePackage.InterfaceWindow;
//import static ProjectPackage.AppInterface.EditItem;
//import static ProjectPackage.AppInterface.LoadSavedData;
//import static ProjectPackage.AppInterface.NewItem_form2;


public class AppInterface2 {

    public static ItemList ITEMLIST     = new DataTypes.ItemList();
    public static RecipeList RECIPELIST = new DataTypes.RecipeList();
    public static BuildingList BUILDINGLIST = new DataTypes.BuildingList();

    public static ArrayList<String> ITEMCATEGORIES     = new ArrayList<>();
    public static ArrayList<String> RECIPECATEGORIES   = new ArrayList<>();
    public static ArrayList<String> BUILDINGCATEGORIES = new ArrayList<>();
    public static ArrayList<String> UPGRADECATEGORIES  = new ArrayList<>();

    public static String DATAFOLDER = "SavedData";

    public static String itemlist_file    = "/itemlist.json";
    public static String recipelist_file  = "/recipelist.json";
    public static String buildinglist_file= "/buildinglist.json";
    //public static String upgradelist_file = "/upgradelist.json";

    public static String itemcategories_file    = "/itemcategories.json";
    public static String recipecategories_file  = "/recipecategories.json";
    public static String buildingcategories_file= "/buildingcategories.json";
    public static String upgradecategories_file = "/upgradecategories.json";

    
        
    static Color default_window_bg      = Color.decode("#1e1e1e");
    static Color default_button_bgColor = Color.decode("#2e2e2e");
    static Color default_accent_bgColor = Color.decode("#444444");
    static Color default_button_fgColor = Color.decode("#D9D9D9");
    static Color default_teal           = Color.decode("#008080");
    static Color default_salmon         = Color.decode("#a86561");
    static int default_fontsize = 14;
    static int default_borderradius = 6;



    /* 
    LAYOUT 1
    // LOAD ITEMS
    JButton Load_Button = window1.getButton("Load data", default_button_bgColor, default_button_fgColor, default_fontsize, default_borderradius);
    window1.addCompToMainPanel(Load_Button, 0, 0, 3, 1, GridBagConstraints.HORIZONTAL, 1, 2);
    Load_Button.addActionListener(e -> LoadSavedData("SavedData"));
    
    // ADD ITEM
    JButton AddItem_Button = window1.getButton("Add Item", default_button_bgColor, default_button_fgColor, default_fontsize, default_borderradius);
    window1.addCompToMainPanel(AddItem_Button, 0, 1, 1, 2, GridBagConstraints.HORIZONTAL, 1, 1);
    AddItem_Button.addActionListener(e -> NewItem_form2(""));
    
    // EDIT ITEM
    JButton EditItem_Button = window1.getButton("Edit Item", default_button_bgColor, default_button_fgColor, default_fontsize, default_borderradius);
    window1.addCompToMainPanel(EditItem_Button, 1, 1, 1, 2, GridBagConstraints.HORIZONTAL, 1, 1);
    EditItem_Button.addActionListener(e -> EditItem());
    
    // SAVE ITEM LIST
    JButton SaveItems_Button = window1.getButton("Save items", default_button_bgColor, default_button_fgColor, default_fontsize, default_borderradius);
    window1.addCompToMainPanel(SaveItems_Button, 2, 1, 1, 2, GridBagConstraints.HORIZONTAL, 1, 1);
    SaveItems_Button.addActionListener(e -> ITEMLIST.SaveItems("SavedData/itemlist.json"));
    
    // NEW BUILDING
    JButton NewBuilding_Button = window1.getButton("New building", default_teal, default_button_fgColor, default_fontsize, default_borderradius);
    window1.addCompToMainPanel(NewBuilding_Button, 0, 3, 1, 2, GridBagConstraints.HORIZONTAL, 0.2, 1);
    //NewBuilding_Button.addActionListener(e -> EditItem());


    // PANEL TO ADD ALL THE CATEGORIES
    JPanel panelito = window1.getPanelGBC(default_accent_bgColor);
    TitledBorder border_ = BorderFactory.createTitledBorder("Add categories");
    border_.setTitleColor( default_teal );
    panelito.setBorder(border_);
    window1.addCompToMainPanel(panelito, 1, 3, 1, 2, GridBagConstraints.HORIZONTAL, 1, 1);

    // NEW ITEM CATHEGORY
    JButton NewItemCategory_Button = window1.getButton("New item category", default_button_bgColor, default_button_fgColor, default_fontsize, default_borderradius);
    window1.addComp(NewItemCategory_Button, panelito, 1, 3, 1, 1, GridBagConstraints.HORIZONTAL, 1, 1);
    //NewItemCategory_Button.addActionListener(e -> EditItem());


    // NEW RECIOPE CATHEGORY
    JButton NewRecipeCategory_Button = window1.getButton("Edit Item", default_button_bgColor, default_button_fgColor, default_fontsize, default_borderradius);
    window1.addComp(NewRecipeCategory_Button, panelito, 1, 4, 1, 1, GridBagConstraints.HORIZONTAL, 1, 1);
    //NewRecipeCategory_Button.addActionListener(e -> EditItem());
    */




    // CATEGORIES
    private static void newItemCategoryAction(JFrame frame){
        DialogForm dialogform = new DialogForm(frame, "New item category", default_button_bgColor, 
            default_button_fgColor, default_accent_bgColor, Color.decode("#999999"));

        dialogform.addTextOption("Item category");
        dialogform.setVisible();
        dialogform.submitButton.addActionListener(e -> readNewCategoryForm(frame, dialogform, "item"));
    }

    private static void newRecipeCategoryAction(JFrame frame){
        DialogForm dialogform = new DialogForm(frame, "New recipe category", default_button_bgColor, 
            default_button_fgColor, default_accent_bgColor, Color.decode("#999999"));

        dialogform.addTextOption("Recipe category");
        dialogform.setVisible();
        dialogform.submitButton.addActionListener(e -> readNewCategoryForm(frame, dialogform, "recipe"));        
    }

    private static void newBuildingCategoryAction(JFrame frame){
        DialogForm dialogform = new DialogForm(frame, "New building category", default_button_bgColor, 
            default_button_fgColor, default_accent_bgColor, Color.decode("#999999"));

        dialogform.addTextOption("Building category");
        dialogform.setVisible();
        dialogform.submitButton.addActionListener(e -> readNewCategoryForm(frame, dialogform, "building"));
    }

    private static void newBuildingUpgradeAction(JFrame frame){
        DialogForm dialogform = new DialogForm(frame, "New building upgrade", default_button_bgColor, 
            default_button_fgColor, default_accent_bgColor, Color.decode("#999999"));

        dialogform.addTextOption("Building upgrade");
        dialogform.setVisible();
        dialogform.submitButton.addActionListener(e -> readNewCategoryForm(frame, dialogform, "upgrade"));
    }


    // CATEGORYTYPE SHOULD BE item, recipe, building or upgrade
    private static void readNewCategoryForm(JFrame frame, DialogForm dialogform, String categoryType_){
        System.out.println("[Adding new " + categoryType_ + " category]");
        ArrayList<String> CATEGORYLIST_ = new ArrayList<>();
        switch (categoryType_) {
            case "item":
                CATEGORYLIST_ = ITEMCATEGORIES; break;
            case "recipe":
                CATEGORYLIST_ = RECIPECATEGORIES; break;
            case "building":
                CATEGORYLIST_ = BUILDINGCATEGORIES; break;
            case "upgrade":
                CATEGORYLIST_ = UPGRADECATEGORIES; break;
            default: break;
        }

        String new_category = dialogform.parseStringField(0);


        // VERIFY IF DOESNT EXIST YET BEFORE ADDING
        boolean found = false;
        int i = 0;
        int n_items = CATEGORYLIST_.size();
        while(!found && i < n_items){
            if(CATEGORYLIST_.get(i) == null ? new_category == null : CATEGORYLIST_.get(i).equals(new_category)){
                found = true;
            } else { i++; }
        }
        if(!found){System.out.println("[NAME NOT FOUND]");}

        if(!found){
            CATEGORYLIST_.add(new_category); // ADD THIS ITEM TO THE LIST
        } else {
            System.out.println("[NAME ALREADY BEEN USED. IGNORING]");
            JOptionPane.showMessageDialog(frame, "Name has already been used! Ignoring!",
                "Ignore message", JOptionPane.WARNING_MESSAGE);
        }

        // SAVE DIRECTLY TO FILE
    }


    private static void saveCategoriesAction(){
        // DEFINE MAPPER AND PRINTER
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(om.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(Visibility.ANY)
                .withGetterVisibility(Visibility.NONE)
                .withSetterVisibility(Visibility.NONE)
                .withCreatorVisibility(Visibility.NONE));

        System.out.println("[ATTEMPTING TO SAVE EVERYTHING]");
        try {
            // covert Java object to JSON strings
            om.writeValue(new File(DATAFOLDER + itemcategories_file), ITEMCATEGORIES);

            om.writeValue(new File(DATAFOLDER + recipecategories_file), RECIPECATEGORIES);
            
            om.writeValue(new File(DATAFOLDER + buildingcategories_file), BUILDINGCATEGORIES);
            
            om.writeValue(new File(DATAFOLDER + upgradecategories_file), UPGRADECATEGORIES);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    private static ArrayList<String> loadCategoriesFromFile(String FILENAME){
        ObjectMapper om = new ObjectMapper();
        //om.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        printer.indentArraysWith(new DefaultIndenter("  ", "\n"));
        printer.withObjectIndenter(new DefaultIndenter("  ", "\n"));
        
        ArrayList<String> categorylist;

        try {
            categorylist = om.readValue(new File(FILENAME), ArrayList.class);
            System.out.println("Items read from JSON:");
            System.out.println(categorylist.toString());
            JOptionPane.showMessageDialog(null, FILENAME+" Data loaded successfully","Success",JOptionPane.WARNING_MESSAGE);

        } catch (IOException e) {            
            JOptionPane.showMessageDialog(null,"Data loading failed! Check the code","Warning",JOptionPane.WARNING_MESSAGE);
            throw new RuntimeException(e);
        }
        return categorylist;
    }

    // ====================================== END OF CATEGORIES =======================================



    private static void newItemForm(JFrame frame){
        DialogForm dialogform = new DialogForm(frame, "New item", default_button_bgColor, 
        default_button_fgColor, default_accent_bgColor, Color.decode("#999999"));

        //if(initial_item_name.equals("")){ 
        dialogform.addTextOption("Item name");
        dialogform.addDropdownField("Item category", ITEMCATEGORIES.toArray(new String[0]), -1);
        dialogform.addTextOption("Storage size");
        dialogform.addTextOption("Weight");

        dialogform.addCheckOption("Transportable", true);
        dialogform.addCheckOption("Durable", true);
        dialogform.addTextOptionWithDefault("How long to go bad", "0");

        System.out.println("[classe] " + BUILDINGCATEGORIES.getClass());
        //dialogform.addMultiselectCombobox("TESTESTES", BUILDINGCATEGORIES.toArray(new String[0]));

        dialogform.setVisible();

        dialogform.submitButton.addActionListener(e -> readNewItemForm(frame, dialogform));
    }


    

    private static void editItemForm(JFrame frame, String itemname){
        // READ ITEM
        Item item = ITEMLIST.getItemList().get(ITEMLIST.getIndexOfItemByName(itemname));

        DialogForm dialogform = new DialogForm(frame, "New item", default_button_bgColor, 
        default_button_fgColor, default_accent_bgColor, Color.decode("#999999"));

        dialogform.addTextOptionWithDefault("Item name", item.getName());
        dialogform.addDropdownField("Item category", ITEMCATEGORIES.toArray(new String[0]), ITEMCATEGORIES.indexOf(item.getCategory()));
        dialogform.addTextOptionWithDefault("Storage size", String.valueOf(item.getStorageSpace()));
        dialogform.addTextOptionWithDefault("Weight", String.valueOf(item.getWeight()));

        dialogform.addCheckOption("Transportable", item.getIsTransportable());
        dialogform.addCheckOption("Durable", item.getIsDurable());
        dialogform.addTextOptionWithDefault("How long to go bad", String.valueOf(item.getHowLongToGoBad()));

        dialogform.setVisible();

        dialogform.submitButton.addActionListener(e -> readNewItemForm(frame, dialogform));
    }
    

    // NEED TO WRITE ONE OF THESE FOR EACH FORM
    private static void readNewItemForm(JFrame frame, DialogForm dialogform){
        System.out.println("[Adding new item]: Print na nova funcao");
        //ArrayList<JComponent> componentFieldList = dialogform.getComponentFieldList();

        String item_name             = dialogform.parseStringField(0);
        String item_category         = dialogform.parseDropdownField(1);

        double item_storage_space    = dialogform.parseDoubleField(2);
        double item_weight           = dialogform.parseDoubleField(3);

        boolean isTransportable      = dialogform.parseCheckbox(4);
        boolean isDurable            = dialogform.parseCheckbox(5);

        double how_long_to_go_bad    = dialogform.parseDoubleField(6);

        //ArrayList<String> TESTESTES  = dialogform.parseMultiselectCombobox(7);
        //System.out.println(TESTESTES.toArray(new String[0]));
        //System.out.println(TESTESTES.toString());

        
        // CREATE ITEM OBJECT AND ADD IT TO THIS.ITEMLIST
        Item item = new Item(item_name, item_category, item_storage_space, item_weight, 
            how_long_to_go_bad, isDurable, isDurable, isTransportable);

        // VERIFY IF DOESNT EXIST YET BEFORE ADDING
        int index_of_this = ITEMLIST.getIndexOfItemByName(item_name);
        boolean found = index_of_this != -1;
        if(!found){
            ITEMLIST.add(item); // ADD THIS ITEM TO THE LIST
        } else {
            System.out.println("[NAME ALREADY BEEN USED. OVERWRITING]");
            JOptionPane.showMessageDialog(frame, "Name has already been used! Overwriting!",
                "Overwrite message", JOptionPane.WARNING_MESSAGE);
            ITEMLIST.set(index_of_this, item);
        }

        // DEFINE MAPPER AND PRINTER
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter().withObjectIndenter(new DefaultIndenter("  ", "\n"));
        printer.indentArraysWith(new DefaultIndenter("  ", "\n"));

        try {
            // covert Java object to JSON strings
            String json = om.writer(printer).writeValueAsString(item);

            // output: {"name":"mkyong","age":42}
            System.out.println(json);

            om.writeValue(new File("item1.json"), item);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void EditItemAction(JFrame frame) {
        // OPEN DIALOG TO SELECT THE THING TO EDIT

        // GET ITEM OPTIONS
        String[] ItemOptionsList = ITEMLIST.getItemListNames();

        // create a dialog Box
        JDialog d_editItem = new JDialog(frame, "Edit item");
        d_editItem.setBackground(Color.decode("#1e1e1e"));
        
        d_editItem.setSize(200, 200);
        d_editItem.setLayout(new BorderLayout());
        
        // Create a panel to hold the form components
        JPanel formPanel = new JPanel();
        

        // DROPDOWN WITH THE OPTIONS
        @SuppressWarnings({ "rawtypes", "unchecked" })
        JComboBox item_drop_List = new JComboBox(ItemOptionsList);
        item_drop_List.setSelectedIndex(0);
        //petList.addActionListener(AppInterface); // MIGHT DAR BARRACA
        formPanel.add(item_drop_List);


        // BUTTON TO CHOSE ITEM TO EDIT
        JButton Confirm_Button = new JButton("Confirm");
        //OnClickEventHelper.setOnClickColor(SaveItems_Button, Color.decode("#232323"), Color.decode("#2e2e2e"));
        System.out.println("[editing item #]: " + (String) item_drop_List.getSelectedItem() );
        Confirm_Button.addActionListener(e -> d_editItem.dispose());
        Confirm_Button.addActionListener(e -> editItemForm(frame, (String) item_drop_List.getSelectedItem()));
        formPanel.add(Confirm_Button);

        // FINALE
        formPanel.setBackground(Color.decode("#555555"));

        d_editItem.add(formPanel, BorderLayout.CENTER);

        d_editItem.getContentPane().setBackground(Color.decode("#303030"));

        d_editItem.setLocationRelativeTo(null);

        // set visibility of dialog
        d_editItem.setVisible(true);
    }


    // ======================================== END OF ITEM ========================================


    public static void NewRecipeAction(JFrame frame) {
        // OPEN DIALOG TO SELECT THE number of inputs and outputs
        DialogForm newrecipePreDialog = new DialogForm(frame, "Set recipe number of items", 
            default_button_bgColor, default_button_fgColor, default_accent_bgColor, Color.decode("#999999"));

        newrecipePreDialog.addTextOptionWithDefault("Number of ingredients", "1");
        newrecipePreDialog.addTextOptionWithDefault("Number of outputs", "1");

        newrecipePreDialog.setVisible();

        newrecipePreDialog.submitButton.addActionListener(e -> readNewRecipePreForm(frame, newrecipePreDialog));
    }

    private static void readNewRecipePreForm(JFrame frame, DialogForm newrecipePreDialog){
        // READ ENTRIES OF THE SMALL FORM
        int ingredient_count = newrecipePreDialog.parseIntField(0);
        int output_count     = newrecipePreDialog.parseIntField(1);

        NewRecipeForm(frame, "", ingredient_count, output_count);
    }


    public static void EditRecipeAction(JFrame frame) {
        DialogForm editrecipePreDialog = new DialogForm(frame, "Edit recipe", 
            default_button_bgColor, default_button_fgColor, default_accent_bgColor, Color.decode("#999999"));

        String[] recipes_ = RECIPELIST.getRecipeListNames(); 
        editrecipePreDialog.addDropdownField("Select recipe", recipes_, 0);
        
        editrecipePreDialog.setVisible();
        editrecipePreDialog.submitButton.addActionListener(e -> readEditRecipePreForm(frame, editrecipePreDialog));
    }

    private static void readEditRecipePreForm(JFrame frame, DialogForm editrecipePreDialog){
        String recipename = editrecipePreDialog.parseDropdownField(0);

        Recipe recipe_ = RECIPELIST.get(RECIPELIST.getIndexOfRecipeByName(recipename));

        NewRecipeForm(frame, recipe_.getName(), recipe_.getN_ingredients(), recipe_.getN_outputs());
    }

    // CALLED AT EDIT OR NEW
    private static void NewRecipeForm(JFrame frame, String recipename, int ingredient_count, int output_count){
        // READ ITEM
        Recipe recipe;
        if(recipename.equals("")){
            recipe = new Recipe(ingredient_count, output_count);
        } else {
            recipe = RECIPELIST.getRecipeList().get(RECIPELIST.getIndexOfRecipeByName(recipename));
        }

        DialogForm dialogform = new DialogForm(frame, "New recipe", default_button_bgColor, 
            default_button_fgColor, default_accent_bgColor, Color.decode("#999999"));

        dialogform.addTextOptionWithDefault("Recipe name", recipe.getName());
        dialogform.addDropdownField("Recipe category", RECIPECATEGORIES.toArray(new String[0]), RECIPECATEGORIES.indexOf(recipe.getCategory()));
        
        String[] ItemsList = ITEMLIST.getItemListNames();// .toArray(new String[0]);
        for (int i = 0; i < ingredient_count; i++) {
            IngredientPair itempair_ = recipe.getIngredientslist().get(i);
            dialogform.addDropdownField("Ingredient #"+(i+1), ItemsList, ITEMLIST.getIndexOfItemByName(itempair_.getItem_name()));
            dialogform.addTextOptionWithDefault(" - Count #"+(i+1), Double.toString(itempair_.getCount()));
        }
        for (int i = 0; i < output_count; i++) {
            IngredientPair itempair_ = recipe.getOutputslist().get(i);
            dialogform.addDropdownField("Output #"+(i+1), ItemsList, ITEMLIST.getIndexOfItemByName(itempair_.getItem_name()));
            dialogform.addTextOptionWithDefault(" - Count #"+(i+1), Double.toString(itempair_.getCount()));
            dialogform.addTextOptionWithDefault(" - Probability #"+(i+1), Double.toString(itempair_.getProbability()));
        }

        dialogform.addTextOptionWithDefault("Duration s", Double.toString(recipe.getDuration()));
        dialogform.addCheckOption("Enabled", recipe.isEnabled());

        dialogform.setVisible();

        dialogform.submitButton.addActionListener(e -> readNewRecipeForm(frame, dialogform, ingredient_count, output_count));
            
    }
    

    private static void readNewRecipeForm(JFrame frame, DialogForm dialogform, int ingredient_count, int output_count) {
        System.out.println("#[Adding new RECIPE]: Print na nova funcao");
        //ArrayList<JComponent> componentFieldList = dialogform.getComponentFieldList();

        int field_i = 0;
        String recipe_name           = dialogform.parseStringField(field_i++);
        String recipe_category       = dialogform.parseDropdownField(field_i++);

        // READS THE PAIRS OF INGREDIENT-COUNT
        IngredientsList ingredientlist = new IngredientsList();
        for (int i = 0; i < ingredient_count; i++) {
            String _ingredient_name  = dialogform.parseDropdownField(field_i++);
            double _ingredient_count = dialogform.parseDoubleField(field_i++);
            ingredientlist.add(new IngredientPair(_ingredient_name, _ingredient_count, 1));
        }
        IngredientsList outputlist = new IngredientsList();
        for (int i = 0; i < output_count; i++) {
            String _ingredient_name  = dialogform.parseDropdownField(field_i++);
            double _ingredient_count = dialogform.parseDoubleField(field_i++);
            double _ingredient_prob  = dialogform.parseDoubleField(field_i++);
            outputlist.add(new IngredientPair(_ingredient_name, _ingredient_count, _ingredient_prob));
        }

        double duration = dialogform.parseDoubleField(field_i++);

        boolean enabled = dialogform.parseCheckbox(field_i++);

        Recipe recipe = new Recipe(recipe_name, recipe_category, ingredient_count, output_count, ingredientlist, outputlist, duration, enabled);


        // VERIFY IF DOESNT EXIST YET BEFORE ADDING
        int index_of_this = RECIPELIST.getIndexOfRecipeByName(recipe_name);
        boolean found = index_of_this != -1;
        if(!found){
            RECIPELIST.add(recipe); // ADD THIS ITEM TO THE LIST
        } else {
            System.out.println("[NAME ALREADY BEEN USED. OVERWRITING]");
            JOptionPane.showMessageDialog(frame, "Name has already been used! Overwriting!",
                "Overwrite message", JOptionPane.WARNING_MESSAGE);
            RECIPELIST.set(index_of_this, recipe);
        }

        // DEFINE MAPPER AND PRINTER APAGAR
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter().withObjectIndenter(new DefaultIndenter("  ", "\n"));
        printer.indentArraysWith(new DefaultIndenter("  ", "\n"));

        try {
            // covert Java object to JSON strings
            String json = om.writer(printer).writeValueAsString(recipe);

            // output: {"name":"mkyong","age":42}
            System.out.println(json);

            om.writeValue(new File("item1.json"), recipe);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // ======================================== END OF RECIPE ========================================


    
    public static void NewBuildingAction(JFrame frame) {
        // OPEN DIALOG TO SELECT THE number of inputs and outputs
        DialogForm newbuildingPreDialog = new DialogForm(frame, "Set building number of upgrades", 
            default_button_bgColor, default_button_fgColor, default_accent_bgColor, Color.decode("#999999"));

        newbuildingPreDialog.addTextOptionWithDefault("Number of upgrades", "1");

        newbuildingPreDialog.setVisible();

        newbuildingPreDialog.submitButton.addActionListener(e -> readNewBuildingPreForm(frame, newbuildingPreDialog));
    }

    private static void readNewBuildingPreForm(JFrame frame, DialogForm newbuildingPreDialog){
        // READ ENTRIES OF THE SMALL FORM
        int n_upgrades = newbuildingPreDialog.parseIntField(0);

        NewBuildingForm(frame, "", n_upgrades);
    }


    public static void EditBuildingAction(JFrame frame) {
        DialogForm editbuildingPreDialog = new DialogForm(frame, "Edit building", 
            default_button_bgColor, default_button_fgColor, default_accent_bgColor, Color.decode("#999999"));

        String[] buildings_ = BUILDINGLIST.getBuildingListNames(); 
        editbuildingPreDialog.addDropdownField("Select building", buildings_, 0);
        
        editbuildingPreDialog.setVisible();
        editbuildingPreDialog.submitButton.addActionListener(e -> readEditBuildingPreForm(frame, editbuildingPreDialog));
    }

    private static void readEditBuildingPreForm(JFrame frame, DialogForm editbuildingPreDialog){
        String recipename = editbuildingPreDialog.parseDropdownField(0);

        Building building_ = BUILDINGLIST.get(BUILDINGLIST.getIndexOfBuildingByName(recipename));

        NewBuildingForm(frame, building_.getName(), building_.getN_upgrades());
    }

    // CALLED AT EDIT OR NEW
    private static void NewBuildingForm(JFrame frame, String buildingname, int n_upgrades){
        // READ ITEM
        Building building;
        if(buildingname.equals("")){
            building = new Building(n_upgrades);
        } else {
            building = BUILDINGLIST.getBuildingList().get(BUILDINGLIST.getIndexOfBuildingByName(buildingname));
        }

        DialogForm dialogform = new DialogForm(frame, "New Building", default_button_bgColor, 
            default_button_fgColor, default_accent_bgColor, Color.decode("#999999"));

        dialogform.addTextOptionWithDefault("Building name", building.getName());
        dialogform.addDropdownField("Building category", BUILDINGCATEGORIES.toArray(new String[0]), BUILDINGCATEGORIES.indexOf(building.getCategory()));
        
        String[] UpgradeCatList = UPGRADECATEGORIES.toArray(new String[0]);// .toArray(new String[0]);
        String[] RecipeCatList  = RECIPECATEGORIES.toArray( new String[0]);
        for (int i = 0; i < n_upgrades; i++) {
            UpgradeRecipesPair upgraderecipe_ = building.getUpgradeRecipesPairs().get(i);
            //dialogform.addDropdownField("Upgrade #"+(i+1), UpgradeCatList, ITEMLIST.getIndexOfItemByName(itempair_.getItem_name()));
            int selectedindex_ = UPGRADECATEGORIES.indexOf(upgraderecipe_.getUpgrade_name());
            System.out.println("[[[[[[" + selectedindex_);
            dialogform.addDropdownField("Upgrade #"+(i+1), UpgradeCatList, selectedindex_);
            if(selectedindex_ == -1){
                dialogform.addMultiselectCombobox(" - Recipes enabled #"+(i+1), RecipeCatList);
            }
            else {
                dialogform.addMultiselectComboboxDefault(" - Recipes enabled #"+(i+1), RecipeCatList, upgraderecipe_.getRecipes_enabled());
            }
        }

        dialogform.addTextOptionWithDefault("Base # operations", Integer.toString(building.getBaseNumOperations()));
        dialogform.addTextOptionWithDefault("Efficiency multiplier", Double.toString(building.getEfficiencyMultiplier()));

        dialogform.setVisible();

        dialogform.submitButton.addActionListener(e -> readNewBuildingForm(frame, dialogform, n_upgrades));
    }
    

    private static void readNewBuildingForm(JFrame frame, DialogForm dialogform, int n_upgrades) {
        System.out.println("#[Adding new BUILDING]: Print na nova funcao");
        //ArrayList<JComponent> componentFieldList = dialogform.getComponentFieldList();

        int field_i = 0;
        String building_name           = dialogform.parseStringField(field_i++);
        String building_category       = dialogform.parseDropdownField(field_i++);

        // READS THE PAIRS OF INGREDIENT-COUNT
        ArrayList<UpgradeRecipesPair> upgraderecipepairs_ = new ArrayList<>();
        for (int i = 0; i < n_upgrades; i++) {
            String _upgrade_name  = dialogform.parseDropdownField(field_i++);
            ArrayList<String> _enabled_recipes = dialogform.parseMultiselectCombobox(field_i++);
            upgraderecipepairs_.add(new UpgradeRecipesPair(_upgrade_name, _enabled_recipes));
        }

        int base_num_operations      = dialogform.parseIntField(field_i++);
        double efficiency_multiplier = dialogform.parseDoubleField(field_i++);

        Building building = new Building(building_name, building_category, n_upgrades, upgraderecipepairs_, base_num_operations, efficiency_multiplier);


        // VERIFY IF DOESNT EXIST YET BEFORE ADDING
        int index_of_this = BUILDINGLIST.getIndexOfBuildingByName(building_name);
        boolean found = index_of_this != -1;
        if(!found){
            BUILDINGLIST.add(building); // ADD THIS ITEM TO THE LIST
        } else {
            System.out.println("[NAME ALREADY BEEN USED. OVERWRITING]");
            JOptionPane.showMessageDialog(frame, "Name has already been used! Overwriting!",
                "Overwrite message", JOptionPane.WARNING_MESSAGE);
            BUILDINGLIST.set(index_of_this, building);
        }

        // DEFINE MAPPER AND PRINTER APAGAR
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter().withObjectIndenter(new DefaultIndenter("  ", "\n"));
        printer.indentArraysWith(new DefaultIndenter("  ", "\n"));

        try {
            // covert Java object to JSON strings
            String json = om.writer(printer).writeValueAsString(building);

            // output: {"name":"mkyong","age":42}
            System.out.println(json);

            om.writeValue(new File("item1.json"), building);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    
    // ======================================== END OF BUILDING ========================================

    public static void LoadSavedData(String DATAFOLDER){
        ITEMLIST     = ITEMLIST.LoadFromFile(DATAFOLDER + itemlist_file);
        RECIPELIST   = RECIPELIST.LoadFromFile(DATAFOLDER + recipelist_file);
        BUILDINGLIST = BUILDINGLIST.LoadFromFile(DATAFOLDER + buildinglist_file);

        ITEMCATEGORIES     = loadCategoriesFromFile(DATAFOLDER + itemcategories_file);
        RECIPECATEGORIES   = loadCategoriesFromFile(DATAFOLDER + recipecategories_file);
        BUILDINGCATEGORIES = loadCategoriesFromFile(DATAFOLDER + buildingcategories_file);
        UPGRADECATEGORIES  = loadCategoriesFromFile(DATAFOLDER + upgradecategories_file);
    }




    public static void main(String[] args) {

        InterfaceWindow window1 = new InterfaceWindow("Main window", default_window_bg, 15, 15);
        window1.setPadding(35, 20); 
        //window1.setSize(450, 300);
        //window1.setSize(550, 400); // prolly ignorado depende do estado do pack
        window1.setInsets(15, 10); //spacing between objects
        //window1.setMargin(15, 15); // margin to the edges of the window


        // LOAD ITEMS
        JButton Load_Button = window1.getButton("Load data", default_salmon, default_button_fgColor, default_fontsize, default_borderradius);
        window1.addCompToMainPanel(Load_Button, 0, 0, 4, 1, GridBagConstraints.HORIZONTAL, 1, 2);
        Load_Button.addActionListener(e -> LoadSavedData("SavedData"));


        // PANEL TO ADD ALL THE CATEGORIES
        JPanel panelito = window1.getPanelGBC(default_window_bg);
        TitledBorder border_ = BorderFactory.createTitledBorder("Add categories");
        border_.setTitleColor( default_button_fgColor );
        panelito.setBorder(border_);
        window1.addCompToMainPanel(panelito, 0, 1, 1, 8, GridBagConstraints.HORIZONTAL, 1, 1);


        // NEW ITEM CATHEGORY
        JButton NewItemCategory_Button = window1.getButton("New item category", default_button_bgColor, default_button_fgColor, default_fontsize, default_borderradius);
        window1.addCompSpecial(NewItemCategory_Button,      panelito, 0, 0, 1, 1, GridBagConstraints.HORIZONTAL, 1, 1, 10, 20, 5, 3);
        NewItemCategory_Button.addActionListener(e -> newItemCategoryAction(window1.getThisFrame()));

        // NEW RECIOPE CATHEGORY
        JButton NewRecipeCategory_Button = window1.getButton("New recipe category", default_button_bgColor, default_button_fgColor, default_fontsize, default_borderradius);
        window1.addCompSpecial(NewRecipeCategory_Button,    panelito, 0, 1, 1, 1, GridBagConstraints.HORIZONTAL, 1, 1, 10, 20, 5, 3);
        NewRecipeCategory_Button.addActionListener(e -> newRecipeCategoryAction(window1.getThisFrame()));

        // NEW RECIOPE CATHEGORY
        JButton NewBuildingCategory_Button = window1.getButton("New building category", default_button_bgColor, default_button_fgColor, default_fontsize, default_borderradius);
        window1.addCompSpecial(NewBuildingCategory_Button,  panelito, 0, 2, 1, 1, GridBagConstraints.HORIZONTAL, 1, 1, 10, 20, 5, 3);
        NewBuildingCategory_Button.addActionListener(e -> newBuildingCategoryAction(window1.getThisFrame()));

        // NEW RECIOPE CATHEGORY
        JButton NewBuildingUpgrade_Button = window1.getButton("New building upgrade", default_button_bgColor, default_button_fgColor, default_fontsize, default_borderradius);
        window1.addCompSpecial(NewBuildingUpgrade_Button,   panelito, 0, 3, 1, 1, GridBagConstraints.HORIZONTAL, 1, 1, 10, 20, 5, 3);
        NewBuildingUpgrade_Button.addActionListener(e -> newBuildingUpgradeAction(window1.getThisFrame()));

        // SAVE CATEGORIES
        JButton SaveCategories_Button = window1.getButton("Save categories", default_teal, default_button_fgColor, default_fontsize, default_borderradius);
        window1.addCompSpecial(SaveCategories_Button,   panelito, 0, 4, 1, 1, GridBagConstraints.HORIZONTAL, 1, 1, 10, 20, 5, 3);
        SaveCategories_Button.addActionListener(e -> saveCategoriesAction());



        // ADD ITEM =======================================================================================
        JButton AddItem_Button = window1.getButton("New Item", default_button_bgColor, default_button_fgColor, default_fontsize, default_borderradius);
        window1.addCompToMainPanel(AddItem_Button, 1, 1, 1, 2, GridBagConstraints.HORIZONTAL, 1, 1);
        AddItem_Button.addActionListener(e -> newItemForm(window1.getThisFrame()));
        
        // EDIT ITEM
        JButton EditItem_Button = window1.getButton("Edit Item", default_button_bgColor, default_button_fgColor, default_fontsize, default_borderradius);
        window1.addCompToMainPanel(EditItem_Button, 2, 1, 1, 1, GridBagConstraints.HORIZONTAL, 1, 1);
        EditItem_Button.addActionListener(e -> EditItemAction(window1.getThisFrame()));
        
        // SAVE ITEM LIST
        JButton SaveItems_Button = window1.getButton("Save items", default_teal, default_button_fgColor, default_fontsize, default_borderradius);
        window1.addCompToMainPanel(SaveItems_Button, 3, 1, 1, 1, GridBagConstraints.HORIZONTAL, 1, 1);
        SaveItems_Button.addActionListener(e -> ITEMLIST.SaveItems(DATAFOLDER + itemlist_file));



        // NEW BUILDING =======================================================================================
        JButton NewBuilding_Button = window1.getButton("New building", default_button_bgColor, default_button_fgColor, default_fontsize, default_borderradius);
        window1.addCompToMainPanel(NewBuilding_Button, 1, 3, 1, 2, GridBagConstraints.HORIZONTAL, 0.2, 1);
        NewBuilding_Button.addActionListener(e -> NewBuildingAction(window1.getThisFrame()));

        // EDIT BUILDING
        JButton EditBuilding_Button = window1.getButton("Edit building", default_button_bgColor, default_button_fgColor, default_fontsize, default_borderradius);
        window1.addCompToMainPanel(EditBuilding_Button, 2, 3, 1, 1, GridBagConstraints.HORIZONTAL, 1, 1);
        EditBuilding_Button.addActionListener(e -> EditBuildingAction(window1.getThisFrame()));
        
        // SAVE ITEM LIST
        JButton SaveBuildings_Button = window1.getButton("Save buildings", default_teal, default_button_fgColor, default_fontsize, default_borderradius);
        window1.addCompToMainPanel(SaveBuildings_Button, 3, 3, 1, 1, GridBagConstraints.HORIZONTAL, 1, 1);
        SaveBuildings_Button.addActionListener(e -> BUILDINGLIST.SaveBuildings(DATAFOLDER + buildinglist_file));



        // NEW RECIPE =======================================================================================
        JButton NewRecipe_Button = window1.getButton("New recipe", default_button_bgColor, default_button_fgColor, default_fontsize, default_borderradius);
        window1.addCompToMainPanel(NewRecipe_Button, 1, 5, 1, 2, GridBagConstraints.HORIZONTAL, 0.2, 1);
        NewRecipe_Button.addActionListener(e -> NewRecipeAction(window1.getThisFrame()));

        // EDIT BUILDING
        JButton EditRecipe_Button = window1.getButton("Edit recipe", default_button_bgColor, default_button_fgColor, default_fontsize, default_borderradius);
        window1.addCompToMainPanel(EditRecipe_Button, 2, 5, 1, 1, GridBagConstraints.HORIZONTAL, 1, 1);
        EditRecipe_Button.addActionListener(e -> EditRecipeAction(window1.getThisFrame()));
        
        // SAVE ITEM LIST
        JButton SaveRecipes_Button = window1.getButton("Save recipes", default_teal, default_button_fgColor, default_fontsize, default_borderradius);
        window1.addCompToMainPanel(SaveRecipes_Button, 3, 5, 1, 1, GridBagConstraints.HORIZONTAL, 1, 1);
        SaveRecipes_Button.addActionListener(e -> RECIPELIST.SaveRecipes(DATAFOLDER + recipelist_file));




        window1.displayWindow();
    }
}

