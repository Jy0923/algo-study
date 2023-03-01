package dac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk_2740 {

	static int N, M, K;
	static int[][] arr1;
	static int[][] arr2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		arr1 = new int[N][M];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr1[i][j] = Integer.parseInt(input[j]);
			}
		}

		input = br.readLine().split(" ");
		K = Integer.parseInt(input[1]);

		arr2 = new int[M][K];
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < K; j++) {
				arr2[i][j] = Integer.parseInt(input[j]);
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < K; y++) {
				int a = 0;
				for (int z = 0; z < M; z++) {
					a += arr1[x][z] * arr2[z][y];
				}
				sb.append(a + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
