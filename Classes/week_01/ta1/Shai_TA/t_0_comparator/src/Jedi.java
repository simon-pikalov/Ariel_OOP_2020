enum JediRank {
    INITIATE,
    PADWAN,
    MASTER,
    KNIGHT
}

public class Jedi implements ForceCharacters {
    private String _name;
    private LightSaberColor _ls_color;
    private JediRank _rank;
    protected Side _side;

    Jedi(String name, LightSaberColor ls_color, JediRank j_rank) {
        _name = name;
        _ls_color = ls_color;
        _rank = j_rank;
        _side = Side.LIGHT;
    }

    @Override
    public String toString() {
        return _name + "\n"
                + "\tRank: " + _rank+"\n"
                + "\tLightSaber Color:" + _ls_color;
    }

    @Override
    public Side get_side() {
        return _side;
    }

    @Override
    public String get_name() {
        return _name;
    }

    @Override
    public LightSaberColor get_LightSaberColor() {
        return _ls_color;
    }
}
