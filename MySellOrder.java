import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MySellOrder extends JFrame implements ActionListener{

    //properties
    JPanel panel;
    JComboBox bookType,addRelatedCourse;
    JTextField bookName,bookPrice;
    JLabel mySellOrder,conditionScore,offers,name1,name2;
    JButton courses,remove,accept1,accept2;
    GridBagConstraints gbc;

    //constructor
    public MySellOrder(){
        //frame
        setTitle("My Sell Order");
        setSize(1000,700);
        setBackground(new Color(70, 213, 105));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panel
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setSize(1100,750);
        panel.setBackground(new Color(171,212,182));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,60,10,60);
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        add(panel);

        //textfield
        bookName = new JTextField(20);
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(bookName,gbc);

        String[] arr = {"Big Java Late Object","Calculus"};
        bookType = new JComboBox(arr);
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(bookType,gbc);

        bookPrice = new JTextField(15);
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(bookPrice,gbc);

        String[] arr2 = {"CS 102","CS 201"};
        addRelatedCourse = new JComboBox(arr2);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(addRelatedCourse,gbc);

        //label
        mySellOrder = new JLabel("My Sell Order");
        mySellOrder.setFont(new Font("Arial",Font.PLAIN,21));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 10;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(mySellOrder,gbc);

        conditionScore = new JLabel("Condition Score");
        conditionScore.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridheight = 1;
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(conditionScore,gbc);

        offers = new JLabel("Offers:");
        offers.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(offers,gbc);

        name1= new JLabel("Alper Bozkurt");
        name1.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(name1,gbc);

        name2 = new JLabel("Deniz Sun");
        name2.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(name2,gbc);

        //button
        courses = new JButton("CS 102");
        courses.setPreferredSize(new Dimension(80,60));
        courses.setBackground(Color.GREEN);
        courses.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(courses,gbc);

        remove = new JButton("REMOVE");
        remove.setPreferredSize(new Dimension(120,60));
        remove.setBackground(Color.GREEN);
        remove.addActionListener(this);
        gbc.gridx = 6;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(remove,gbc);

        accept1= new JButton("ACCEPT");
        accept1.setPreferredSize(new Dimension(120,60));
        accept1.setBackground(Color.GREEN);
        accept1.addActionListener(this);
        gbc.gridx = 6;
        gbc.gridy = 9;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(accept1,gbc);

        accept2 = new JButton("ACCEPT");
        accept2.setPreferredSize(new Dimension(120,60));
        accept2.setBackground(Color.GREEN);
        accept2.addActionListener(this);
        gbc.gridx = 6;
        gbc.gridy = 10;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(accept2,gbc);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MySellOrder();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == accept1){
    		this.setVisible(false);
            new BookRequest();
    	}
    	else if(e.getSource() == accept2){
    		this.setVisible(false);
    		new BookRequest();
    	}
    	else if(e.getSource() == remove){
    		courses.setVisible(false);
            new UserProfile();
    	}

    }
}
