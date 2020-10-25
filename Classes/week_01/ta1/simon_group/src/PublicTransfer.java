public interface PublicTransfer {


    /**
     *
     * @return how many  passenger are currently in the public Transfer
     */
    public int getCurrPassengerCount();

    /**
     * add passenger to the transfer
     */
    public void addPassenger();

    /**
     * minus one passenger to the transfer
     */
    public void getOffPassenger();

}
