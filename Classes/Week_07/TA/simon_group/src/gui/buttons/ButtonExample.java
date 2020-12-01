package gui.buttons;

import java.awt.*;


import java.awt.event.*;
import javax.swing.*;

public class ButtonExample extends JFrame implements ActionListener{

    JButton exampleButton;
    JLabel label;

    ButtonExample(){

        ImageIcon icon = new ImageIcon("point.png");
        ImageIcon icon2 = new ImageIcon("face.png");

        label = new JLabel();
        label.setIcon(icon2);
        label.setBounds(150, 250, 150, 150);
        label.setVisible(false);

        exampleButton = new JButton();
        exampleButton.setBounds(100, 100, 250, 100);
        exampleButton.addActionListener(this);
        exampleButton.setText("I'm a button!");

        exampleButton.setFocusable(false);
        exampleButton.setIcon(icon);
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
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== exampleButton) {
            System.out.println("poo");
            exampleButton.setEnabled(false);
            label.setVisible(true);
        }
    }

    public static void main(String[] args) {
       new ButtonExample();
    }
}