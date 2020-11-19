package exp_1;


public class DataCenter {
    public static final int kCAPACITY = 500;
    private String[] msg = new String[kCAPACITY];
    private int count = 0;

    /**
     * Retrieve a message from the DataCenter
     * @return The latest message added to the DataCenter
     */
    public String retrieveMsg() {
        if (count == 0){
            System.err.println("DataCenter is empty!");
            return "";
        }
        count--;
        return msg[count];
    }

    /**
     * Add a message to the DataCenter
     * @param msg The new message
     */
    public void addMsg(String msg) {
        if (count == kCAPACITY){
            System.err.println("DataCenter reached it capacity, message dropped!");
            return;
        }
        this.msg[count] = msg;
        count++;
    }

    /**
     * Returns the amount of messages currently in the DataCenter
     * @return The amount of messages currently in the DataCenter
     */
    public int getCount() {
        return count;
    }

    /**
     * Checks if the DataCenter is empty.
     * @return true if the DataCenter is empty, o.w. false.
     */
    public boolean isEmpty() {
        return this.count == 0;
    }
    /**
     * Checks if the DataCenter is empty.
     * @return true if the DataCenter is empty, o.w. false.
     */
    public boolean isFull(){
    	return this.count == kCAPACITY;
	}
}
