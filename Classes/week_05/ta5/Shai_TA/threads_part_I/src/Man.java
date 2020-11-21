public class Man implements Runnable {
    int mSleep;
    int mTimes;

    Man(int sleep, int times) {
        mSleep = sleep;
        mTimes = times;
    }

    public void print() {
        for (int i = 0; i < mTimes; i++) {
            System.out.println("man");

            try {
                Thread.sleep(mSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        print();
    }
}
