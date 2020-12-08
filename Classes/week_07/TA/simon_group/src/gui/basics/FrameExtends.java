package gui.basics;

import javax.swing.*;
import java.awt.*;

public class FrameExtends extends JFrame {

    public  FrameExtends(){
        super();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        this.setTitle("OOP Recitation 7 "); //sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application
        this.setResizable(false); //prevent frame from being resized
        this.setSize(screenWidth,screenHeight); //sets the x-dimension, and y-dimension of frame
        this.setVisible(true); //make frame visible
        ImageIcon image = new ImageIcon("./resources/sp.png"); //create an ImageIcon
        this.setIconImage(image.getImage()); //change icon of frame
        this.getContentPane().setBackground(new Color(0,122 ,232)); //change color of background

    }

    public static void main(String[] args) {
       new  FrameExtends();
    }

}
