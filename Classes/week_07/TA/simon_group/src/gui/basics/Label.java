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

        // JLabel = a GUI display area for a string of text, an image, or both

        ImageIcon image = new ImageIcon("./resources/hack.jpg");
        Border border = BorderFactory.createLineBorder(Color.green,3);
        JLabel label = new JLabel(); //create a label
        label.setText("OOP 7 "); //set text of label
        label.setIcon(image);
        label.setForeground(new Color(0x00FF00)); //set font color of text
        label.setFont(new Font("MV dsads",Font.PLAIN,100)); //set font of text
        label.setBackground(Color.black); //set background color
        label.setOpaque(true); //display background color


        JFrame frame = new FrameExtends();
        frame.add(label);
        frame.pack();
    }
}