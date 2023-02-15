package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_1149 {
	final static int RED = 0;
	final static int GREEN = 1;
	final static int BLUE = 2;

	static int[][] price;
	static int[][] dp;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		int N = Integer.parseInt(br.readLine()); // 집의 개수
		price = new int[N][3]; // 색 3가지
		dp = new int[N][3];

		String[] str = null;
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				price[i][j] = Integer.parseInt(str[j]);
			}
		}

		// 첫번째 집의 가격은 각 색상 비용의 첫번째 값
		dp[0][RED] = price[0][RED];
		dp[0][GREEN] = price[0][GREEN];
		dp[0][BLUE] = price[0][BLUE];

		System.out.println(Math.min(solution(N - 1, RED), Math.min(solution(N - 1, GREEN), solution(N - 1, BLUE))));
	}

	static int solution(int num, int color) {
		// 아직 가격 정해지지 않음
		if (dp[num][color] == 0) {
			if (color == RED)
				dp[num][RED] = Math.min(solution(num - 1, GREEN), solution(num - 1, BLUE)) + price[num][RED];
			else if (color == GREEN)
				dp[num][GREEN] = Math.min(solution(num - 1, RED), solution(num - 1, BLUE)) + price[num][GREEN];
			else
				dp[num][BLUE] = Math.min(solution(num - 1, RED), solution(num - 1, GREEN)) + price[num][BLUE];
		}

		return dp[num][color];
	}

}
