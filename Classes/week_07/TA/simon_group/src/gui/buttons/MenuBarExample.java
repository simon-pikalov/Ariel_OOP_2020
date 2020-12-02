package gui.buttons;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuBarExample extends JFrame implements ActionListener{

    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu helpMenu;
    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem exitItem;
    ImageIcon loadIcon;
    ImageIcon saveIcon;
    ImageIcon exitIcon;

    MenuBarExample(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(100,100);
        this.setLayout(new FlowLayout());

         loadIcon = new ImageIcon("./resources/load.jpg");
         saveIcon = new ImageIcon("./resources/save.png");
         exitIcon = new ImageIcon("./resources/exit.jpg");

        loadIcon = scaleImageIcon(loadIcon,20,20);
        saveIcon = scaleImageIcon(saveIcon,20,20);
        exitIcon = scaleImageIcon(exitIcon,20,20);

        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");



        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        loadItem.setIcon(loadIcon);
        saveItem.setIcon(saveIcon);
        exitItem.setIcon(exitIcon);

        fileMenu.setMnemonic(KeyEvent.VK_F); // Alt + f for file
        editMenu.setMnemonic(KeyEvent.VK_E); // Alt + e for edit
        helpMenu.setMnemonic(KeyEvent.VK_H); // Alt + h for help
        loadItem.setMnemonic(KeyEvent.VK_L); // l for load
        saveItem.setMnemonic(KeyEvent.VK_S); // s for save
        exitItem.setMnemonic(KeyEvent.VK_E); // e for exit

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);

        this.setVisible(true);
    }

    public static ImageIcon scaleImageIcon(ImageIcon imageIcon,int width,int height){
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        return new ImageIcon(newimg);  // transform it back
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==loadItem) {
            System.out.println("*beep boop* you loaded a file");
        }
        if(e.getSource()==saveItem) {
            System.out.println("*beep boop* you saved a file");
        }
        if(e.getSource()==exitItem) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new MenuBarExample();
    }
}
