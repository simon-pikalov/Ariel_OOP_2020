public class Spider implements Runnable {
    int mTimes;
    int mSleep;

    Spider(int sleep,int times){
        mTimes = times;
        mSleep = sleep;
    }
    @Override
    public void run() {
        print();
    }

    private void print() {

        for (int i=0;i<mTimes;++i){
            System.out.print("Spider - ");

            try {
                Thread.sleep(mSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
