public class Player {
    private final int identity;
    public Player(int identity) {
        this.identity = identity;
    }

    public int getIdentity() {
        return identity;
    }

    public int input(Board gameBoard) {
        return 0;
    }
}
