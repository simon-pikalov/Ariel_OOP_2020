package class1;
import java.util.Random;
/**
 * This class represents a set of mathematically functions related
 * to random number generator, the main focus is to simplifies the use
 * of random numbers.
 *
 */
public class MyRandom {
    private long _seed;
    private Random _rand;
    public MyRandom(long seed) {
        _seed = seed;
        _rand = new Random(_seed);
    }
    public MyRandom() {
        this(new Random().nextLong());
    }
    public double random() {
        double ans;
        ans = this._rand.nextDouble();
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
        double r = random();
        double dx = max-min;
        ans  = min + dx*r;
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
        int ans;
        int dx = max-min;
        int randPosInt = Math.abs(_rand.nextInt());
        int r = randPosInt % dx;
        ans  = min + r;
        return ans;
    }
    public double nextGaussian() {
        double ans = this._rand.nextGaussian();
        return ans;
    }
}
