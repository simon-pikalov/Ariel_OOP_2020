public class javaTricks {
    enum Level {
        EASY,
        MEDIUM,
        HARD
    }

    public static void main(String[] args) {

        int num = 1;
        double trick = (num % 2 == 0) ? 0 : 1;
        System.out.println(trick);

        String[] stringArr = {"\nThis","is","for","each",":)\n"};
        for (String s : stringArr) {
            System.out.print(s+" ");
        }

        Level h = Level.HARD;
        System.out.println("\n"+h);
    }


}
