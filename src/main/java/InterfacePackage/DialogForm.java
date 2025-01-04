package InterfacePackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import helper_classes.CustomFontLoader;
import helper_classes.OnFocusEventHelper;

public class DialogForm {

    public JDialog dialog;
    public JPanel formPanel;
    public JButton submitButton;

    int CurrLine = 0;

    GridBagConstraints gbc;
    GridBagConstraints frame_gbc;

    Color bgColor;
    Color fgColor;
    Color lighterColor;
    Color veryLightColor;

    ArrayList<JComponent> componentFieldList;



    // DEFINITIONS
    int inset_val = 4;
    int default_fontsize = 12;



    public DialogForm(JFrame frame, String windowName, Color bgColor, Color fgColor, Color lighterColor, Color veryLightColor){
        this.bgColor = bgColor;
        this.fgColor = fgColor;
        this.lighterColor = lighterColor;
        this.veryLightColor = veryLightColor;

        this.dialog = new JDialog(frame, windowName);
        dialog.setBackground(bgColor);
        
        dialog.setSize(350, 400); // ignorado
        //dialog.setLayout(new BorderLayout());
        dialog.setLayout( new GridBagLayout() );
        frame_gbc = new GridBagConstraints();
        frame_gbc.insets = new Insets(20, 20, 20, 20); // GLOBAL MARGINS
        frame_gbc.fill = GridBagConstraints.BOTH;
        
        // Create a panel to hold the form components
        formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();
        this.gbc.insets = new Insets(inset_val, inset_val, inset_val, inset_val);
        this.gbc.ipadx  = 5; // WAS 10
        this.gbc.ipady  = 1; // WAS 5
        this.gbc.fill   = GridBagConstraints.BOTH; //HORIZONTAL;
        this.gbc.anchor = GridBagConstraints.CENTER;
        this.gbc.gridwidth  = 1;
        this.gbc.gridheight = 1;
        this.gbc.weightx    = 1;
        this.gbc.weighty    = 1;

        // keep record of the components
        componentFieldList = new ArrayList<>();

    }


