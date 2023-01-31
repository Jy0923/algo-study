import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] board = new char[row][col];

		for (int i = 0; i < row; i++) {
			String str = br.readLine();

			for (int j = 0; j < col; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		int min = 2500;

		// col은 0부터 col-8까지

		// row는 0부터 row-8까지
		for (int r = 0; r <= (row - 8); r++) {
			for (int c = 0; c <= (col - 8); c++) {
				// 8x8 배열 새롭게 선언
				char[][] chessBoard = new char[8][8];
				for (int len = r; len < r + 8; len++) {
					for (int wid = c; wid < c + 8; wid++) {
						chessBoard[len - r][wid - c] = board[len][wid];
					}
				}
				// System.out.println(Arrays.deepToString(chessBoard));
				int s = same(chessBoard);
				int o = opposite(chessBoard);
				// System.out.println(s);
				// System.out.println(o);
				if (s < min) {
					min = s;
				} else if (o < min) {
					min = o;
				}

			}

		}
		System.out.println(min);
	}

	public static int same(char[][] chessBoard) {
		int cnt = 0;
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 7; c++) {
				// r이 0이 아니고, c가 0이며, 위 보드색과 아래 보드색이 같을 경우 아래 보드색을 변경
				if ((r != 0) && (c == 0) && (chessBoard[r][c] == chessBoard[r - 1][c])) {
					if (chessBoard[r - 1][c] == 'B') {
						chessBoard[r][c] = 'W';
						cnt++;
					} else if (chessBoard[r - 1][c] == 'W') {
						chessBoard[r][c] = 'B';
						cnt++;
					}
				}

				if (chessBoard[r][c] == chessBoard[r][c + 1]) {
					if (chessBoard[r][c] == 'B') {
						chessBoard[r][c + 1] = 'W';
						cnt++;
					} else if (chessBoard[r][c] == 'W') {
						chessBoard[r][c + 1] = 'B';
						cnt++;
					}
				}
			}
		}
		// System.out.println(Arrays.deepToString(chessBoard));
		return cnt;
	}

	public static int opposite(char[][] chessBoard) {
		int cnt = 0;
		if (chessBoard[0][0] == 'B') {
			chessBoard[0][0] = 'W';
			cnt++;
		} else if (chessBoard[0][0] == 'W') {
			chessBoard[0][0] = 'B';
			cnt++;
		}

		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 7; c++) {
				// r이 0이 아니고, c가 0이며, 위 보드색과 아래 보드색이 같을 경우 아래 보드색을 변경

				if ((r != 0) && (c == 0) && (chessBoard[r][c] == chessBoard[r - 1][c])) {
					if (chessBoard[r - 1][c] == 'B') {
						chessBoard[r][c] = 'W';
						cnt++;
					} else if (chessBoard[r - 1][c] == 'W') {
						chessBoard[r][c] = 'B';
						cnt++;
					}
				}

				if (chessBoard[r][c] == chessBoard[r][c + 1]) {
					if (chessBoard[r][c] == 'B') {
						chessBoard[r][c + 1] = 'W';
						cnt++;
					} else if (chessBoard[r][c] == 'W') {
						chessBoard[r][c + 1] = 'B';
						cnt++;
					}
				}
			}
		}
		// System.out.println(Arrays.deepToString(chessBoard));
		return cnt;
	}

}

// 첫 색깔을 바꾸는 opposite 함수에서 cnt에 문제가 있는데 뭔지 잘 모르겠네요...
