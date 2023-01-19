import java.util.Scanner;


public class Bk_1475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[9];

		int max = 0;

		while (N > 0) {
			int a = N % 10;
			if (a == 6 || a == 9) {
				arr[6]++;
			} else
				arr[a]++;

			N /= 10;
		}

		arr[6] = (arr[6] + 1) / 2;

		for (int a : arr) {
			if (a > max)
				max = a;
		}
		System.out.println(max);
	}

}
