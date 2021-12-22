package com.bookzone;
import java.awt.Color;

import javax.swing.JFrame;

public class frame extends JFrame{
    public frame(){
        setSize(1100,750);
        getContentPane().setBackground(new Color(171,212,182));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

