
enum SithRanks{
    ACOLYTE,
    MASTER,
    LORD,
    DARKCOUNCIL
}

public class Sith implements ForceCharacters{
    private String _name;
    private LightSaberColor _ls_color;
    private SithRanks _rank;
    private Side _side;

    Sith(String name, LightSaberColor ls_color, SithRanks rank) {
        _name = name;
        _ls_color = ls_color;
        _rank = rank;
        _side = Side.DARK;
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
