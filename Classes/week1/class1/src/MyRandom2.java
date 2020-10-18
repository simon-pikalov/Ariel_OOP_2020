//package class1;//package week1;
import java.util.Random;
/**
 * This class represents a set of mathematically functions related
 * to random number generator, the main focus is to simplifies the use
 * of random numbers.
 *
 */
public class MyRandom2 extends Random {
    private long _seed;
    public MyRandom2(long seed) {
        super(seed);
        _seed = seed;
       // _rand = new Random(_seed);
    }
    public MyRandom2() {
        this(new Random().nextLong());
    }
    public double random() {
        double ans;
        ans = super.nextDouble();
        return ans;
    }

    /**
     * Computes a random double value between [min,max)
     * @param min lowest value (lowwer bound - close range).
     * @param max highes value (upper bound - open range).
     * @return a random value within [min,max)
     */
    public double random(double min, double max) {
        if(min>max) {
            throw new RuntimeException("ERR: random(min,max) should get a valid range [min,max). got ["+min+","+max+")");
        }
        double ans;
        double r = random(); // r= [0.0,1.0)
        double dx = max-min; //
        ans  = min + dx*r; // min + dx*r = min + [0,max-min)] = [min,max)
        return ans;
    }
    /**
     * Computes a random integer value between [min,max)
     * @param min lowest value (lowwer bound - close range).
     * @param max highes value (upper bound - open range).
     * @return a random value within [min,max)
     */
    public int randomInt(int min, int max) {
        if(min>max) {
            throw new RuntimeException("ERR: randomInt(min,max) should get a valid range [min,max). got ["+min+","+max+")");
        }
        /*int ans;
        int dx = max-min;
        int randPosInt = Math.abs(_rand.nextInt());
        int r = randPosInt % dx;
        ans  = min + r;
        */

        double r = random(min,max); // [min,max)
        int ans = (int)r;
        return ans;
    }
    public double nextGaussian() {
        double ans = super.nextGaussian();
        return ans;
    }
}
