/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMS;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author Kalaadhar
 */
class TableWindow extends JFrame{
    int sizeX = 350;
    int sizeY = 700;
    
    MenuGUI mTable1,mTable2,mTable3,mTable4,mTable5,mTable6,mTable7,mTable8,mTable9,mTable10;
    
    JButton table1,table2,table3,table4,table5,table6,table7,table8,table9,table10,submit,clear;
    JTextArea kitchenForm;
    JScrollPane kitchenFormPane;
    
    TableWindow(){
        super("RMS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(sizeX,sizeY));
        Container content = getContentPane();
        JPanel innerContent = new JPanel();
        JPanel button1 = new JPanel();
        JPanel button2 = new JPanel();
        JPanel button3 = new JPanel();
        JPanel button4 = new JPanel();
        JPanel button5 = new JPanel();
        JPanel button6 = new JPanel();
        JPanel button7 = new JPanel();
        JPanel button8 = new JPanel();
        JPanel button9 = new JPanel();
        JPanel button10 = new JPanel();
        JPanel submitPanel = new JPanel();
        JPanel clearPanel = new JPanel();
        
        Border black = BorderFactory.createLineBorder(Color.BLACK);
        
        kitchenForm = new JTextArea("Welcome to RMS");
        kitchenFormPane = new JScrollPane(kitchenForm);
        
        table1 = new JButton("Table 1");
        table2 = new JButton("Table 2");
        table3 = new JButton("Table 3");
        table4 = new JButton("Table 4");
        table5 = new JButton("Table 5");
        table6 = new JButton("Table 6");
        table7 = new JButton("Table 7");
        table8 = new JButton("Table 8");
        table9 = new JButton("Table 9");
        table10 = new JButton("Table 10");
        submit = new JButton("Submit");
        clear = new JButton("Clear");
        
        button1.add(table1);
        button2.add(table2);
        button3.add(table3);
        button4.add(table4);
        button5.add(table5);
        button6.add(table6);
        button7.add(table7);
        button8.add(table8);
        button9.add(table9);
        button10.add(table10);
        submitPanel.add(submit);
        clearPanel.add(clear);
        innerContent.add(kitchenFormPane);
        content.add(innerContent);
        
        table1.addActionListener(new TableWindow.TableButton1());
        table1.addActionListener(new TableWindow.TableButton2());
        table1.addActionListener(new TableWindow.TableButton3());
        table1.addActionListener(new TableWindow.TableButton4());
        table1.addActionListener(new TableWindow.TableButton5());
        table1.addActionListener(new TableWindow.TableButton6());
        table1.addActionListener(new TableWindow.TableButton7());
        table1.addActionListener(new TableWindow.TableButton8());
        table1.addActionListener(new TableWindow.TableButton9());
        table1.addActionListener(new TableWindow.TableButton10());
        table1.addActionListener(new TableWindow.Submit());
        table1.addActionListener(new TableWindow.Clear());
        
        pack();
        setVisible(true);
    }
    
    private class TableButton1 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            MenuGUI.submitForm.add("\nTable-1 : ");
            mTable1 = new MenuGUI();
        }
    }
    
    private class TableButton2 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            MenuGUI.submitForm.add("\nTable-2 : ");
            mTable2 = new MenuGUI();
        }
    }
    
    private class TableButton3 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            MenuGUI.submitForm.add("\nTable-3 : ");
            mTable3 = new MenuGUI();
        }
    }
    
    private class TableButton4 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            MenuGUI.submitForm.add("\nTable-4 : ");
            mTable4 = new MenuGUI();
        }
    }
    
    private class TableButton5 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            MenuGUI.submitForm.add("\nTable-5 : ");
            mTable5 = new MenuGUI();
        }
    }
    
    private class TableButton6 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            MenuGUI.submitForm.add("\nTable-6 : ");
            mTable6 = new MenuGUI();
        }
    }
    
    private class TableButton7 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            MenuGUI.submitForm.add("\nTable-7 : ");
            mTable7 = new MenuGUI();
        }
    }
    
    private class TableButton8 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            MenuGUI.submitForm.add("\nTable-8 : ");
            mTable8 = new MenuGUI();
        }
    }
    
    private class TableButton9 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            MenuGUI.submitForm.add("\nTable-9 : ");
            mTable9 = new MenuGUI();
        }
    }
    
    private class TableButton10 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            MenuGUI.submitForm.add("\nTable-10 : ");
            mTable10 = new MenuGUI();
        }
    }
    
    private class Submit implements ActionListener{
        public void actionPerformed(ActionEvent e){
            for(int i=0; i<MenuGUI.submitForm.size(); i++){
                kitchenForm.append(MenuGUI.submitForm.get(i)+"\n");
            }
        }
    }
    
    private class Clear implements ActionListener{
        public void actionPerformed(ActionEvent e){
            MenuGUI.submitForm.clear();
            kitchenForm.setText("Welcome to RMS!");
        }
    }
}
