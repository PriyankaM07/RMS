/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 update git
 */
package RMS;

import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import java.util.*;
import java.text.*;

/**
 *
 * @author Kalaadhar
 */
public class MenuGUI extends JPanel{
    int sizeX = 600;
    int sizeY = 750;
    
    String drinks[] = {};
    String starters[] = {};
    String mainCourse[] = {};
    String deserts[] = {};
    
    JRadioButton drinksButton[] = new JRadioButton[drinks.length];
    JRadioButton startersButton[] = new JRadioButton[starters.length];
    JRadioButton mainCourseButton[] = new JRadioButton[mainCourse.length];
    JRadioButton desertsButton[] = new JRadioButton[deserts.length];
    
    ButtonGroup drG = new ButtonGroup();
    ButtonGroup sG = new ButtonGroup();
    ButtonGroup mG = new ButtonGroup();
    ButtonGroup deG = new ButtonGroup();
    
    String stringNoOfPeople;
    int noOfPeople;
    int count=0;
    double billTotal;
    JTextArea output;
    JTextField nameField;
    
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    static ArrayList<String> submitForm = new ArrayList();
    Border black;
    
    
    MenuGUI(){
        super();
       // setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       // setPreferredSize(new Dimension(sizeX, sizeY));
        
        //Container content = getContentPane();
        JPanel content = new JPanel();
        JPanel innerContent = new JPanel();
        JPanel drinkButtonContent = new JPanel();
        JPanel startersButtonContent = new JPanel();
        JPanel mainCourseButtonContent = new JPanel();
        JPanel desertsButtonContent = new JPanel();
        
        JButton ok = new JButton("OK");
        JLabel title = new JLabel("Restaurent Order Application", JLabel.CENTER);
        
        nameField = new JTextField(10);
        output = new JTextArea("Restaurent\n",28,40);
        black = BorderFactory.createLineBorder(Color.BLACK);
        
        drinkButtonContent.add(new JLabel("Select Your Beverage"));
        startersButtonContent.add(new JLabel("Select Your Starters"));
        mainCourseButtonContent.add(new JLabel("Select Your MainCourse"));
        desertsButtonContent.add(new JLabel("Select Your Desert"));
        
        for(int i=0; i<drinks.length; i++){
            drinksButton[i] = new JRadioButton(drinks[i]);
            startersButton[i] = new JRadioButton(starters[i]);
            mainCourseButton[i] = new JRadioButton(mainCourse[i]);
            desertsButton[i] = new JRadioButton(deserts[i]);
            
            drG.add(drinksButton[i]);
            sG.add(startersButton[i]);
            mG.add(mainCourseButton[i]);
            deG.add(desertsButton[i]);
            
            drinksButton[i].getModel().setActionCommand(drinks[i]);
            startersButton[i].getModel().setActionCommand(starters[i]);
            mainCourseButton[i].getModel().setActionCommand(mainCourse[i]);
            desertsButton[i].getModel().setActionCommand(deserts[i]);
            
            drinkButtonContent.add(drinksButton[i], BorderLayout.CENTER);
            startersButtonContent.add(startersButton[i], BorderLayout.CENTER);
            mainCourseButtonContent.add(mainCourseButton[i], BorderLayout.CENTER);
            desertsButtonContent.add(desertsButton[i], BorderLayout.CENTER);
            
            content.add(title, BorderLayout.NORTH);
            innerContent.add(new JLabel("Name : "));
            innerContent.add(nameField, BorderLayout.NORTH);
            
            innerContent.add(drinkButtonContent, BorderLayout.CENTER);
            innerContent.add(startersButtonContent, BorderLayout.CENTER);
            innerContent.add(mainCourseButtonContent, BorderLayout.CENTER);
            innerContent.add(desertsButtonContent, BorderLayout.CENTER);
            
            output.setBorder(black);
            output.setEditable(false);
            JScrollPane outPane = new JScrollPane(output);
            innerContent.add(outPane, BorderLayout.SOUTH);
            content.add(innerContent, BorderLayout.CENTER);
            content.add(ok, BorderLayout.SOUTH);
            ok.addActionListener(new MenuGUI.OKButton());
            
           // setLocationRelativeTo(null);
           // setVisible(true);
            numPeople();
            print();
        }
    }
    
    private void numPeople(){
        boolean badInput = true;
        
        while(badInput){
            stringNoOfPeople = JOptionPane.showInputDialog(this, "How Many People are we serving today?");
            try{
                noOfPeople = Integer.parseInt(stringNoOfPeople);
                
                if(noOfPeople > 12)
                    throw new Exception();
                if(noOfPeople == 0)
                    throw new NumberFormatException();
                
                badInput = false;
            }
            catch(NumberFormatException e){
                //JOptionPane.showMessageDialog("Please Enter No Of Persons >= 1");
                
            }
            catch(Exception e){
                //JOptionPane.showMessageDialog(this, "Tables can hold a amaximum of 12 persons");
               // printStackTrace(e);
            }
        }
    }
    
