import java.util.Scanner;

public class HumanPlayer extends Player{


    public HumanPlayer(int identity) {
        super(identity);
    }

    public int input(Board gameBoard) {
        Scanner in = new Scanner(System.in);
        int ret = 0;
        boolean isInputLegal = true;
        do {
            if (!isInputLegal) {
                System.out.println("Input is not illegal! Please try again: ");
            }
            System.out.print("Select: ");
            if (in.hasNextInt()) {
                ret = in.nextInt();
                isInputLegal = (ret > 0 && ret <= gameBoard.getCountChessPoint());
            } else {
                isInputLegal = false;
            }

//            System.out.print("Row Col: ");
//            ret[0] = in.nextInt();
//            ret[1] = in.nextInt();
//            isInputLegal = (ret[0] > 0 && ret[0] <= gameBoard.getSize() && ret[1] > 0 && ret[1] <= gameBoard.getSize() && gameBoard.isLegal(ret[0], ret[1], getIdentity()));
        } while (!isInputLegal);
        return ret;
    }
}
