package gui.buttons;

import java.awt.*;


import java.awt.event.*;
import javax.swing.*;

public class ButtonExample extends JFrame implements ActionListener{

    JButton button;


    ButtonExample(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setVisible(true);


        button = new JButton();
        button.setBounds(100, 100, 250, 100);
        button.addActionListener(this);
        button.setText("I'm a button!");

        button.setFocusable(false);

        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans",Font.BOLD,25));
        button.setIconTextGap(-15);
        button.setForeground(Color.cyan);
        button.setBackground(Color.lightGray);
        button.setBorder(BorderFactory.createEtchedBorder());

        this.add(button);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== button) {
            System.out.println("poo");
            button.setEnabled(true);

        }
    }

    public static void main(String[] args) {
       new ButtonExample();
    }
}