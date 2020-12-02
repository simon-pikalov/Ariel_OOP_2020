package gui.basics;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Label {

    public static void main(String[] args) {

        ImageIcon image = new ImageIcon("./resources/hack.jpg");
        Border border = BorderFactory.createLineBorder(Color.RED,3);

        JLabel label = new JLabel(); //create a label
        label.setText("OOP 7 "); //set text of label
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT,CENTER, RIGHT of imageicon
        label.setVerticalTextPosition(JLabel.TOP); //set text TOP,CENTER, BOTTOM of imageicon
        label.setForeground(new Color(0x84080C)); //set font color of text
        label.setFont(new Font("MV Boli",Font.PLAIN,100)); //set font of text
        label.setIconTextGap(-200); //set gap of text to image
        label.setBackground(Color.black); //set background color
        label.setOpaque(true); //display background color
        label.setBorder(border); //sets border of label (not image+text)
        label.setVerticalAlignment(JLabel.CENTER); //set vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within label
        //label.setBounds(100, 100, 250, 250); //set x,y position within frame as well as dimensions

        JFrame frame = new FrameExtends();
        frame.add(label);
        frame.pack();
    }
}