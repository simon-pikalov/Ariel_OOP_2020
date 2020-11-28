package motivation;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
//from w w w . j  av a 2 s  .c o  m
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ThreadMotivation {

    static void printPrime(){

        int i =0;
        int num =0;
        //Empty String

        for (i = 1; i <= 10000000; i++)
        {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int counter=0;
            for(num =i; num>=1; num--)
            {
                if(i%num==0)
                {
                    counter = counter + 1;
                }
            }
            if (counter ==2)
            {
                //Appended the Prime number to the String
                System.out.println(i);
            }
        }


    }

    public static void main(String[] args) throws InterruptedException {


                JFrame frame = new JFrame();
                frame.add(new ImagePanel());

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 500);
                frame.setVisible(true);


        Runnable player = new AudioPlayerExample1();
        Thread musicThread = new Thread(player);
        musicThread.start(); // r

        printPrime();

    }
}

class ImagePanel extends JPanel {

    Image image;

    public ImagePanel() {
        image = Toolkit.getDefaultToolkit().createImage("./resources/tenor.gif");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }

}