public class Game {
    public static void main(String[] args) {
        Board gameBoard = new Board();
        Player[] players = new Player[2];
        players[0] = new HumanPlayer(-1);
        players[1] = new HumanPlayer(1);

        int nowPlayerIdentity = -1;
        int nowPlayerIndex = 0;
        boolean continuity = true;
        do {

            gameBoard.checkChessPoint(nowPlayerIdentity);
            if (continuity) {
                gameBoard.printBoard();
            }
            if (gameBoard.getCountChessPoint() != 0) {
                continuity = true;
                gameBoard.printChessPoint(nowPlayerIdentity);

                int[] input = gameBoard.getChessPointList(players[nowPlayerIndex].input(gameBoard));
                gameBoard.putChess(input[0], input[1], nowPlayerIdentity);

                nowPlayerIdentity = -nowPlayerIdentity;
                nowPlayerIndex = 1 - nowPlayerIndex;

            } else if (continuity){
                continuity = false;
            } else {
                break;
            }
        } while (true);

        System.out.println("Game is over!");
        int winner = gameBoard.theWinner();
        if (winner == -1) {
            System.out.println("The Winner is X!");
        } else if (winner == 1) {
            System.out.println("The Winner is O!");
        } else {
            System.out.println("Two Players draw!");
        }
    }
}
