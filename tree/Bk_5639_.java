package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bk_5639_ {

	static BufferedReader br;
	static StringBuilder sb;

	static List<Integer> tree;

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		tree = new ArrayList<Integer>();

		while (true) {
			String input = br.readLine();
			if(input == null || input.equals("")) break;
			tree.add(Integer.parseInt(input));
		}

		postOrder(0, tree.size() - 1);

	}

	public static void postOrder(int idx, int end) {
		if (idx > end)
			return;

		int mid = idx + 1;
		while (mid <= end && tree.get(mid) < tree.get(idx))
			mid++;

		postOrder(idx + 1, mid - 1);
		postOrder(mid, end);

		System.out.println(tree.get(idx));
	}
}
