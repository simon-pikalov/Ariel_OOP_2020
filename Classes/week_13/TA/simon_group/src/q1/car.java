package q1;

import java.util.Date;

public interface car {

    /**
     *
     * @return true iff the car is running now
     */
    public boolean isRunning();

    /**
     * Allow to open the car
     * @param key
     * @return the status of the car
     */
    public boolean open(String key);

    /**
     *
     * @return The last time the car was opened
     */
    public Date lastRun();


}
