
enum SithRanks{
    ACOLYTE,
    MASTER,
    LORD,
    DARKCOUNCIL
}

public class Sith implements ForceChar{
    private String _name;
    private LightSaberColor _ls_color;
    private SithRanks _rank;

    public Sith(String name, LightSaberColor ls_color, SithRanks rank) {
        _name = name;
        _ls_color = ls_color;
        _rank = rank;
    }

    @Override
    public String toString() {
        return getName() + "\n"
                + "\tRank: " + rankStr()+"\n"
                + "\tLightSaber Color:" + getLightSaberColor();
    }

    @Override
    public String getName() {
        return "Sith " + _name;
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
