import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transaction_confirmation extends JFrame implements ActionListener {
    JButton acceptButton = new JButton("ACCEPT");
    JButton refuseButton = new JButton("REFUSE");


    JLabel name = new JLabel("Deniz Sun");
    Icon icon = new ImageIcon();
    JLabel description = new JLabel();


    public transaction_confirmation(){
        Color color = new Color(171,212,182);
        setTitle("Transaction confirmation screen");
        setVisible(true);
        setSize(1000, 700);
        getContentPane().setBackground(color);
    }

    public void setContents(){
        //get name
        //get icon
        //get description
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
