package exp_1;


public class Producer extends Thread {
    static int producer_counter = 0;

    private final int prod_serial = ++producer_counter;
    private final DataCenter data;
    private int counterMsg = 0;

    public Producer(DataCenter data) {
        this.data = data;
    }

    /**
     * Creates Data non-stop
     */
    private void createData() {
        while (true) {
            try {
                synchronized (data) {
                    while (data.isFull()) {
                        System.out.println("Producer- wait (" + prod_serial + ")");
                        data.wait();
                    }
                    String msg = String.format("MSG:{%s}", ++counterMsg);
                    data.addMsg(msg);
                    data.notifyAll();
                }
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        createData();
    }
}
