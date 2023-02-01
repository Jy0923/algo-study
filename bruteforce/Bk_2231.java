package brute_force;

import java.util.Scanner;

public class Bk_2231 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 주어진 값
		int N = sc.nextInt();
		// 생성자
		int M = 0;

		int result = 0;
		int num = 0;
		for (int i = 1; i < N; i++) {
			result = i;
			num = i;
			
			while (num > 0) {
				result += num % 10;
				num /= 10;
			}

			if (result == N) {
				M = i; // 생성자 최소값
				break;
			}
		}

		System.out.println(M);
	}

}
