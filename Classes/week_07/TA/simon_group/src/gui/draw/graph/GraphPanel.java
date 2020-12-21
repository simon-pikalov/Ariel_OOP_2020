package gui.draw.graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.security.Key;
import java.util.EventListener;
import java.util.LinkedList;

public class GraphPanel extends JPanel implements MouseListener {

   private LinkedList<Point2D> points;
   String message;



    public GraphPanel(){
    super();
    this.setBackground(new Color(7, 43, 73)); //change color of background
    points = new LinkedList<Point2D>();
    this.addMouseListener(this);
    message = "To add a Node Press on the Screen";
}

void reset(){
    points = new LinkedList<Point2D>();
    this.repaint();
}

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked");

    }

    @Override
    public void mousePressed(MouseEvent e) {
        message = "";
        int x = e.getX();
        int y = e.getY();
        Point2D p = new Point2D.Double(x,y);
        points.add(p);
        repaint();
        System.out.println("mousePressed");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited");
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setFont(new Font("MV Boli",Font.PLAIN,25)); //set font of text
        g.setColor(Color.white);
        g.drawString(message, 100,100);
        Point2D prev = null;

        for (Point2D p : points)
        {
            g.setColor(Color.WHITE);
            g.fillOval((int)p.getX(), (int)p.getY(), 10, 10);

            if(prev != null)
            {
                Double dist = p.distance(prev);
                String distS = dist.toString().substring(0,dist.toString().indexOf(".")+2);
                g.setColor(Color.RED);
                g.drawLine((int)p.getX(), (int)p.getY(),
                        (int)prev.getX(), (int)prev.getY());
                g.setFont(new Font("MV Boli",Font.TRUETYPE_FONT,15)); //set font of text
                g.drawString(distS, (int)((p.getX()+prev.getX())/2),(int)((p.getY()+prev.getY())/2));
            }

            prev = p;
        }
    }

    public void displayHelp() {
        message = "To add a Node Press on the Screen";
        repaint();
    }




}
