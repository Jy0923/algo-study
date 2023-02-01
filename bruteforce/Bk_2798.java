package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_2798 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]); // 카드 갯수
		int M = Integer.parseInt(str[1]); // 카드 합

		int result = 0; // M과 가장 가까우면서, M을 넘지 않는 값

		String[] card = br.readLine().split(" ");
		int[] cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(card[i]);
		}

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;

				for (int z = 0; z < N; z++) {
					if (j == z || i == z)
						continue;

					int sum = cards[i] + cards[j] + cards[z];

					if (sum <= M && sum > result)
						result = sum;

				}
			}
		}
		System.out.println(result);
	}

}
