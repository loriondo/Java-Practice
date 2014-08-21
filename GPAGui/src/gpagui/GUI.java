/*
 */

package gpagui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.text.NumberFormat;

import java.util.ArrayList;
import javafx.scene.text.TextAlignment;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.MaskFormatter;

/**
 * Short and simple Java application using Swing for
 * experimentation and other goodies.
 * @author Lou
 */
public class GUI implements ActionListener {
    
    static JLabel headerText;   
  
    private static double tempGpa = 3.75;
    private static JFormattedTextField gpaField;
    private static JFormattedTextField hourField;
    private static double calculatedGpa = 0;
    private static JButton computeGpa;
    
    /**
     * Creates and populates top level frame with various goodies.
     */
    public static void displayGUI(){
        JFrame frame = new JFrame("GPA Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setPreferredSize(new Dimension(200,20));
        
        headerText = new JLabel("Input GPA to get started.");
        headerText.setHorizontalAlignment(JLabel.CENTER);
        headerText.setVerticalAlignment(JLabel.CENTER);
        
        JPanel rightPane = new JPanel();
            rightPane.setPreferredSize(new Dimension(200,200));
        JPanel leftPane = new JPanel();
            leftPane.setPreferredSize(new Dimension(200,200));
        computeGpa = new JButton("Calculate GPA");
        computeGpa.addActionListener(null);
        
        gpaField = new JFormattedTextField(createGPAFormatter("#.##"));
        hourField = new JFormattedTextField(createHourFormatter("#"));
        
        //gpaField.setValue(tempGpa);
        gpaField.setColumns(4);
        hourField.setColumns(1);
        leftPane.add(gpaField, BoxLayout.Y_AXIS);
        leftPane.add(hourField, BoxLayout.Y_AXIS);
        
        JLabel displayGpa = new JLabel((String.valueOf(calculatedGpa)));
        rightPane.add(displayGpa, BorderLayout.CENTER);
        
        frame.add(rightPane, BorderLayout.LINE_END);
        frame.add(leftPane, BorderLayout.LINE_START);
        frame.add(headerText, BorderLayout.PAGE_END);
        frame.add(menuBar, BorderLayout.PAGE_START);
        
        frame.pack();
        frame.setVisible(true);
        
        
    }
    
    /**
     * Creates MaskFormatter to ensure formatted text field 
     * keeps entries in GPA format. 
     * i.e. 3.75 
     * @param s - desired format, in this context #.##
     * @return formatter - successfully created format
     */
    static protected MaskFormatter createGPAFormatter(String s){
       MaskFormatter formatter = null;
       try{
           formatter = new MaskFormatter(s);
       }catch(java.text.ParseException e){
           System.err.println("formatter is bad: " + e.getMessage());
           System.exit(-1);
       }
       return formatter;
    }
    
    /**
     * Same as above method, but now restricting entry to a single
     * integer. 
     * i.e. CSCI 4760 is a 4 HOUR course
     * @param s - desired format, in this function just #
     * @return - successfully created format
     */
    static protected MaskFormatter createHourFormatter(String s){
        MaskFormatter formatter = null;
        try{
            formatter = new MaskFormatter(s);
        }catch(java.text.ParseException e){
            System.err.println("formatter is bad: " + e.getMessage());
            System.exit(-1);
        }
        return formatter;
    }
    
    /**
     * In Progress
     * @param e 
     */
    public void propertyChange(PropertyChangeEvent e){
        
    }
    
    /**
     * In Progress
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
}

