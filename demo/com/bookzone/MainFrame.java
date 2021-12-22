/**
 * @(#)MainFrame.java
 *
 *
 * @author
 * @version 1.00 2021/12/8
 */

package com.bookzone;
import java.awt.Color;

import javax.swing.JFrame;
public class MainFrame extends JFrame{

    public MainFrame() {
    	setSize(1100,750);
        getContentPane().setBackground(new Color(171,212,182));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
