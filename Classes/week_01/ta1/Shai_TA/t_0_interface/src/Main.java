import java.util.ArrayList;

import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {
        out.println("A long time ago in a galaxy far, far away...");

//        ArrayList<Jedi> jedi_arr = new ArrayList<>();
//        jedi_arr.add(new Jedi("Luke SkyWalker", LightSaberColor.BLUE, JediRank.MASTER));
//        jedi_arr.add(new Jedi("Anakin SkyWalker", LightSaberColor.BLUE, JediRank.KNIGHT));
//        jedi_arr.add(new Jedi("Yoda", LightSaberColor.GREEN, JediRank.MASTER));
//
//        ArrayList<Sith> sith_arr = new ArrayList<>();
//        sith_arr.add(new Sith("Darth Vader", LightSaberColor.RED, SithRanks.LORD));
//        sith_arr.add(new Sith("Darth Plagueis", LightSaberColor.RED, SithRanks.LORD));
//        sith_arr.add(new Sith("Revan", LightSaberColor.RED, SithRanks.ACOLYTE));
//
//        out.println("The Jedis");
//        out.println("===========");
//
//        for (Jedi jedi :jedi_arr) {
//            out.println(jedi);
//        }
//
//        out.println("The Siths");
//        out.println("===========");
//
//        for (Sith sith :sith_arr) {
//            out.println(sith);
//        }

        ArrayList<ForceChar> forceChars = new ArrayList<>();
        forceChars.add(new Jedi("Luke SkyWalker", LightSaberColor.BLUE, JediRank.MASTER));
        forceChars.add(new Jedi("Anakin SkyWalker", LightSaberColor.BLUE, JediRank.KNIGHT));
        forceChars.add(new Jedi("Yoda", LightSaberColor.GREEN, JediRank.MASTER));

        forceChars.add(new Sith("Darth Vader", LightSaberColor.RED, SithRanks.LORD));
        forceChars.add(new Sith("Darth Plagueis", LightSaberColor.RED, SithRanks.LORD));
        forceChars.add(new Sith("Revan", LightSaberColor.RED, SithRanks.ACOLYTE));

        out.println("The Force People");
        out.println("===========");

        for (ForceChar fc : forceChars) {
            out.println(fc);
        }
    }
}
