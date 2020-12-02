package gui.draw.graph;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GFrame extends JFrame implements KeyListener {
        GraphPanel panel;

    public GFrame() {
        panel = new GraphPanel();
        this.add(panel);
        this.addKeyListener(this);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new GFrame();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==32){
            panel.reset();
            this.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
