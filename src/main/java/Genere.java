public enum Genere {
    UOMO(0),
    DONNA(40);

    final private int offset;

    Genere(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }
}
