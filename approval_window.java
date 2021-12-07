package com.bookzone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class approval_window extends JFrame implements ActionListener {
    Container container = getContentPane();
    JButton profile = new JButton("User Profile");
    JLabel message1 = new JLabel("Exchange has been done. You gained ");
    JLabel message2 = new JLabel(" points. Congratulations!");
    int points;
    Font font = new Font("Arial", Font.PLAIN, 30);
    Color color = new Color(171,212,182);



    public approval_window(){
        setTitle("BookZone");
        setVisible(true);
        setSize(1000, 700);
        container.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(color);
        setContents();
        addContents();

    }

    public void setContents(){
        profile.setBackground(color.brighter());
        profile.setFont(font);
        profile.addActionListener(this);
        //set the point system and the messages together
    }
    public void addContents(){
        container.add(profile);
        //add the points and message

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == profile){
            this.setVisible(false);
            new user_profile();
        }
    }
}
