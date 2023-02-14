import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] board;
	static int[][] SumBoard;
	static int x1;
	static int x2;
	static int y1;
	static int y2;
	static int sum;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][n];
		SumBoard = new int[n][n];

		// 크기 n * n의 보드를 생성한다.
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 보드의 가로 누적합을 담는 SumBoard를 채운다.
		for (int i = 0; i < n; i++) {

			// sum의 값을 초기화하고
			sum = 0;
			for (int j = 0; j < n; j++) {
				sum += board[i][j];
				SumBoard[i][j] += sum;
			}
		}

		// m만큼의 연산이 주어진다.
		for (int i = 0; i < m; i++) {
			result = 0;
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken()) - 1;
			y1 = Integer.parseInt(st.nextToken()) - 1;
			x2 = Integer.parseInt(st.nextToken()) - 1;
			y2 = Integer.parseInt(st.nextToken()) - 1;


			// x1부터 x2까지
			// y2부터 y1-1을 빼는 연산을 반복한다.
			for (int idx = x1; idx <= x2; idx++) {
				

				// y1가 0일 때는 y2를 더한다.
				if (y1 == 0) {
					result += SumBoard[idx][y2];
				} else if (y1 == y2) {

					// y1과 y2가 같다면
					// 원래 배열에서의 값을 더한다.
					result += board[idx][y1];
				} else {

					// 그게 아니라면 y2에서 y1-1을 뺀다.
					result += SumBoard[idx][y2] - SumBoard[idx][y1-1];
				}

			}
			
			sb.append(result + "\n");

		}
		System.out.println(sb);

	}
}
