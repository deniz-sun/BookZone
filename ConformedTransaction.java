package com.bookzone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ApproveWindow extends JFrame implements ActionListener {

    //properties
    Container container = getContentPane();
    Color color = new Color(171,212,182);
    Font font = new Font("Arial", Font.PLAIN, 20);

    JLabel approveWindow= new JLabel("APPROVE WINDOW");
    JLabel confirmMessage = new JLabel(" => Exchange has been done!");

    JButton conformedTransaction = new JButton("Conformed Transaction");

    //constructor
    public ApproveWindow(){
        setTitle("Approve Window");
        setVisible(true);
        setSize(1000, 700);
        getContentPane().setBackground(color);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        container.setLayout(null);

        setContents();
        addComponentsToContainer();
    }

    //main
    public static void main(String[] args) {
        new ApproveWindow();
    }

    //methods
    public void setContents(){
        approveWindow.setBounds(400,30,500,50);
        confirmMessage.setBounds(270,350,500,30);

        conformedTransaction.setBounds(600,550,250,60);
        conformedTransaction.addActionListener(this);

        approveWindow.setFont(font);
        confirmMessage.setFont(font);

        conformedTransaction.setBackground(Color.gray.brighter());
        conformedTransaction.setFont(font);
    }

    public void addComponentsToContainer(){
        container.add(approveWindow);
        container.add(confirmMessage);
        container.add(conformedTransaction);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == conformedTransaction){
            this.setVisible(false);
            new ConformedTransaction();
        }
    }
}
