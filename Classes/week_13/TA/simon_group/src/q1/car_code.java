package q1;

import java.util.Date;

public interface car_code {

    /**
     * Allow to open the car by the rules
     * @param key
     * @return
     */
     boolean open(String key);

    /**
     *
     * @return if the car is open
     */
     boolean isOpen();

    /**
     *
     * @return if the car van be open now
     */
    boolean canBeOpen();

    /**
     *
     * @return the car -> no need to implement this at the exam.
     */
      default car getCar() {
          return null;
      }



}
