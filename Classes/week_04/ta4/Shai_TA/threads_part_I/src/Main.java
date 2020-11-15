import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("ThreadMaster");

        String logo_path = "src/logo.txt";
        String logo_str = new String(Files.readAllBytes(Paths.get(logo_path)));
        System.out.println(logo_str);

        int times = 100;
        Thread t1 = new Thread(new Spider(10, times));
        Thread t2 = new Thread(new Man(10, times));

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; ++i) {
            System.out.println("Does what a spider-man does!!");
        }

    }
}