    // fieldname is the question being asked
    public void addTextOptionWithDefault(String fieldname, String DefaultValue){
        gbc.gridx = 0; gbc.gridy = CurrLine;
        JLabel label_name = new JLabel(fieldname);
        label_name.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", default_fontsize));
        label_name.setForeground(fgColor);
        formPanel.add(label_name, gbc);
        
        gbc.gridx = 1;
        JTextField text_field = new JTextField(DefaultValue);
        text_field.setText(DefaultValue);
        text_field.setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 2));
        text_field.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", default_fontsize));
        text_field.setBackground(veryLightColor);
        text_field.setForeground(Color.BLACK); //cor do texto default = ao background
        //text_field.setBorder(new RoundedBorder(4, Color.decode("#979797"), 0)); //???????
        //OnFocusEventHelper.setOnFocusText(text_field, DefaultValue, Color.BLACK, Color.BLACK); //;
        
        formPanel.add(text_field, gbc);
        componentFieldList.add(text_field);
        CurrLine++;
    }

    
    // fieldname is the question being asked
    public void addTextOption(String fieldname){
        gbc.gridx = 0; gbc.gridy = CurrLine;
        JLabel label_name = new JLabel(fieldname);
        label_name.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", default_fontsize));
        label_name.setForeground(fgColor);
        formPanel.add(label_name, gbc);
        
        gbc.gridx = 1;
        JTextField text_field = new JTextField("Input");
        text_field.setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 2));
        text_field.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", default_fontsize));
        text_field.setBackground(veryLightColor);
        text_field.setForeground(bgColor); //cor do texto default = ao background
        text_field.setMinimumSize(new Dimension(70,15)); // ADDED
        OnFocusEventHelper.setOnFocusText(text_field, "Input", bgColor, bgColor); //;
        
        formPanel.add(text_field, gbc);
        componentFieldList.add(text_field);
        CurrLine++;
    }
    

    // fieldname is the question being asked
    public void addCheckOption(String fieldname, boolean selected){
        gbc.gridx = 0; gbc.gridy = CurrLine;
        JLabel label_name = new JLabel(fieldname);
        label_name.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", default_fontsize));
        label_name.setForeground(fgColor);
        formPanel.add(label_name, gbc);
        
        gbc.gridx = 1;
        JCheckBox value_box = new JCheckBox(fieldname);
        value_box.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", default_fontsize));
        value_box.setBackground(veryLightColor);
        value_box.setBorder(BorderFactory.createEmptyBorder(2, 8, 2, 2));
    
        value_box.setSelected(selected);
        formPanel.add(value_box, gbc);
        componentFieldList.add(value_box);
        CurrLine++;
    }
    

    // fieldname is the question being asked
    public void addDropdownField(String fieldname, String[] options, int selected_i){
        gbc.gridx = 0; gbc.gridy = CurrLine;
        JLabel label_name = new JLabel(fieldname);
        label_name.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", default_fontsize));
        label_name.setForeground(fgColor);
        formPanel.add(label_name, gbc);
        
        gbc.gridx = 1;
        JComboBox combo_box = new JComboBox(options);
        if(options.length > 0){ combo_box.setSelectedIndex(selected_i); }
        combo_box.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", default_fontsize));
        combo_box.setBackground(veryLightColor);
        combo_box.setForeground(bgColor);
        combo_box.setBorder(BorderFactory.createEmptyBorder(2, 8, 2, 2));
    
        formPanel.add(combo_box, gbc);
        componentFieldList.add(combo_box);
        CurrLine++;
    }



    public void addMultiselectCombobox(String fieldname, String[] options){
        gbc.gridx = 0; gbc.gridy = CurrLine;
        JLabel label_name = new JLabel(fieldname);
        label_name.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", default_fontsize));
        label_name.setForeground(fgColor);
        formPanel.add(label_name, gbc);
        
        gbc.gridx = 1;
        MyComboBoxRenderer model = new MyComboBoxRenderer(options);
        model.setSelectedItem(null);
        JComboBox multicombobox = new JComboBox(model);

        //if(options.length > 0){ multicombobox.setSelectedIndex(selected_i); }
        multicombobox.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", default_fontsize));
        multicombobox.setBackground(veryLightColor);
        multicombobox.setForeground(bgColor);
        multicombobox.setBorder(BorderFactory.createEmptyBorder(2, 8, 2, 2));
    
        formPanel.add(multicombobox, gbc);
        componentFieldList.add(multicombobox);
        CurrLine++;
    }


    public void addMultiselectComboboxDefault(String fieldname, String[] options, ArrayList<String> selected){
        gbc.gridx = 0; gbc.gridy = CurrLine;
        JLabel label_name = new JLabel(fieldname);
        label_name.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", default_fontsize));
        label_name.setForeground(fgColor);
        formPanel.add(label_name, gbc);
        
        gbc.gridx = 1;
        MyComboBoxRenderer model = new MyComboBoxRenderer(options);
        for (int i = 0; i < selected.size(); i++) {
            model.setSelectedItem(selected.get(i));
        }
        JComboBox multicombobox = new JComboBox(model);

        //if(options.length > 0){ multicombobox.setSelectedIndex(selected_i); }
        multicombobox.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", default_fontsize));
        multicombobox.setBackground(veryLightColor);
        multicombobox.setForeground(bgColor);
        multicombobox.setBorder(BorderFactory.createEmptyBorder(2, 8, 2, 2));
    
        formPanel.add(multicombobox, gbc);
        componentFieldList.add(multicombobox);
        CurrLine++;
    }




    public void setVisible(){
        
        // Add Submit Button
        gbc.gridx = 0;
        gbc.gridy = CurrLine;
        gbc.gridwidth = 2;
        submitButton = new JButton("Submit");
        formPanel.add(submitButton, gbc);

        submitButton.addActionListener(e -> dialog.dispose());
        //submitButton.addActionListener(e -> readNewItemForm(value_item, value_storage, 
        //    value_weight, value_durable, value_storable, value_how_long_to_go_bad, value_transportable)); // on click



        //formPanel.setBackground(Color.decode("#353535"));
        formPanel.setBackground(bgColor);


        dialog.add(formPanel, frame_gbc);

        dialog.getContentPane().setBackground(Color.decode("#303030"));

        dialog.setLocationRelativeTo(null);

        //value_storage.requestFocus();
        //value_storage.requestFocusInWindow();
        //value_storage.grabFocus();


        // set visibility of dialog

        
        dialog.pack();

        dialog.setVisible(true);

    }


    public ArrayList<JComponent> getComponentFieldList(){
        return componentFieldList;
    }


    // READ ENTRIES OF THE FORM
    public String parseStringField(int fieldIndex){
        String value = ((JTextField) this.componentFieldList.get(fieldIndex)).getText();
        return value;
    }

    public double parseDoubleField(int fieldIndex){
        double value = Double.parseDouble(((JTextField) this.componentFieldList.get(fieldIndex)).getText());
        return value;
    }

    public int parseIntField(int fieldIndex){
        int value = Integer.parseInt(((JTextField) this.componentFieldList.get(fieldIndex)).getText());
        return value;
    }

    public boolean parseCheckbox(int fieldIndex){
        boolean value = ((JCheckBox) this.componentFieldList.get(fieldIndex)).isSelected();
        return value;
    }

    public String parseDropdownField(int fieldIndex){
        String value = ((JComboBox) this.componentFieldList.get(fieldIndex)).getSelectedItem().toString();
        return value;
    }

    public ArrayList<String> parseMultiselectCombobox(int fieldIndex){
        //ArrayList<String> value = ( (Component) this.componentFieldList.get(fieldIndex)).selected();
        //ArrayList<String> value = ( (JComboBox) this.componentFieldList.get(fieldIndex)).getModel().getSelectedItem();
        ArrayList<String> selected = (ArrayList<String>) ( (JComboBox) this.componentFieldList.get(fieldIndex)).getModel().getSelectedItem();
        return selected;
    }



}
