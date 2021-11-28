public enum CarattereDispari {

    A(1),
    B(0),
    C(5),
    D(7),
    E(9),
    F(13),
    G(15),
    H(17),
    I(19),
    J(21),
    K(2),
    L(4),
    M(18),
    N(20),
    O(11),
    P(3),
    Q(6),
    R(8),
    S(12),
    T(14),
    U(16),
    V(10),
    W(22),
    X(25),
    Y(24),
    Z(23);


    final private int valore;

    CarattereDispari(int valore) {
        this.valore = valore;
    }

    public int getValore() {
        return this.valore;
    }
}
