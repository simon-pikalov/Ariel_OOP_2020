class GrayJedi extends Jedi {
    GrayJedi(String name, LightSaberColor ls_color, JediRank j_rank) {
        super(name, ls_color, j_rank);
        _side = Side.NUTRAL;
    }
}
