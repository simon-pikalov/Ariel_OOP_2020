enum Side {
    LIGHT,
    NUTRAL,
    DARK,
}

enum LightSaberColor {
    BLUE, GREEN, PURPLE, RED,
}

public interface ForceCharacters {

    Side get_side();
    String get_name();
    LightSaberColor get_LightSaberColor();
}
