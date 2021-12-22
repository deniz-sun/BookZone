package com.bookzone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateSellOrder extends JFrame implements ActionListener{
    //properties
    Container container = getContentPane();
    Color color = new Color(171,212,182);
    Font font = new Font("Arial", Font.PLAIN, 20);

    String[] arr = {"Select Type","Text Book", "Lecture Note", "Other"};
    String[] arr2 = {"CS 101","CS 102"};

    JLabel createSellOrder = new JLabel("Create Sell Order");
    JLabel bookPhoto = new JLabel("*Photo of the book*");
    JLabel conditionScore = new JLabel("Condition Score");

    JButton lesson1 = new JButton("CS 102 ");
    JButton createSellOr = new JButton("Create Sell Order");

    JTextField enterName = new JTextField("Enter Name");
    JComboBox selectType = new JComboBox(arr);
    JTextField enterPrice = new JTextField("Enter Price");
    JComboBox addRelatedCourse = new JComboBox(arr2);

    //constructor
    public CreateSellOrder(){
        setTitle("Sell Order");
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
    public static void main(String[] args) { new CreateSellOrder();}

    //methods
    public void setContents(){
        createSellOrder.setBounds(400,30,500,50);
        bookPhoto.setBounds(60,80,300,200);
        enterName.setBounds(350,160,250,30);
        selectType.setBounds(350,240,250,30);
        enterPrice.setBounds(350,320,250,30);
        conditionScore.setBounds(350,400,250,30);
        addRelatedCourse.setBounds(50,450,200,50);
        lesson1.setBounds(50,530,150,50);
        createSellOr.setBounds(650,550,200,50);;

        createSellOrder.setFont(font);
        bookPhoto.setFont(font);
        enterName.setFont(font);
        selectType.setFont(font);
        enterPrice.setFont(font);
        conditionScore.setFont(font);
        addRelatedCourse.setFont(font);

        lesson1.setBackground(Color.gray.brighter());
        lesson1.setFont(font);
        createSellOr.setBackground(Color.gray.brighter());
        createSellOr.setFont(font);
        createSellOr.addActionListener(this);
    }
    public void addComponentsToContainer(){
        container.add(createSellOrder);
        container.add(bookPhoto);
        container.add(enterName);
        container.add(selectType);
        container.add(enterPrice);
        container.add(conditionScore);
        container.add(addRelatedCourse);
        container.add(lesson1);
        container.add(createSellOr);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == createSellOr){
            setVisible(false);
            new UserProfile();
        }
    }
}
