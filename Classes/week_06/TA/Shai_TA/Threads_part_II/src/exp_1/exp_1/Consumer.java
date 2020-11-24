package exp_1;


public class Consumer extends Thread {
    static int consumer_counter = 0;
    private final int con_serial = ++consumer_counter;
    private final DataCenter data;

    public Consumer(DataCenter data) {
        this.data = data;
    }

    /**
     * Consumes data non-stop
     */
    public void dataConsume() {
        while (true) {
            String msg;
            try {
                synchronized (data) {
                    while (data.isEmpty()) {
                        System.out.println("Consumer- wait");
                        data.wait();
                    }
                    msg = data.retrieveMsg();
                    data.notifyAll();
                    System.out.println(String.format("(%s) read msg: %s Count:%d ", con_serial, msg, data.getCount()));
                }
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void run() {
        dataConsume();
    }
}
