

public class Main {

    static final int kID_IDX = 1;
    static final int kLEVL_IDX = 1;

    public static void main(String[] args) {
        int id = Integer.parseInt(args[kID_IDX]);
        int level = Integer.parseInt(args[kLEVL_IDX]);

        System.out.println("ID:" + id + "\nLevel:" + level);
    }
}
