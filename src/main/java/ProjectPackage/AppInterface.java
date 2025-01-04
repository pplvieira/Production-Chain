package ProjectPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import DataTypes.Item;
import DataTypes.ItemList;
import helper_classes.CustomFontLoader;
import helper_classes.OnClickEventHelper;
import helper_classes.OnFocusEventHelper;
import helper_classes.RoundedBorder; 


// https://stackoverflow.com/questions/42594962/making-a-component-span-multiple-rows-with-gridbaglayout VER


public class AppInterface {

    static JFrame frame;

    // DATA PRODUCTION CHAINS
    //public static ArrayList<Item> ItemList = new ArrayList<>();
    public static ItemList ITEMLIST = new DataTypes.ItemList();
    
    
        public static void NewItem_action() {
            System.out.println("Veio da barriguinha moleque");
        
            // create a dialog Box
            JDialog d_newItem = new JDialog(frame, "New item");
            //d_newItem.setBackground(Color.decode("#1e1e1e"));
    
            d_newItem.setLayout(null);
            // create a label
            //JLabel l = new JLabel("this is a dialog box");
    
            //d_newItem.add(l);
    
    
    
    
            int first_column_x = 45;
            int second_column_x = 200;
            int first_line_y = 45;
            int line_yinterval = 45;
            int line_i = 0;
            
    
            // ITEM NAME
            JLabel label_name = new JLabel("Item name (no spaces)");
            label_name.setBounds(first_column_x, first_line_y + line_i * line_yinterval, 140, 19);
            label_name.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            label_name.setForeground(Color.decode("#D9D9D9"));
            d_newItem.add(label_name);
    
            JTextField value_item = new JTextField("");
            value_item.setBounds(second_column_x, first_line_y + line_i * line_yinterval, 106, 21);
            value_item.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            value_item.setBackground(Color.decode("#B2B2B2"));
            value_item.setForeground(Color.decode("#656565"));
            value_item.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
            OnFocusEventHelper.setOnFocusText(value_item, "Your Input!", Color.decode("#353535"),   Color.decode("#656565"));
            d_newItem.add(value_item);
            line_i++;
    
    
            // STORAGE SIZE
            JLabel label_storage = new JLabel("Storage size");
            label_storage.setBounds(first_column_x, first_line_y + line_i * line_yinterval, 106, 17);
            label_storage.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            label_storage.setForeground(Color.decode("#D9D9D9"));
            d_newItem.add(label_storage);
    
            JTextField value_storage = new JTextField("");
            value_storage.setBounds(second_column_x, first_line_y + line_i * line_yinterval, 106, 21);
            value_storage.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            value_storage.setBackground(Color.decode("#B2B2B2"));
            value_storage.setForeground(Color.decode("#656565"));
            value_storage.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
            OnFocusEventHelper.setOnFocusText(value_storage, "Your Input!", Color.decode("#353535"),   Color.decode("#656565"));
            d_newItem.add(value_storage);
            line_i++;
    
    
            // WEIGHT
            JLabel label_weight = new JLabel("Weight");
            label_weight.setBounds(first_column_x, first_line_y + line_i * line_yinterval, 106, 17);
            label_weight.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            label_weight.setForeground(Color.decode("#D9D9D9"));
            d_newItem.add(label_weight);
    
            JTextField value_weight = new JTextField("");
            value_weight.setBounds(second_column_x, first_line_y + line_i * line_yinterval, 106, 21);
            value_weight.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            value_weight.setBackground(Color.decode("#B2B2B2"));
            value_weight.setForeground(Color.decode("#656565"));
            value_weight.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
            OnFocusEventHelper.setOnFocusText(value_weight, "Your Input!", Color.decode("#353535"),   Color.decode("#656565"));
            d_newItem.add(value_weight);
            line_i++;
    
    
            // DURABLE
            JLabel label_durable = new JLabel("Durable?");
            label_durable.setBounds(first_column_x, first_line_y + line_i * line_yinterval, 106, 17);
            label_durable.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            label_durable.setForeground(Color.decode("#D9D9D9"));
            d_newItem.add(label_durable);
    
            JCheckBox value_durable = new JCheckBox("durable?");
            //value_durable.setBounds(second_column_x, first_line_y + line_i * line_yinterval, 30, 30);
            //value_durable.setMnemonic(KeyEvent.VK_C); 
            value_durable.setSelected(true);
            d_newItem.add(value_durable);
            line_i++;
    
    
            // STORABLE/EXPIRING
            JLabel label_storable = new JLabel("Storable/expiring");
            label_storable.setBounds(first_column_x, first_line_y + line_i * line_yinterval, 106, 17);
            label_storable.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            label_storable.setForeground(Color.decode("#D9D9D9"));
            d_newItem.add(label_storable);
    
            JCheckBox value_storable = new JCheckBox("Storable?");
            //value_storable.setBounds(second_column_x, first_line_y + line_i * line_yinterval, 30, 30);
            value_storable.setSelected(true);
            d_newItem.add(value_storable);
            line_i++;
    
    
            // HOW LONG TO GO BAD
            JLabel label_how_long_to_go_bad = new JLabel("How long to go bad");
            label_how_long_to_go_bad.setBounds(first_column_x, first_line_y + line_i * line_yinterval, 127, 17);
            label_how_long_to_go_bad.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            label_how_long_to_go_bad.setForeground(Color.decode("#D9D9D9"));
            d_newItem.add(label_how_long_to_go_bad);
    
            JTextField value_how_long_to_go_bad = new JTextField("");
            value_how_long_to_go_bad.setBounds(second_column_x, first_line_y + line_i * line_yinterval, 106, 21);
            value_how_long_to_go_bad.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            value_how_long_to_go_bad.setBackground(Color.decode("#B2B2B2"));
            value_how_long_to_go_bad.setForeground(Color.decode("#656565"));
            value_how_long_to_go_bad.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
            OnFocusEventHelper.setOnFocusText(value_how_long_to_go_bad, "Your Input!", Color.decode("#353535"),   Color.decode("#656565"));
            d_newItem.add(value_how_long_to_go_bad);
            line_i++;
    
    
            // TRANSPORTABLE
            JLabel label_transportable = new JLabel("Transportable");
            label_transportable.setBounds(first_column_x, first_line_y + line_i * line_yinterval, 106, 17);
            label_transportable.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            label_transportable.setForeground(Color.decode("#D9D9D9"));
            d_newItem.add(label_transportable);
    
            JCheckBox value_transportable = new JCheckBox("Transportable?", true);
            //value_transportable.setBounds(second_column_x, first_line_y + line_i * line_yinterval, 30, 30);
            value_transportable.setSelected(true);
            d_newItem.add(value_transportable);
            line_i++;
    
    
    
            // setsize of dialog
            d_newItem.setSize(500, 500);
    
            d_newItem.getContentPane().setBackground(Color.decode("#1e1e1e"));
    
            // set visibility of dialog
            d_newItem.setVisible(true);
        
        }
    
    
    
    
        // CREATE FORM WINDOW WHEN CREATING NEW ITEM
        public static void NewItem_form2(String initial_item_name) {
    
            System.out.println("Veio da barriguinha moleque dois");
        
            // create a dialog Box
            JDialog d_newItem = new JDialog(frame, "New item");
            d_newItem.setBackground(Color.decode("#1e1e1e"));
            
            d_newItem.setSize(350, 400);
            d_newItem.setLayout(new BorderLayout());
            
            // Create a panel to hold the form components
            JPanel formPanel = new JPanel();
            //formPanel.setLayout(new GridBagLayout());
            formPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(5, 5, 5, 5);
    
    
            // ADD COMPONENTS
            int line_i = 0;
    
            // ITEM NAME
            gbc.gridx = 0; gbc.gridy = line_i;
            JLabel label_name = new JLabel("Item name (no spaces)");
            label_name.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            label_name.setForeground(Color.decode("#D9D9D9"));
            formPanel.add(label_name, gbc);
            
            gbc.gridx = 1;
            JTextField value_item = new JTextField(initial_item_name);
            value_item.setText(initial_item_name);
            value_item.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            value_item.setBackground(Color.decode("#B2B2B2"));
            value_item.setForeground(Color.decode("#353535")); //656565
            value_item.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
            //OnFocusEventHelper.setOnFocusText(value_item, "Your Input!", Color.decode("#353535"),   Color.decode("#656565"));
            formPanel.add(value_item, gbc);
            line_i++;
    
    
    
            // STORAGE SIZE
            gbc.gridx = 0; gbc.gridy = line_i;
            JLabel label_storage = new JLabel("Storage size");
            label_storage.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            label_storage.setForeground(Color.decode("#D9D9D9"));
            formPanel.add(label_storage, gbc);
    
            gbc.gridx = 1;
            JTextField value_storage = new JTextField("");
            value_storage.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            value_storage.setBackground(Color.decode("#B2B2B2"));
            value_storage.setForeground(Color.decode("#353535"));
            value_storage.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
            OnFocusEventHelper.setOnFocusText(value_storage, "Your Input!", Color.decode("#353535"),   Color.decode("#656565"));
            formPanel.add(value_storage, gbc);
            line_i++;
    
    
            // WEIGHT
            gbc.gridx = 0; gbc.gridy = line_i;
            JLabel label_weight = new JLabel("Weight");
            label_weight.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            label_weight.setForeground(Color.decode("#D9D9D9"));
            formPanel.add(label_weight, gbc);
    
            gbc.gridx = 1;
            JTextField value_weight = new JTextField("");
            value_weight.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            value_weight.setBackground(Color.decode("#B2B2B2"));
            value_weight.setForeground(Color.decode("#353535"));
            value_weight.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
            OnFocusEventHelper.setOnFocusText(value_weight, "Your Input!", Color.decode("#353535"),   Color.decode("#656565"));
            formPanel.add(value_weight, gbc);
            line_i++;
    
    
            // DURABLE
            gbc.gridx = 0; gbc.gridy = line_i;
            JLabel label_durable = new JLabel("Durable?");
            label_durable.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            label_durable.setForeground(Color.decode("#D9D9D9"));
            formPanel.add(label_durable, gbc);
    
            gbc.gridx = 1;
            JCheckBox value_durable = new JCheckBox("durable?");
            //value_durable.setBounds(second_column_x, first_line_y + line_i * line_yinterval, 30, 30);
            //value_durable.setMnemonic(KeyEvent.VK_C); 
            value_durable.setSelected(true);
            formPanel.add(value_durable, gbc);
            line_i++;
    
    
            // STORABLE/EXPIRING
            gbc.gridx = 0; gbc.gridy = line_i;
            JLabel label_storable = new JLabel("Storable/expiring");
            label_storable.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            label_storable.setForeground(Color.decode("#D9D9D9"));
            formPanel.add(label_storable, gbc);
    
            gbc.gridx = 1;
            JCheckBox value_storable = new JCheckBox("Storable?");
            //value_storable.setBounds(second_column_x, first_line_y + line_i * line_yinterval, 30, 30);
            value_storable.setSelected(true);
            formPanel.add(value_storable, gbc);
            line_i++;
    
    
            // HOW LONG TO GO BAD
            gbc.gridx = 0; gbc.gridy = line_i;
            JLabel label_how_long_to_go_bad = new JLabel("How long to go bad");
            label_how_long_to_go_bad.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            label_how_long_to_go_bad.setForeground(Color.decode("#D9D9D9"));
            formPanel.add(label_how_long_to_go_bad, gbc);
    
            gbc.gridx = 1;
            JTextField value_how_long_to_go_bad = new JTextField("");
            value_how_long_to_go_bad.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            value_how_long_to_go_bad.setBackground(Color.decode("#B2B2B2"));
            value_how_long_to_go_bad.setForeground(Color.decode("#353535"));
            value_how_long_to_go_bad.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
            OnFocusEventHelper.setOnFocusText(value_how_long_to_go_bad, "Your Input!", Color.decode("#353535"),   Color.decode("#656565"));
            formPanel.add(value_how_long_to_go_bad, gbc);
            line_i++;
    
    
            // TRANSPORTABLE
            gbc.gridx = 0; gbc.gridy = line_i;
            JLabel label_transportable = new JLabel("Transportable");
            label_transportable.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
            label_transportable.setForeground(Color.decode("#D9D9D9"));
            formPanel.add(label_transportable, gbc);
    
            gbc.gridx = 1;
            JCheckBox value_transportable = new JCheckBox("Transportable?", true);
            //value_transportable.setBounds(second_column_x, first_line_y + line_i * line_yinterval, 30, 30);
            value_transportable.setSelected(true);
            formPanel.add(value_transportable, gbc);
            line_i++;
    
    
    
            // Add Submit Button
            gbc.gridx = 0;
            gbc.gridy = line_i;
            gbc.gridwidth = 2;
            JButton submitButton = new JButton("Submit");
            formPanel.add(submitButton, gbc);
    
            submitButton.addActionListener(e -> d_newItem.dispose());
            submitButton.addActionListener(e -> readNewItemForm(value_item, value_storage, 
                value_weight, value_durable, value_storable, value_how_long_to_go_bad, value_transportable)); // on click
    
    
    
            formPanel.setBackground(Color.decode("#353535"));
    
            d_newItem.add(formPanel, BorderLayout.CENTER);
    
            d_newItem.getContentPane().setBackground(Color.decode("#303030"));
    
            d_newItem.setLocationRelativeTo(null);
    
            value_storage.requestFocus();
            value_storage.requestFocusInWindow();
            value_storage.grabFocus();
    
    
            // set visibility of dialog
            d_newItem.setVisible(true);
    
            // BASICALLY SET DEFAULT VALUES HERE:
            if(initial_item_name.equals("")){
                // do nothing
            } else {
                Item item_to_edit = ITEMLIST.getItemList().get(ITEMLIST.getIndexOfItemByName(initial_item_name));
            value_item.setText(item_to_edit.getName());
            value_storage.setText(String.valueOf(item_to_edit.getStorageSpace()));
            value_weight.setText( String.valueOf(item_to_edit.getWeight()));
            value_durable.setSelected(item_to_edit.getIsDurable());
            value_storable.setSelected(item_to_edit.getIsStorable());
            value_transportable.setSelected(item_to_edit.getIsTransportable());
        }

        /*  // FOCUS ON THE 2nd ENTRY
        d_newItem.addWindowListener( new WindowAdapter() {
            public void windowOpened( WindowEvent e ){
                value_storage.requestFocus();
            }
        }); 
        

        // TRY TO OVERRIDE TEXT
        
        value_item.setText(initial_item_name);
        value_item.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (value_item.getText().isEmpty() || value_item.getText().equals("")) {
                    value_item.setText(initial_item_name);
                    value_item.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (value_item.getText().isEmpty()) {
                    value_item.setText(initial_item_name);
                    value_item.setForeground(Color.BLACK);
                }
            }
        });
        */

    }


