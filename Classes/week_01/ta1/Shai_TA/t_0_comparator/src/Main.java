import java.util.ArrayList;

import static java.lang.System.out;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        out.println("A long time ago in a galaxy far, far away...");

        ArrayList<ForceCharacters> fc_arr = new ArrayList<>();
        fc_arr.add(new Jedi("Yoda", LightSaberColor.GREEN, JediRank.MASTER));
        fc_arr.add(new Sith("Revan", LightSaberColor.RED, SithRanks.ACOLYTE));
        fc_arr.add(new Jedi("Anakin SkyWalker", LightSaberColor.BLUE, JediRank.KNIGHT));
        fc_arr.add(new GrayJedi("Jolee Bindo", LightSaberColor.BLUE, JediRank.MASTER));
        fc_arr.add(new Sith("Darth Plagueis", LightSaberColor.RED, SithRanks.LORD));
        fc_arr.add(new Jedi("Mace Windu", LightSaberColor.PURPLE, JediRank.MASTER));
        fc_arr.add(new Jedi("Luke SkyWalker", LightSaberColor.BLUE, JediRank.MASTER));
        fc_arr.add(new Sith("Darth Vader", LightSaberColor.RED, SithRanks.LORD));

        fc_arr.sort(new ForceComp());
//        fc_arr.sort(new JediLightSaberComp());
//        fc_arr.sort(new JediNameComp());
        out.println("The Force Characters");
        out.println("===========");
        for (ForceCharacters force_char :
                fc_arr
                ) {
            Side fc_side = force_char.get_side();
            switch (fc_side) {
                case LIGHT:
                    out.println(ANSI_BLUE + force_char.get_name() + ANSI_RESET);
                    break;
                case DARK:
                    out.println(ANSI_RED + force_char.get_name() + ANSI_RESET);
                    break;
                case NUTRAL:
                    out.println(ANSI_WHITE + force_char.get_name() + ANSI_RESET);
                    break;
            }
        }
    }
}
