package gui.buttons;

import java.awt.*;


import java.awt.event.*;
import javax.swing.*;

public class ButtonExample extends JFrame implements ActionListener{

    JButton exampleButton;


    ButtonExample(){


        exampleButton = new JButton();
        exampleButton.setBounds(100, 100, 250, 100);
        exampleButton.addActionListener(this);
        exampleButton.setText("I'm a button!");

        exampleButton.setFocusable(false);

        exampleButton.setHorizontalTextPosition(JButton.CENTER);
        exampleButton.setVerticalTextPosition(JButton.BOTTOM);
        exampleButton.setFont(new Font("Comic Sans",Font.BOLD,25));
        exampleButton.setIconTextGap(-15);
        exampleButton.setForeground(Color.cyan);
        exampleButton.setBackground(Color.lightGray);
        exampleButton.setBorder(BorderFactory.createEtchedBorder());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setVisible(true);
        this.add(exampleButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== exampleButton) {
            System.out.println("poo");
            exampleButton.setEnabled(true);

        }
    }

    public static void main(String[] args) {
       new ButtonExample();
    }
}