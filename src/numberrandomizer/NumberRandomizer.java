package numberrandomizer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//@author: Celena Williams
//Last edited: February 22, 2017

//Code may be kept and modified, so long as my name stays the creator.
//Parts of code may be used without documentation if code is understood.

public class NumberRandomizer extends JFrame implements ActionListener {
    JLabel minLabel, maxLabel;
    JButton randomizeButton;
    JTextField minField, maxField;
    JPanel northPanel, centerPanel;
    
    int min, max, random;
    
    public static void main (String [] args) {
        NumberRandomizer application = new NumberRandomizer ();
        application.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }//END public static void main (String [] args)
    
    //Creates and adds the content to the window.
    public NumberRandomizer () {
        northPanel = new JPanel ();
        centerPanel = new JPanel ();
        
        setLayout (new BorderLayout ());
        northPanel.setLayout (new FlowLayout ());
        centerPanel.setLayout (new FlowLayout ());
        
        minLabel = new JLabel ("Min");
        maxLabel = new JLabel ("Max");
        
        minField = new JTextField (3);
        maxField = new JTextField (3);
        
        randomizeButton = new JButton ("Randomize");
        randomizeButton.addActionListener (this);
        
        add (northPanel, BorderLayout.NORTH);
        add (centerPanel, BorderLayout.CENTER);
        
        northPanel.add (minLabel);
        northPanel.add (minField);
        northPanel.add (maxLabel);
        northPanel.add (maxField);
        centerPanel.add (randomizeButton);
        
        setSize (300, 300);
        setVisible (true);
    }//END public NumberRandomizer ()

    @Override
    public void actionPerformed (ActionEvent e) {
        min = Integer.parseInt (minField.getText ());
        max = Integer.parseInt (maxField.getText ());
        
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
            
            minField.setText (min + "");
            maxField.setText (max + "");
            
            JOptionPane.showMessageDialog (null, "ERROR! Your values were " + 
                                 "inverted. They have been properly switched.");
        }//END if (min > max)
        
        random = (int)(Math.random() * ((max + 1) - min) + min);
        
        JOptionPane.showMessageDialog (null, random);
    }//END public void actionPerformed (ActionEvent e)
}//END public class NumberRandomizer