    public void updateText(String s){
        output.append(s+"\n");
    }
    
    private void print(){
        updateText("***********");
        updateText("EveryOne has Ordered\nYour Bill be Calculated");
        updateText("***********");
    }
    
    private class OKButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(count <= noOfPeople){
                try{
                    String nameText = nameField.getText();
                    String drC = drG.getSelection().getActionCommand();
                    String sC = sG.getSelection().getActionCommand();
                    String mC = mG.getSelection().getActionCommand();
                    String deC = deG.getSelection().getActionCommand();
                    
                    calculateBill(drC, sC, mC, deC);
                    updateText("Thanks For Ordering!");
                    
                    if(drC.equals(drinks[0])){
                        updateText(drinks[0]);
                        submitForm.add(drinks[0]);
                    }
                    else if(drC.equals(drinks[1])){
                        updateText(drinks[1]);
                        submitForm.add(drinks[1]);
                    }
                    else if(drC.equals(drinks[2])){
                        updateText(drinks[2]);
                        submitForm.add(drinks[2]);
                    }
                    else{
                        updateText("You Selected No Drink!");
                    }
                    
                    
                    if(sC.equals(starters[0])){
                        updateText(starters[0]);
                        submitForm.add(starters[0]);
                    }
                    else if(sC.equals(starters[1])){
                        updateText(starters[1]);
                        submitForm.add(starters[1]);
                    }
                    else if(sC.equals(starters[2])){
                        updateText(starters[2]);
                        submitForm.add(starters[2]);
                    }
                    else{
                        updateText("You Selected No Starter!");
                    }
                    
                    
                    if(mC.equals(mainCourse[0])){
                        updateText(mainCourse[0]);
                        submitForm.add(mainCourse[0]);
                    }
                    else if(mC.equals(mainCourse[1])){
                        updateText(mainCourse[1]);
                        submitForm.add(mainCourse[1]);
                    }
                    else if(mC.equals(mainCourse[2])){
                        updateText(mainCourse[2]);
                        submitForm.add(mainCourse[2]);
                    }
                    else{
                        updateText("You Selected No Main Course!");
                    }
                    
                    
                    if(deC.equals(deserts[0])){
                        updateText(deserts[0]);
                        submitForm.add(deserts[0]);
                    }
                    else if(deC.equals(deserts[1])){
                        updateText(deserts[1]);
                        submitForm.add(deserts[1]);
                    }
                    else if(deC.equals(deserts[2])){
                        updateText(deserts[2]);
                        submitForm.add(deserts[2]);
                    }
                    else{
                        updateText("You Selected No Desert!");
                    }
                    
                    nameField.setText(null);
                    drG.clearSelection();
                    sG.clearSelection();
                    mG.clearSelection();
                    deG.clearSelection();
                    count++;
                    
                    if(count >= noOfPeople){
                        updateText("*******");
                        updateText("Total : "+currencyFormatter.format(billTotal));
                        updateText("Please Press X to exit");
                        updateText("*******");
                        submitForm.add("Total : "+currencyFormatter.format(billTotal));
                    }
                }
                catch(NullPointerException n){
                    printErrorIncompleteMenu();
                }
            }    
        }
    }
    
    public void printErrorIncompleteMenu(){
        if(count >= noOfPeople)
            updateText("Press X to Close");
        //else
          //  JOptionPane.showMessageDialog(this, "Please Completely Fill in The Order!");
    }
    
    public void calculateBill(String dr, String s, String m, String de){
        if(dr.equals(drinks[0]))
            billTotal += 160;
        else if(dr.equals(drinks[1]))
            billTotal += 100;
        else if(dr.equals(drinks[2]))
            billTotal += 100;
        
        
        if(s.equals(starters[0]))
            billTotal += 650;
        else if(s.equals(starters[1]))
            billTotal += 475;
        else if(s.equals(starters[2]))
            billTotal += 550;
        
        
        if(m.equals(mainCourse[0]))
            billTotal += 650;
        else if(m.equals(mainCourse[1]))
            billTotal += 1750;
        else if(m.equals(mainCourse[2]))
            billTotal += 3275;
        
        
        if(de.equals(deserts[0]))
            billTotal += 300;
        else if(de.equals(deserts[1]))
            billTotal += 450;
        else if(de.equals(deserts[2]))
            billTotal += 650;
    }
}
