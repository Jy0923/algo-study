package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_2263 {

	static BufferedReader br;
	static StringBuilder sb;

	static int[] index;
	static int[] inOrder;
	static int[] postOrder;

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		index = new int[N + 1];
		inOrder = new int[N + 1];
		postOrder = new int[N + 1];

		String[] input = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			inOrder[i] = Integer.parseInt(input[i-1]);
			// 인오더 요소들의 인덱스 정보 저장
			index[inOrder[i]] = i;
		}

		input = br.readLine().split(" ");
		for (int i = 1; i <= N; i++)
			postOrder[i] = Integer.parseInt(input[i-1]);

		getPreOrder(1, N, 1, N);
	}

	static void getPreOrder(int inS, int inE, int postS, int postE) {

		if (inS > inE || postS > postE)
			return;

		int rootIdx = index[postOrder[postE]];
		int leftSize = rootIdx - inS;
		
		System.out.print(inOrder[rootIdx] + " ");

		getPreOrder(inS, rootIdx - 1, postS, postS + leftSize - 1);
		getPreOrder(rootIdx + 1, inE, postS + leftSize, postE - 1);

	}
}
