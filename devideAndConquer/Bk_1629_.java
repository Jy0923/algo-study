package dac;

import java.util.Scanner;

public class Bk_1629_ {
	static long A, B, mod;

	static long solution(long a, long b) {
		if (b == 0)
			return 1;
		if (b == 1)
			return a % mod;

		long temp = solution(a, b / 2);

		if (b % 2 == 0) // 짝수 승이라면
			return (temp * temp) % mod;
		else
			return ((temp * temp) % mod) * a % mod;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		A = sc.nextLong();
		B = sc.nextLong();
		mod = sc.nextLong();

		System.out.println(solution(A, B));
		
	}
}
