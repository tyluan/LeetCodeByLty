package programming.art;

/**
 * Sudoku solver
 * 
 * @author softsec
 * 
 */
public class LeetCode37 {
	 public void solveSudoku(char[][] board) {
			solve(board);

		}

		private boolean solve(char[][] board) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (board[i][j] == '.') {
						for (char k = '1'; k <= '9'; k++) {
							board[i][j] = k;
							if (isValid(board, i, j) && solve(board))
								return true;
							board[i][j] = '.';
						}
						return false;
					}
				}
			}
			return true;
		}

		private boolean isValid(char[][] board, int x, int y) {
			for (int i = 0; i < 9; i++) {
				if (y != i && board[x][y] == board[x][i])
					return false;
				if (x != i && board[x][y] == board[i][y])
					return false;
			}
			for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {  
	            for (int j = (y /3) * 3; j < (y / 3) *3 + 3; j++) {  
	                if (x != i && y != j && board[i][j] == board[x][y]) {  
	                    return false;  
	                }  
	            }  
	        }  
			return true;
		}
}
