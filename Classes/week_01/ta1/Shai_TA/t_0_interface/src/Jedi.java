
enum JediRank {
    INITIATE,
    PADWAN,
    MASTER,
    KNIGHT
}

public class Jedi implements ForceChar {
    private String _name;
    private LightSaberColor _ls_color;
    private JediRank _rank;

    public Jedi(String name, LightSaberColor ls_color, JediRank j_rank) {
        _name = name;
        _ls_color = ls_color;
        _rank = j_rank;
    }

    @Override
    public String toString() {
        return getName() + "\n"
                + "\tRank: " + rankStr()+"\n"
                + "\tLightSaber Color:" + getLightSaberColor();
    }

    @Override
    public String getName() {
        return "Jedi " + _name;
    }

    @Override
    public LightSaberColor getLightSaberColor() {
        return _ls_color;
    }

    @Override
    public String rankStr() {
        return _rank.name();
    }
}
