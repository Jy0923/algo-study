package bruteforce;

import java.util.Scanner;

public class Bk_1436 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Integer temp = 665;
		int result = 0;

		int cnt = 0;

		while (cnt != N) {

			if (temp.toString().contains("666")) {
				cnt++;
				result = temp;
			}
			temp++;
		}

		System.out.println(result);

	}
}
