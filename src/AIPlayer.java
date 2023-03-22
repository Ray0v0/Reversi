public class AIPlayer extends Player{
    int depth;
    public AIPlayer(int identity, int depth) {
        super(identity);
        this.depth = depth;
    }

    public int input(Board gameBoard) {
        gameBoard.checkChessPoint(getIdentity());
        return findBestChoice(gameBoard, gameBoard.getChessPointList(), gameBoard.getCountChessPoint());
    }

    private int findBestChoice(Board gameBoard, int[][] chessPointList, int countChessPoint) {
        int ret = 1;
        double maxValue = -2 * getIdentity();
        for (int i = 1; i <= countChessPoint; i++) {
            Board nextBoard = new Board(gameBoard);
            nextBoard.putChess(chessPointList[i][0], chessPointList[i][1], getIdentity());
//            nextBoard.printBoard();
            double value = alphaBeta(nextBoard, -1*getIdentity(), -2, 2, 0);
            if (getIdentity() * value > getIdentity() * maxValue) {
                maxValue = value;
                ret = i;
            }
        }
        System.out.println(ret);
        return ret;
    }

    private double alphaBeta(Board gameBoard, int nowPlayer, double alpha, double beta, int turn) {
        double ret;
        if (gameBoard.isEnd()) {
            ret = gameBoard.theWinner();
//        } else if (turn == depth) {
//            int[] count = gameBoard.countChess();
//            ret = (double) (count[1] - count[0]) / (gameBoard.getSize() * gameBoard.getSize());
        } else {
            gameBoard.checkChessPoint(nowPlayer);
            int[][] chessPointList = gameBoard.getChessPointList();
            int countChessPoint = gameBoard.getCountChessPoint();
            for (int i = 1; i <= countChessPoint; i++) {
                Board nextBoard = new Board(gameBoard);
                nextBoard.putChess(chessPointList[i][0], chessPointList[i][1], nowPlayer);
//                nextBoard.printBoard();
                double value = alphaBeta(nextBoard, -1 * nowPlayer, alpha, beta, turn + 1);
                if (nowPlayer == 1) {
                    if (value > alpha) {
                        alpha = value;
                    }
                } else {
                    if (value < beta) {
                        beta = value;
                    }
                }
                if (alpha <= beta) break;
            }
            if (nowPlayer == 1) {
                ret = alpha;
            } else {
                ret = beta;
            }
        }
        return ret;
    }
}