    public static void readNewItemForm(JTextField value_item, JTextField value_storage, JTextField value_weight, 
    JCheckBox value_durable, JCheckBox value_storable, JTextField value_how_long_to_go_bad, JCheckBox value_transportable){
        String item_name             = value_item.getText();

        double item_storage_space    = Double.parseDouble(value_storage.getText());
        double item_weight           = Double.parseDouble(value_weight.getText());
        Double how_long_to_go_bad    = null;

        boolean item_isDurable       = value_durable.isSelected();
        boolean item_isStorable      = value_storable.isSelected();
        boolean item_isTransportable = value_transportable.isSelected();

        if(!item_isStorable){how_long_to_go_bad = Double.valueOf(value_how_long_to_go_bad.getText());}

        JOptionPane.showMessageDialog(frame,
                "Name: " + item_name + "\n-Weights: " + item_weight
                + "\n-Is durable: " + item_isDurable,
                "User Response",
                JOptionPane.INFORMATION_MESSAGE);


        // CREATE ITEM OBJECT AND ADD IT TO THIS.ITEMLIST
        Item item = new Item(item_name, item_storage_space, item_weight, 
            how_long_to_go_bad, item_isDurable, item_isStorable, item_isTransportable);

        // VERIFY IF DOESNT EXIST YET BEFORE ADDING
        String[] current_item_names = ITEMLIST.getItemListNames(); // USELESS
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
            

        System.out.println("Item:" + item);

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


    public static void EditItem() {
        // OPEN DIALOG TO SELECT THE THING TO EDIT

        // GET ITEM OPTIONS
        String[] ItemOptionsList = ITEMLIST.getItemListNames();
        System.out.println("[Printing available items]");
        

        // create a dialog Box
        JDialog d_editItem = new JDialog(frame, "Edit item");
        d_editItem.setBackground(Color.decode("#1e1e1e"));
        
        d_editItem.setSize(200, 200);
        d_editItem.setLayout(new BorderLayout());
        
        // Create a panel to hold the form components
        JPanel formPanel = new JPanel();
        

        // DROPDOWN WITH THE OPTIONS
        JComboBox item_drop_List = new JComboBox(ItemOptionsList);
        item_drop_List.setSelectedIndex(0);
        //petList.addActionListener(AppInterface); // MIGHT DAR BARRACA
        formPanel.add(item_drop_List);


        // BUTTON TO CHOSE ITEM TO EDIT
        JButton Confirm_Button = new JButton("Confirm");
        //OnClickEventHelper.setOnClickColor(SaveItems_Button, Color.decode("#232323"), Color.decode("#2e2e2e"));
        System.out.println("[editing item #]: " + (String) item_drop_List.getSelectedItem() );
        Confirm_Button.addActionListener(e -> d_editItem.dispose());
        Confirm_Button.addActionListener(e -> NewItem_form2((String) item_drop_List.getSelectedItem()));
        formPanel.add(Confirm_Button);

        // FINALE
        formPanel.setBackground(Color.decode("#555555"));

        d_editItem.add(formPanel, BorderLayout.CENTER);

        d_editItem.getContentPane().setBackground(Color.decode("#303030"));

        d_editItem.setLocationRelativeTo(null);

        // set visibility of dialog
        d_editItem.setVisible(true);
    }



    public static void LoadSavedData(String DATAFOLDER){
        ITEMLIST = ITEMLIST.LoadFromFile(DATAFOLDER + "/itemlist.json");
    }



    
    
    public static void main(String[] args) {

        frame = new JFrame("My Awesome Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(1000, 600);
        frame.setSize(600, 400);
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#1e1e1e"));
        //panel.setLayout(null);


        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        //GridBagLayout gbc = new GridBagLayout();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.BOTH;
        //gbc.gridwidth  = 2;
        //gbc.gridheight = 8;
        //gbc.insets = new Insets(5, 5, 5, 5); // original
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.ipadx = 20;
        gbc.ipady = 20;

        
        // BUTTON TO ADD ITEM
        gbc.gridx = 0; gbc.gridy = 1;
        //gbc.weightx = 0.3; // TESTE
        JButton AddItem_Button = new JButton("Add Item");
        //AddItem_Button.setBounds(40, 40, 150, 43);
        AddItem_Button.setBackground(Color.decode("#2e2e2e"));
        AddItem_Button.setForeground(Color.decode("#D9D9D9"));
        AddItem_Button.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
        AddItem_Button.setBorder(new RoundedBorder(6, Color.decode("#979797"), 1));
        AddItem_Button.setFocusPainted(false);
        OnClickEventHelper.setOnClickColor(AddItem_Button, Color.decode("#232323"), Color.decode("#2e2e2e"));
        AddItem_Button.addActionListener(e -> NewItem_form2(""));
        panel.add(AddItem_Button, gbc);
        

        // BUTTON TO EDIT ITEM
        gbc.gridx = 1; gbc.gridy = 1;
        JButton EditItem_Button = new JButton("Edit Item");
        //AddItem_Button.setBounds(40, 40, 150, 43);
        EditItem_Button.setBackground(Color.decode("#2e2e2e"));
        EditItem_Button.setForeground(Color.decode("#D9D9D9"));
        EditItem_Button.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
        EditItem_Button.setBorder(new RoundedBorder(6, Color.decode("#979797"), 1));
        EditItem_Button.setFocusPainted(false);
        OnClickEventHelper.setOnClickColor(EditItem_Button, Color.decode("#232323"), Color.decode("#2e2e2e"));
        EditItem_Button.addActionListener(e -> EditItem());
        panel.add(EditItem_Button, gbc);

        
        // BUTTON TO SAVE ITEMSLIST
        gbc.gridx = 2; gbc.gridy = 1;
        JButton SaveItems_Button = new JButton("Save Items");
        //AddBuilding_Button.setBounds(40, 120, 150, 43);
        SaveItems_Button.setBackground(Color.decode("#2e2e2e"));
        SaveItems_Button.setForeground(Color.decode("#D9D9D9"));
        SaveItems_Button.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
        SaveItems_Button.setBorder(new RoundedBorder(6, Color.decode("#979797"), 1));
        SaveItems_Button.setFocusPainted(false);
        //OnClickEventHelper.setOnClickColor(SaveItems_Button, Color.decode("#232323"), Color.decode("#2e2e2e"));
        SaveItems_Button.addActionListener(e -> ITEMLIST.SaveItems("SavedData/itemlist.json"));
        panel.add(SaveItems_Button, gbc);


        // BUTTON TO ADD BUILDING
        gbc.gridx = 0; gbc.gridy = 2;
        JButton AddBuilding_Button = new JButton("Add Building");
        //AddBuilding_Button.setBounds(40, 120, 150, 43);
        AddBuilding_Button.setBackground(Color.decode("#2e2e2e"));
        AddBuilding_Button.setForeground(Color.decode("#D9D9D9"));
        AddBuilding_Button.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
        AddBuilding_Button.setBorder(new RoundedBorder(6, Color.decode("#979797"), 1));
        AddBuilding_Button.setFocusPainted(false);
        OnClickEventHelper.setOnClickColor(AddBuilding_Button, Color.decode("#232323"), Color.decode("#2e2e2e"));
        panel.add(AddBuilding_Button, gbc);
        

        // BUTTON TO LOAD ITEMSLIST AND ALL THINGS LIST
        gbc.gridwidth = 3;
        gbc.gridx = 0; gbc.gridy = 0;
        JButton LoadItems_Button = new JButton("Load Data");
        //AddBuilding_Button.setBounds(40, 120, 150, 43);
        LoadItems_Button.setBackground(Color.decode("#2e2e2e"));
        LoadItems_Button.setForeground(Color.decode("#D9D9D9"));
        LoadItems_Button.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
        LoadItems_Button.setBorder(new RoundedBorder(6, Color.decode("#979797"), 1));
        LoadItems_Button.setFocusPainted(false);
        LoadItems_Button.addActionListener(e -> LoadSavedData("SavedData"));
        panel.add(LoadItems_Button, gbc);




        // CONCLUSIONS 
        frame.add(panel);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }
}
