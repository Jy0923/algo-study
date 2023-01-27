package recursion_function;

import java.util.Scanner;

public class Bk_2447 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++)
				recursion(i, j, num / 3);

			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void recursion(int x, int y, int num) {
		if ((x / num) % 3 == 1 && (y / num) % 3 == 1) // 가운데 공백 출력
			sb.append(" ");
		else {
			if (num == 1) // 더이상 나눌 수 없는 단위
				sb.append("*");
			else
				recursion(x, y, num / 3);
		}
	}

}
