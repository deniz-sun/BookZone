package com.bookzone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transaction_confirmation extends JFrame implements ActionListener {
    Container container = getContentPane();
    JButton acceptButton = new JButton("ACCEPT");
    JButton refuseButton = new JButton("REFUSE");

    Font font = new Font("Arial", Font.PLAIN, 30);

    JLabel name = new JLabel("Deniz Sun");
    Icon icon = new ImageIcon();
    JLabel description = new JLabel();
    JLabel title = new JLabel("Transaction confirmation screen");
    Color color = new Color(171,212,182);


    public transaction_confirmation(){
        setTitle("BookZone");
        setVisible(true);
        setSize(1000, 700);
        container.setLayout(null);
        getContentPane().setBackground(color);
        setContents();
        addContents();
    }

    public void setContents(){
        acceptButton.setBounds(200,500,150,50);
        refuseButton.setBounds(650,500,150,50);
        acceptButton.addActionListener(this);
        refuseButton.addActionListener(this);
        acceptButton.setBackground(color.brighter());
        refuseButton.setBackground(color.brighter());

        title.setFont(font);
        title.setBounds(100, 100, 500, 40);

        //get name
        //get icon
        //get description
    }
    public void addContents(){
        container.add(title);
        container.add(acceptButton);
        container.add(refuseButton);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == acceptButton){

            // do the transaction
        }
        if (e.getSource() == refuseButton){
            // delete the request
        }

    }

    public static void main(String[] args) {
        new transaction_confirmation();
    }

}
