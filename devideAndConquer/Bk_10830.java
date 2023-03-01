package dac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_10830 {
	// 행렬의 크기
	static int N;
	// 제곱 수
	static long B;
	// 주어진 행렬
	static int[][] arr;

	// 정답 행렬
	static int[][] answer;

	// 나머지 연산 수
	static int mod = 1000;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// public static
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		B = Long.parseLong(input[1]);

		arr = new int[N][N];
		answer = new int[N][N];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(input[j]) % mod;
			}
		}

		answer = solution(arr, B);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(answer[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}

	public static int[][] solution(int[][] A, long b) {
		if (b == 1L)
			return A;

		int[][] ans = solution(A, b / 2);

		ans = multyply(ans, ans);

		if (b % 2 == 1L) {
			ans = multyply(ans, arr);
		}

		return ans;
	}

	public static int[][] multyply(int[][] arr1, int[][] arr2) {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					temp[i][j] += arr1[i][k] * arr2[k][j];
					temp[i][j] %= mod;
				}
			}
		}
		return temp;
	}
}
