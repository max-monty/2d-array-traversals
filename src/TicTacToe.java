public class TicTacToe {
    private int[][] board; // 3x3 board, 0 for empty, 1 for X, 2 for O
    private int currentPlayer; // 1 for X, 2 for O

    public TicTacToe() {
        board = new int[3][3];
        currentPlayer = 1;
    }

    public void play(int row, int col) {
        if(board[row][col] != 0) {
            System.out.println("Cell already occupied");
            return;
        } else {
            board[row][col] = currentPlayer;
            if(currentPlayer == 1) {
                currentPlayer = 2;
            } else {
                currentPlayer = 1;
            }
        }
    }

    public boolean isGameOver() {
        if(getWinner() != 0) {
            return true;
        } else if(isBoardFull()) {
            return true;
        } else {
            return false;
        }
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int getWinner() {
        // check rows
        for(int i = 0; i < 3; i++) {
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != 0) {
                return currentPlayer;
            }
        }
        // check columns
        for(int i = 0; i < 3; i++) {
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != 0) {
                return currentPlayer;
            }
        }
        // check diagonals
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0) {
            return currentPlayer;
        }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0) {
            return currentPlayer;
        }
        return 0;
    }

    public boolean isBoardFull() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == 0) {
                    System.out.print("-");
                } else if(board[i][j] == 1) {
                    System.out.print("X");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }
}