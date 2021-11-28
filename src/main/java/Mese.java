public enum Mese {
    GENNAIO("A"),
    FEBBRAIO("B"),
    MARZO("C"),
    APRILE("D"),
    MAGGIO("E"),
    GIUGNO("H"),
    LUGLIO("L"),
    AGOSTO("M"),
    SETTEMBRE("P"),
    OTTOBRE("R"),
    NOVEMBRE("S"),
    DICEMBRE("T");

    final private String carattere;

    Mese(String carattere) {
        this.carattere = carattere;
    }

    public String getCarattere() {
        return this.carattere;
    }
}

