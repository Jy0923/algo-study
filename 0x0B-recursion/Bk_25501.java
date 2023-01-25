package recursion_function;

import java.util.Scanner;

public class Bk_25501 {

	static int cycle = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			String s = sc.next();
			cycle = 0;
			sb.append(recursion(s, 0, s.length() - 1) + " " + cycle + "\n");
		}
		System.out.println(sb);

	}

	public static int recursion(String s, int l, int r) {
		cycle++;
		if (l >= r)
			return 1;
		else if (s.charAt(l) != s.charAt(r))
			return 0;
		else
			return recursion(s, l + 1, r - 1);
	}

}
