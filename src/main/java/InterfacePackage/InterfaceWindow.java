package InterfacePackage;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import helper_classes.CustomFontLoader;
import helper_classes.RoundedBorder;


// HOW TO USE:
// 1 - CALL CONSTRUCTOR
// 2 - SET PARAMETERS
// 3 - CALL REGENERATE main components 
public class InterfaceWindow {

    private GridBagConstraints gbc;
    // DEFINITIONS
    private int default_anchor = GridBagConstraints.CENTER;
    private int default_fill   = GridBagConstraints.BOTH;

    private JFrame main_frame;
    private JPanel main_pane;
    private JPanel main_panel;
    private boolean packQ = true;

    // margin properties
    private int hMargin = 10;
    private int vMargin = 10;

    public InterfaceWindow(String windowname, Color bgColor){
        this.gbc = new GridBagConstraints();
        this.gbc.anchor = default_anchor;

        AddMainComponents(windowname, bgColor);
    }

    /*
    public InterfaceWindow(String windowname, Color bgColor, int insets_hGap, int insets_vGap){
        this.gbc = new GridBagConstraints();
        this.gbc.anchor = default_anchor;
        setInsets(insets_hGap, insets_vGap);

        AddMainComponents(windowname, bgColor);
    }
    */

    public InterfaceWindow(String windowname, Color bgColor, int hMargin, int vMargin){
        this.gbc = new GridBagConstraints();
        this.gbc.anchor = default_anchor;
        setMargin(hMargin, vMargin);

        AddMainComponents(windowname, bgColor);
    }

    public final void AddMainComponents(String windowname, Color bgColor){
        // frame -> pane -> panel
        this.main_frame = new JFrame(windowname);
        this.main_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.main_pane = this.getPanel(bgColor);
        //main_pane.setLayout( new FlowLayout(FlowLayout.CENTER, 10, 10) );
        main_pane.setLayout( new GridBagLayout() );
        GridBagConstraints gbc__ = new GridBagConstraints();
        gbc__.insets = new Insets(vMargin, hMargin, vMargin, hMargin); // GLOBAL MARGINS
        gbc__.fill = GridBagConstraints.BOTH;
        //gbc__.ipadx = 20;
        //gbc__.ipady = 20;

        this.main_panel = this.getPanel(bgColor);
        main_panel.setLayout( new GridBagLayout() );
        //main_panel.setBorder(BorderFactory.createLineBorder(Color.black));
        main_pane.add(main_panel, gbc__);

        //main_frame.add(main_pane);

        main_frame.setContentPane(main_pane);
    }


    // SET WINDOW PARAMETERS
    // SET WINDOW SIZE
    public final void setSize(int width, int height){
        main_frame.setSize(width, height);
        packQ = false;
    }

    // SET INSETS
    public final void setInsets(int hGap, int vGap){
        //this.gbc.insets = new Insets( hGap, vGap, hGap, vGap);
        this.gbc.insets = new Insets( vGap, hGap, vGap, hGap);
    }
    private final void setInsetsSingle(int hGap, int vGap){
        //this.gbc.insets = new Insets( hGap, vGap, hGap, vGap);
        this.gbc.insets = new Insets( vGap, hGap, 0, 0);
    }

    // SET PADDING //???INGORADO COM O PACK
    public final void setPadding(int ipadx, int ipady){
        this.gbc.ipadx = ipadx;
        this.gbc.ipady = ipady;
    }

    // ABSOLUTE MARGIN ALL AROUND
    private final void setMargin(int hMargin, int vMargin){
        this.hMargin = hMargin;
        this.vMargin = vMargin;
    }



    // GET FRAME ITSELF
    public JFrame getThisFrame(){
        return this.main_frame;
    }


    // OBTAIN COMPONENTS
    public JPanel getPanel( Color bgColor ){
        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(bgColor);
        return panel;
    }
    
    public JPanel getPanelGBC( Color bgColor ){
        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(bgColor);
        panel.setLayout( new GridBagLayout() ); //this extra line
        return panel;
    }


    // BG Color.decode("#2e2e2e") | Color.decode("#D9D9D9") | FG FONTSIZE 14 | BORDER 6
    public JButton getButton(String text, Color bgColor, Color fgColor, int fontsize, int borderradius){
        JButton button = new JButton(text);
        button.setBackground(bgColor); // Color.decode("#2e2e2e")
        button.setForeground(fgColor); // Color.decode("#D9D9D9")
        button.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", fontsize));
        button.setBorder(new RoundedBorder(borderradius, Color.decode("#979797"), 1));
        button.setFocusPainted(false); //?????

        return button;
    }


    public JLabel getLabel(String text, Color fgColor, int fontsize){
        JLabel label = new JLabel("How long to go bad");
        label.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", fontsize));
        label.setForeground(fgColor);

        return label;
    }





    // ADD COMPONENTS TO THE MAIN PANEL. JUST USE THIS
    public void addCompToMainPanel(JComponent comp, int x, int y, int width, int height, int fill, double weightx, double weighty){
        
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth  = width;
        gbc.gridheight = height;
        gbc.fill = default_fill; //IGNORE fill 
        gbc.weightx = weightx;
        gbc.weighty = weighty;

        main_panel.add(comp, gbc);
    }




    // ADD COMPONENTS TO THE ADEQUATE PANEL
    public void addCompSpecial(JComponent comp, JPanel panel, int x, int y, int width, int height, int fill, double weightx, double weighty, int ipadx, int ipady, int insetx, int insety){
        GridBagConstraints specialGBC = new GridBagConstraints();

        specialGBC.gridx = x;
        specialGBC.gridy = y;
        specialGBC.gridwidth  = width;
        specialGBC.gridheight = height;
        specialGBC.fill = fill;
        specialGBC.weightx = weightx;
        specialGBC.weighty = weighty;
        specialGBC.ipadx = ipadx;
        specialGBC.ipady = ipady;
        specialGBC.insets = new Insets( insety, insetx, insety, insetx);

        panel.add(comp, specialGBC);
    }


    // ADD COMPONENTS TO THE ADEQUATE PANEL
    public void addComp(JComponent comp, JPanel panel, int x, int y, int width, int height, int fill, double weightx, double weighty){
        
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth  = width;
        gbc.gridheight = height;
        gbc.fill = fill;
        gbc.weightx = weightx;
        gbc.weighty = weighty;

        panel.add(comp, gbc);
    }




    public void displayWindow(){
        main_frame.setContentPane(this.main_pane);
        
        if (packQ) { main_frame.pack (); }
        //main_frame.pack (); // sempre
        main_frame.setLocationByPlatform ( true );
        
        main_frame.setLocationRelativeTo(null); // mine
        main_frame.setVisible ( true );
    }

}
