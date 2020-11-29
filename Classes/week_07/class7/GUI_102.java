import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Taken from: https://www.tutorialspoint.com/javaexamples/gui_polygon.htm
 */
public class GUI_102 extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Polygon p = new Polygon();
        for (int i = 0; i < 5; i++) p.addPoint((int) (
                100 + 50 * Math.cos(i * 2 * Math.PI / 5)),(int) (
                100 + 50 * Math.sin(i * 2 * Math.PI / 5)));

        g.drawPolygon(p);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(Color.YELLOW);
        frame.setTitle("DrawPoly");
        frame.setSize(350, 250);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Container contentPane = frame.getContentPane();
        contentPane.add(new GUI_102());
        frame.show();
    }
}