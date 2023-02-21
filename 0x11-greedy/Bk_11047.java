package greedy;

import java.io.IOException;
import java.util.Scanner;

public class Bk_11047 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int price = sc.nextInt();

		int[] coin = new int[N];

		// 동전 가치 입력
		for (int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		}

		int temp = price;
		// 전체 동전 개수
		int total = 0;
		// price를 동전 가치로 나눈 몫
		int quotient = 0;

		// 뒤에서부터 탐색 - 최대값 먼저 탐색
		for (int i = N - 1; i >= 0; i--) {

			// price가 0이 되면 break
			if (temp == 0)
				break;

			quotient = temp / coin[i];

			// 몫이 0이 아니다 = 현재 적용 가능한 동전 가치 최댓값
			if (quotient > 0) {
				// 동전 개수 누적
				total += quotient;
				// 나머지
				temp %= coin[i];
			}

		}

		System.out.println(total);
	}

}
