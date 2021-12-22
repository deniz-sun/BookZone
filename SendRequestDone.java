package com.bookzone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendRequestDone extends JFrame implements ActionListener{

    //properties
    Container container = getContentPane();
    Color color =  new Color(171,212,182);
    Font font = new Font("Arial", Font.PLAIN, 20);

    JLabel word = new JLabel("Sell Request Has Been Done!");

    JButton userProfile = new JButton("User Profile");
    JButton browsing = new JButton("Browsing Page");

    //constructor
    public SendRequestDone(){
        setTitle("Sell Order Has Been Done");
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
    public static void main(String[] args) {new SendRequestDone();}

    //methods
    public void setContents(){
        word.setBounds(370,350,500,30);

        userProfile.setBounds(200,550,200,50);
        browsing.setBounds(600,550,200,50);

        userProfile.addActionListener(this);
        browsing.addActionListener(this);

        word.setFont(font);

        userProfile.setBackground(Color.gray.brighter());
        userProfile.setFont(font);
        browsing.setBackground(Color.gray.brighter());
        browsing.setFont(font);
    }

    public void addComponentsToContainer(){
        container.add(word);
        container.add(userProfile);
        container.add(browsing);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == userProfile){
            this.setVisible(false);
            new UserProfile();
        }
        else if(e.getSource() == browsing){
            this.setVisible(false);
            new BrowsingWindow();
        }
    }
}
