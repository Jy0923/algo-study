package recursion_function;

import java.util.Scanner;

public class Bk_10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(multiple(N));

	}

	static int multiple(int N) {
		if (N != 0)
			return N * multiple(N - 1);
		else
			return 1;
	}
	
}
