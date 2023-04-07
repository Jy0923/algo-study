package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_1991 {

	static StringBuilder sb;
	static BufferedReader br;

	static int N;

	static int[] left;
	static int[] right;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		left = new int[N + 1];
		right = new int[N + 1];

		String[] input = null;

		char c = '\u0000', l = '\u0000', r = '\u0000';
		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");

			c = input[0].charAt(0);

			l = input[1].charAt(0);
			if (l != '.')
				left[c - 'A' + 1] = l - 'A' + 1;
			r = input[2].charAt(0);
			if (r != '.')
				right[c - 'A' + 1] = r - 'A' + 1;
		}

		preOrder(1);
		System.out.println();
		inOrder(1);
		System.out.println();
		postOrder(1);
	}

	private static void preOrder(int cur) {

		System.out.print((char) (cur + 'A' - 1));
		if (left[cur] != 0)
			preOrder(left[cur]);
		if (right[cur] != 0)
			preOrder(right[cur]);
	}

	private static void inOrder(int cur) {
		if (left[cur] != 0)
			inOrder(left[cur]);
		System.out.print((char) (cur + 'A' - 1));
		if (right[cur] != 0)
			inOrder(right[cur]);
	}

	private static void postOrder(int cur) {
		if (left[cur] != 0)
			postOrder(left[cur]);
		if (right[cur] != 0)
			postOrder(right[cur]);
		System.out.print((char) (cur + 'A' - 1));
	}

}
