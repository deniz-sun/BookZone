package com.bookzone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmedTransaction extends JFrame implements ActionListener{

    //properties
    JPanel panel;
    JLabel conformedTransaction,bookName,bookType,bookPrice,relatedCourses;
    JLabel conditionScore,transactionConfirmed,ratedName;
    JButton courses,rate;
    GridBagConstraints gbc;
    Font font = new Font("Arial",Font.PLAIN,18);

    //constructor
    public ConfirmedTransaction(){
        //frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Confirmed Transaction");
        setSize(1000,700);


        //panel
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setSize(1000,1000);
        panel.setBackground(new Color(171,212,182));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(30,60,30,60);
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        add(panel);

        //label
        conformedTransaction = new JLabel("CONFIRMED TRANSACTION");
        conformedTransaction.setFont(new Font("Arial",Font.PLAIN,21));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 10;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(conformedTransaction,gbc);

        bookName = new JLabel("Name:");
        bookName.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(bookName,gbc);

        bookType = new JLabel("Type:");
        bookType.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(bookType,gbc);

        bookPrice = new JLabel("Price:");
        bookPrice.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(bookPrice,gbc);

        relatedCourses = new JLabel("Related courses:");
        relatedCourses.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(relatedCourses,gbc);

        conditionScore = new JLabel("Condition Score");
        conditionScore.setFont(font);
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 20;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(conditionScore,gbc);

        transactionConfirmed = new JLabel("Please Rate the Other User");
        transactionConfirmed.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(transactionConfirmed,gbc);

        ratedName = new JLabel("Deniz Sun");
        ratedName.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(ratedName,gbc);

        //button
        courses = new JButton("CS 102");
        courses.setPreferredSize(new Dimension(80,60));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(courses,gbc);

        rate = new JButton("RATE");
        rate.setPreferredSize(new Dimension(80,60));
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(rate,gbc);

        setVisible(true);
    }

    public static void main(String[] args) {
   //     new ConfirmedTransaction();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
