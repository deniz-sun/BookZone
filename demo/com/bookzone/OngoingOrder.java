package com.bookzone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OngoingOrder extends JFrame implements ActionListener {
    Order order;
    User loggedInUser;
    ArrayList<Order> orders;
    //properties frame;
    JPanel panel;
    JLabel sellOrder,bookName,bookType,bookPrice,conditionScore,relatedCourses;
    JButton lesson1,lesson2,sendRequest;
    GridBagConstraints gbc;
    Font font = new Font("Arial",Font.PLAIN,18);


    //constructor
    public OngoingOrder(Order order,User loggedInUser,ArrayList<Order> orders){
        this.order = order;
        this.loggedInUser = loggedInUser;
        this.orders = orders;
        //frame
        setTitle("Sell Order");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,700);

        //panel
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setSize(1100,750);
        panel.setBackground(new Color(171,212,182));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(30,60,30,60);
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        add(panel);

        //label
        sellOrder = new JLabel("ONGOING ORDER");
        sellOrder.setFont(new Font("Arial",Font.PLAIN,21));
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(sellOrder,gbc);

        bookName = new JLabel("Name: "+order.getName());
        bookName.setFont(font);
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(bookName,gbc);

        bookType = new JLabel("Type: "+order.getType());
        bookType.setFont(font);
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(bookType,gbc);

        bookPrice = new JLabel("Price: "+order.getPrice());
        bookPrice.setFont(font);
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(bookPrice,gbc);

        conditionScore = new JLabel("Condition Score: "+order.getConditionScore());
        conditionScore.setFont(font);
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(conditionScore,gbc);

        relatedCourses = new JLabel("Related Courses: "+order.getRelatedCourses());
        relatedCourses.setFont(font);
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(relatedCourses,gbc);
/*
        //button
        lesson1 = new JButton("CS 102");
        lesson1.setPreferredSize(new Dimension(80,60));
        lesson1.setBackground(Color.GREEN);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(lesson1,gbc);

        lesson2 = new JButton("CS 101");
        lesson2.setPreferredSize(new Dimension(80,60));
        lesson2.setBackground(Color.GREEN);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(lesson2,gbc);
*/
        gbc.gridx = 11;
        gbc.gridy = 7;
        gbc.gridwidth = 10;
        gbc.fill = GridBagConstraints.BOTH;
        if(order.getTransaction()!=null) {
            if(order.getTransaction().getBuyer().equals(loggedInUser)||order.getTransaction().getSeller().equals(loggedInUser)) {
                sendRequest = new JButton("Confirm");
                sendRequest.addActionListener(this);
                sendRequest.setPreferredSize(new Dimension(120, 60));
                sendRequest.setBackground(new Color(15, 196, 122));

                panel.add(sendRequest, gbc);
            }else
                panel.add(new JLabel("Order is transacting with another user!"), gbc);
        }else
            panel.add(new JLabel("Waiting for advertiser to start transaction!"), gbc);
        setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(order.isSellOrder())
            order.getTransaction().buyerConfirm();
        else
            order.getTransaction().sellerConfirm();

        if(order.getTransaction().getConfirmation()){
            order.getTransaction().enactTransaction();
            orders.remove(order);
            System.out.println("Transaction done");
            JOptionPane.showMessageDialog(this, "Transaction done!");
        }else
            JOptionPane.showMessageDialog(this, "Transaction confirmed!");

    }
/*
    public static void main(String[] args) {
        new SellOrder();
    }

 */
}
