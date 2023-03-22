
public class Board {
    private final int size = 8;
    private int countChessPoint;
    private int[][] storage = new int[size + 2][size + 2];
    private boolean[][] storageChessPoint = new boolean[size + 2][size + 2];
    private int[][] chessPointList = new int[size * size + 2][2];
    public Board() {
        storage[4][4] = 1;
        storage[4][5] = -1;
        storage[5][4] = -1;
        storage[5][5] = 1;
    }
    public Board(Board gameBoard) {
        for (int i = 1; i <= size; i++) {
            this.storage[i] = gameBoard.storage[i].clone();
        }
    }
    public int getSize() {
        return size;
    }
    public int getCountChessPoint() {
        return countChessPoint;
    }
    public int[] getChessPointList(int index) {
        int[] ret = new int[2];
        ret[0] = chessPointList[index][0];
        ret[1] = chessPointList[index][1];
        return ret;
    }
    public int[][] getChessPointList() {
        return chessPointList;
    }
    public int getStorage(int x, int y) {
        return storage[x][y];
    }
    public void putChess(int x, int y, int identity) {
        if (isLegal(x, y ,identity)) {
            storage[x][y] = identity;
            step(x, y, identity);
        } else {
            System.out.println("Error: the chess point is illegal!");
        }
    }
    public void step(int x, int y, int identity) {
        if (isLegalDown(x, y , identity)) {
            stepDown(x, y, identity);
        }
        if (isLegalUp(x, y , identity)) {
            stepUp(x, y, identity);
        }
        if (isLegalLeft(x, y , identity)) {
            stepLeft(x, y, identity);
        }
        if (isLegalRight(x, y , identity)) {
            stepRight(x, y, identity);
        }
        if (isLegalUpLeft(x, y , identity)) {
            stepUpLeft(x, y, identity);
        }
        if (isLegalUpRight(x, y , identity)) {
            stepUpRight(x, y, identity);
        }
        if (isLegalDownLeft(x, y , identity)) {
            stepDownLeft(x, y, identity);
        }
        if (isLegalDownRight(x, y , identity)) {
            stepDownRight(x, y, identity);
        }
    }
    public void stepLeft(int x, int y, int identity) {
        for (int i = 1; i < size; i++) {
            if (storage[x][y - i] == identity) {
                break;
            } else {
                storage[x][y - i] = identity;
            }
        }
    }
    public void stepRight(int x, int y, int identity) {
        for (int i = 1; i < size; i++) {
            if (storage[x][y + i] == identity) {
                break;
            } else {
                storage[x][y + i] = identity;
            }
        }
    }
    public void stepUp(int x, int y, int identity) {
        for (int i = 1; i < size; i++) {
            if (storage[x - i][y] == identity) {
                break;
            } else {
                storage[x - i][y] = identity;
            }
        }
    }
    public void stepDown(int x, int y, int identity) {
        for (int i = 1; i < size; i++) {
            if (storage[x + i][y] == identity) {
                break;
            } else {
                storage[x + i][y] = identity;
            }
        }
    }
    public void stepUpRight(int x, int y, int identity) {
        for (int i = 1; i < size; i++) {
            if (storage[x - i][y + i] == identity) {
                break;
            } else {
                storage[x - i][y + i] = identity;
            }
        }
    }
    public void stepUpLeft(int x, int y, int identity) {
        for (int i = 1; i < size; i++) {
            if (storage[x - i][y - i] == identity) {
                break;
            } else {
                storage[x - i][y - i] = identity;
            }
        }
    }
    public void stepDownLeft(int x, int y, int identity) {
        for (int i = 1; i < size; i++) {
            if (storage[x + i][y - i] == identity) {
                break;
            } else {
                storage[x + i][y - i] = identity;
            }
        }
    }
    public void stepDownRight(int x, int y, int identity) {
        for (int i = 1; i < size; i++) {
            if (storage[x + i][y + i] == identity) {
                break;
            } else {
                storage[x + i][y + i] = identity;
            }
        }
    }
    public boolean isLegalLeft(int x, int y, int identity) {
        boolean ret = false;
        for (int i = 1; i <= size; i++) {
            if (y - i < 1) {
                ret = false;
                break;
            } else if (storage[x][y - i] == -identity) {
                ret = true;
            } else if (storage[x][y - i] == identity && ret) {
                break;
            } else {
                ret = false;
                break;
            }
        }
        return ret;
    }
    public boolean isLegalRight(int x, int y, int identity) {
        boolean ret = false;
        for (int i = 1; i <= size; i++) {
            if (y + i > size) {
                ret = false;
                break;
            } else if (storage[x][y + i] == -identity) {
                ret = true;
            } else if (storage[x][y + i] == identity && ret) {
                break;
            } else {
                ret = false;
                break;
            }
        }
        return ret;
    }
    public boolean isLegalUp(int x, int y, int identity) {
        boolean ret = false;
        for (int i = 1; i <= size; i++) {
            if (x - i < 1) {
                ret = false;
                break;
            } else if (storage[x - i][y] == -identity) {
                ret = true;
            } else if (storage[x - i][y] == identity && ret) {
                break;
            } else {
                ret = false;
                break;
            }
        }
        return ret;
    }
    public boolean isLegalDown(int x, int y, int identity) {
        boolean ret = false;
        for (int i = 1; i <= size; i++) {
            if (x + i > size) {
                ret = false;
                break;
            } else if (storage[x + i][y] == -identity) {
                ret = true;
            } else if (storage[x + i][y] == identity && ret) {
                break;
            } else {
                ret = false;
                break;
            }
        }
        return ret;
    }
    public boolean isLegalUpRight(int x, int y, int identity) {
        boolean ret = false;
        for (int i = 1; i <= size; i++) {
            if (y + i > size || x - i < 1) {
                ret = false;
                break;
            } else if (storage[x - i][y + i] == -identity) {
                ret = true;
            } else if (storage[x - i][y + i] == identity && ret) {
                break;
            } else {
                ret = false;
                break;
            }
        }
        return ret;
    }
    public boolean isLegalUpLeft(int x, int y, int identity) {
        boolean ret = false;
        for (int i = 1; i <= size; i++) {
            if (y - i < 1 || x - i < 1) {
                ret = false;
                break;
            } else if (storage[x - i][y - i] == -identity) {
                ret = true;
            } else if (storage[x - i][y - i] == identity && ret) {
                break;
            } else {
                ret = false;
                break;
            }
        }
        return ret;
    }
    public boolean isLegalDownRight(int x, int y, int identity) {
        boolean ret = false;
        for (int i = 1; i <= size; i++) {
            if (y + i > size || x + i > size) {
                ret = false;
                break;
            } else if (storage[x + i][y + i] == -identity) {
                ret = true;
            } else if (storage[x + i][y + i] == identity && ret) {
                break;
            } else {
                ret = false;
                break;
            }
        }
        return ret;
    }
    public boolean isLegalDownLeft(int x, int y, int identity) {
        boolean ret = false;
        for (int i = 1; i <= size; i++) {
            if (y - i < 1 || x + i > size) {
                ret = false;
                break;
            } else if (storage[x + i][y - i] == -identity) {
                ret = true;
            } else if (storage[x + i][y - i] == identity && ret) {
                break;
            } else {
                ret = false;
                break;
            }
        }
        return ret;
    }

//    public boolean isSideBySide(int x, int y, int identity) {
//        return storage[x + 1][y] == -identity || storage[x - 1][y] == -identity ||
//                storage[x][y + 1] == -identity || storage[x][y - 1] == -identity ||
//                storage[x + 1][y + 1] == -identity || storage[x + 1][y - 1] == -identity ||
//                storage[x - 1][y + 1] == -identity || storage[x - 1][y - 1] == -identity;
//    }

