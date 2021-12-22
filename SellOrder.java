package com.bookzone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellOrder extends JFrame implements ActionListener{

    //properties
    Container container = getContentPane();
    Color color = new Color(171,212,182);
    Font font = new Font("Arial", Font.PLAIN, 20);

    JLabel sellOrder = new JLabel("SELL ORDER");
    JLabel bookPhoto = new JLabel("*Photo of the book*");
    JLabel bookName = new JLabel("Name:");
    JLabel bookType = new JLabel("Type:");
    JLabel bookPrice = new JLabel("Price:");
    JLabel conditionScore = new JLabel("Condition Score");

    JButton lesson1 = new JButton("CS 102 ");
    JButton lesson2 = new JButton("CS 101 ");
    JButton sendRequest = new JButton("Send Request");

    //constructor
    public SellOrder(){
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
    public static void main(String[] args) {
        new SellOrder();
    }

    //methods
    public void setContents(){
        sellOrder.setBounds(400,30,500,50);
        bookPhoto.setBounds(60,80,300,200);
        bookName.setBounds(350,160,250,30);
        bookType.setBounds(350,240,250,30);
        bookPrice.setBounds(350,320,250,30);
        conditionScore.setBounds(350,400,250,30);
        lesson1.setBounds(50,450,150,50);
        lesson2.setBounds(50,530,150,50);
        sendRequest.setBounds(650,550,200,50);

        sendRequest.addActionListener(this);

        sellOrder.setFont(new Font("Arial", Font.BOLD, 32));
        bookPhoto.setFont(font);
        bookName.setFont(font);
        bookType.setFont(font);
        bookPrice.setFont(font);
        conditionScore.setFont(font);

        lesson1.setBackground(Color.gray.brighter());
        lesson1.setFont(font);
        lesson2.setBackground(Color.gray.brighter());
        lesson2.setFont(font);
        sendRequest.setBackground(Color.gray.brighter());
        sendRequest.setFont(font);
    }

    public void addComponentsToContainer(){
        container.add(sellOrder);
        container.add(bookPhoto);
        container.add(bookName);
        container.add(bookType);
        container.add(bookPrice);
        container.add(conditionScore);
        container.add(lesson1);
        container.add(lesson2);
        container.add(sendRequest);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sendRequest){
            this.setVisible(false);
            new SendRequestDone();
        }
    }
}
