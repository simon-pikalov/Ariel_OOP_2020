public class javaTricks {



    enum Rank {
        LIEUTENANT,
        CAPTAIN,
        MAJOR,
        COLONEL,
        GENERAL
    }

    public static void noEnumExample(){
        int rank = 2;

        switch (rank) {
            case 1:
                System.out.println("Lieutenant :*");
                break;
            case 2:
                System.out.println("Captain: **");
                break;
            case 3:
                System.out.println("Major :***");
                break;
            case 4:
                System.out.println("Colonel: ****");
                break;
            case 5:
                System.out.println("General *****");
                break;

            default:
                System.out.println("undefined");
        }

    }

    public static void EnumExample(){
        Rank rank = Rank.LIEUTENANT;

        switch (rank) {
            case LIEUTENANT:
                System.out.println("Lieutenant :*");
                break;
            case CAPTAIN:
                System.out.println("Captain: **");
                break;
            case MAJOR:
                System.out.println("Major :***");
                break;
            case COLONEL:
                System.out.println("Colonel: ****");
                break;
            case GENERAL:
                System.out.println("General *****");
                break;

            default:
                System.out.println("undefined");
        }

    }



    public static void main(String[] args) {

        double a = 1;
        double b = 2;
        double c = 3;

        int num = 1;
        double trick = (num % 2 == 0) ? 0 : 1;
        System.out.println(trick);

        String[] stringArr = {"\nThis","is","for","each",":)\n"};
        for (String s : stringArr) {
            System.out.print(s+" ");
        }
        System.out.println();

        noEnumExample();
        EnumExample();

    }


}