    public boolean isLegal(int x, int y, int identity) {
        return (isLegalRight(x, y ,identity) || isLegalLeft(x, y ,identity)
                || isLegalUp(x, y ,identity) || isLegalDown(x, y ,identity)
                || isLegalUpRight(x, y ,identity) || isLegalDownRight(x, y ,identity)
                || isLegalUpLeft(x, y ,identity) || isLegalDownLeft(x, y ,identity));
    }
    public void printBoard() {
        System.out.print("   ");
        for (int i = 1; i <= size; i++) {
            System.out.printf(" %d ", i);
        }
        System.out.println();
        for (int i = 1; i <= size; i++) {
            System.out.printf(" %d ", i);
            for (int j = 1; j <= size; j++) {
                String s;
                if (storage[i][j] == -1) {
                    s = "\033[97;1m X \033[0;0m";
                } else if (storage[i][j] == 1) {
                    s = "\033[0;0m O \033[0;0m";
                } else if (storageChessPoint[i][j]){
                    s = "\033[41m E \033[0m";
                    for (int k = 1; k <= countChessPoint; k++) {
                        if (chessPointList[k][0] == i && chessPointList[k][1] == j) {
                            s = "\033[47m " + k;
                            if (k < 10) s += " ";
                            s += "\033[0m";
                            break;
                        }
                    }
                } else {
                    s = "\033[47m . \033[0m";
                }
                System.out.print(s);
            }
            System.out.println();
        }
    }
    public void checkChessPoint(int identity) {

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                storageChessPoint[i][j] = false;
            }
        }
        for (int i = 1; i <= size * size; i++) {
            chessPointList[i][0] = 0;
            chessPointList[i][1] = 0;
        }

        countChessPoint = 0;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (storage[i][j] == 0 && isLegal(i, j, identity)) {
                    storageChessPoint[i][j] = true;
                    countChessPoint++;
                    chessPointList[countChessPoint][0] = i;
                    chessPointList[countChessPoint][1] = j;
                }
            }
        }
    }
    public int[] countChess() {
        int countBlack = 0, countWhite = 0;
        int[] ret = new int[2];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (storage[i][j] == -1) {
                    countBlack++;
                } else if (storage[i][j] == 1) {
                    countWhite++;
                }
            }
        }
        ret[0] = countBlack;
        ret[1] = countWhite;
        return ret;
    }
    public int theWinner() {
        int ret = 0;
        int[] count = countChess();
        int countBlack = count[0];
        int countWhite = count[1];
        if (countBlack > countWhite) {
            ret = -1;
        } else if (countBlack < countWhite) {
            ret = 1;
        }
        return ret;
    }
    public boolean isEnd() {
        boolean ret = false;
        int countChessPointBlack, countChessPointWhite;
        checkChessPoint(-1);
        countChessPointBlack = countChessPoint;
        checkChessPoint(1);
        countChessPointWhite = countChessPoint;
        if (countChessPointBlack == 0 && countChessPointWhite == 0) {
            ret = true;
        }
        return ret;
    }
    public void printChessPoint(int identity) {

        char c;
        if (identity == -1) {
            c = 'X';
        } else {
            c = 'O';
        }
        System.out.printf("Chess %c can be put on:", c);
        for (int i = 1; i <= countChessPoint; i++) {
            if (i % 4 == 1) System.out.println();
            System.out.printf("%d. (%d, %d)\t", i, chessPointList[i][0], chessPointList[i][1]);
        }
        System.out.println();
//        for (int i = 1; i <= size; i++) {
//            for (int j = 1; j <= size; j++) {
//                if (storageChessPoint[i][j]) {
//                    System.out.printf("(%d, %d)\n", i, j);
//                }
//            }
//        }
    }
    public static void main(String[] args) {
        Board testBoard = new Board();
        testBoard.checkChessPoint(-1);
        testBoard.printBoard();
        testBoard.printChessPoint(-1);
        testBoard.putChess(3, 4, -1);
        testBoard.checkChessPoint(1);
        testBoard.printBoard();
        testBoard.printChessPoint(1);
        testBoard.putChess(5, 3, 1);
        testBoard.checkChessPoint(-1);
        testBoard.printBoard();
        testBoard.printChessPoint(-1);
    }
}
