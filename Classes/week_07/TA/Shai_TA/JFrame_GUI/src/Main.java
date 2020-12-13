import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        Window window = new Window();
        window.setVisible(true);

        Thread p_thrd = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        window.repaint();

                        Thread.sleep((long) 1000/30);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        p_thrd.start();
    }
}
