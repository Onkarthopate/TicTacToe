import java.util.Scanner;

public class TicTacToe {
	//board
	
    private static char[][] board;
	
	//current player
	
    private static char currPlayer;
	

    public static void main(String[] args) {
		
        boolean playAgain = true;
		
        while (playAgain) {
            board = new char[3][3];
            currPlayer = 'X';
            inti_board();

            while (true) {
                printBoard();
                playerMove();
				
                if (checkWin()) {
                    printBoard();
                    System.out.println("Player " + currPlayer + " wins!");
                    break;
                }
                if (isBoardFull()) {
                    printBoard();
                    System.out.println("The game is a draw!");
                    break;
                }
                switchPlayer();
            }

            // Ask user if they want to play again
			
            Scanner scanner = new Scanner(System.in);
			
            System.out.println("Do you want to play again? (y/n)");
			
            char playAgainInput = scanner.next().charAt(0);
			
            playAgain = playAgainInput == 'y' || playAgainInput == 'Y';
			
			if(playAgain){
				System.out.println("\nStart Again!");
			}
			
        }
    }

    private static void inti_board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        System.out.println(".........\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(".........\n");
    }

    private static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        while (true) {
            System.out.println("Player " + currPlayer + ", your turn (row  column): ");
            row = scanner.nextInt() - 1;  // Adjust for 1-based indexing
            col = scanner.nextInt() - 1; // Adjust for 1-based indexing
			
            if (row >= 0 && col >= 0 && row < 3 && col < 3 && board[row][col] == '-') {
               
			   board[row][col] = currPlayer;
               
			   break;
            } 
			else {
                // error message
                System.out.println("Invalid row or column. Please enter a number between 1 and 3.");
            }
        }
    }

    private static void switchPlayer() {
		//ternary operator 
		
        currPlayer = (currPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean checkWin() {
		
        // Check rows and columns
		
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currPlayer && board[i][1] == currPlayer && board[i][2] == currPlayer) ||
                    (board[0][i] == currPlayer && board[1][i] == currPlayer && board[2][i] == currPlayer)) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == currPlayer && board[1][1] == currPlayer && board[2][2] == currPlayer) ||
                (board[0][2] == currPlayer && board[1][1] == currPlayer && board[2][0] == currPlayer)) {
            return true;
        }

        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
