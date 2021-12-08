import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookRequest implements ActionListener{
    //properties
    JFrame frame;
    JPanel panel;
    JLabel bookRequest,name,requestMessage;
    JButton accept,refuse;
    GridBagConstraints gbc;

    //constructor
    public BookRequest(){
        //frame
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Book Request");
        frame.setSize(1000,1000);
        frame.setVisible(true);

        //panel
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setSize(1000,1000);
        panel.setBackground(new Color(171,212,182));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(30,30,10,30);
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.add(panel);

        //label
        bookRequest = new JLabel("BOOK REQUEST");
        bookRequest.setFont(new Font("Arial",Font.PLAIN,21));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 10;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(bookRequest,gbc);

        name = new JLabel("ALPER BOZKURT");
        name.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(name,gbc);

        requestMessage = new JLabel("'A TextBook of Higher Mathematics'wanted by Alper. Alper offers 100 point.");
        requestMessage.setFont(new Font("Arial",Font.PLAIN,17));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(requestMessage,gbc);

        //button
        accept = new JButton("ACCEPT");
        accept.setPreferredSize(new Dimension(80,60));
        accept.setBackground(Color.GREEN);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(accept,gbc);

        refuse = new JButton("REFUSE");
        refuse.setPreferredSize(new Dimension(80,60));
        refuse.setBackground(Color.GREEN);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(refuse,gbc);
    }

    public static void main(String[] args) {
        new BookRequest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}