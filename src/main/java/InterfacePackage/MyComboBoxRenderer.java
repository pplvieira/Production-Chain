package InterfacePackage;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;



@SuppressWarnings({ "unchecked", "rawtypes" })
public class MyComboBoxRenderer extends AbstractListModel
    implements ComboBoxModel {
    public static Object NONE = "none"; 
    List values = new ArrayList();
    List selected = new ArrayList();

    /*
    public MyComboBoxRenderer(Object... values) {
        System.out.println("==[CORREU ESTE]");
        for (Object object : values) {
            this.values.add(object);
        }
    }
    */

    public MyComboBoxRenderer(String[] options){
        this.values.add(MyComboBoxRenderer.NONE);
        this.values.addAll(Arrays.asList(options));
    }

    @Override
    public int getSize() {
        return values.size();
    }

    @Override
    public Object getElementAt(int index) {
        return values.get(index);
    }
    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem == null || anItem == NONE) {
            if (selected.isEmpty()) return;
            selected.clear();
        } else {
            boolean removed = selected.remove(anItem);
            if (!removed) {
                selected.add(anItem);
            }
        }
        fireContentsChanged(this, -1, -1);
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }


    public static void main(String[] args) {
        // use


        InterfaceWindow window1 = new InterfaceWindow("Main window", Color.WHITE, 15, 15);
        window1.setPadding(35, 20); 
        //window1.setSize(450, 300);
        //window1.setSize(550, 400); // prolly ignorado depende do estado do pack
        window1.setInsets(15, 10); //spacing between objects
        //window1.setMargin(15, 15); // margin to the edges of the window

        
        String[] options = {"a", "the", "other"};
        MyComboBoxRenderer model = new MyComboBoxRenderer(options);
        model.setSelectedItem(null);
        JComboBox box = new JComboBox(model);
        window1.addCompToMainPanel(box, 0, 0, 4, 1, GridBagConstraints.HORIZONTAL, 1, 2);
    

        window1.displayWindow();
    }

}
