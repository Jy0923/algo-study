import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tree = new int[n + 1][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node = st.nextToken().charAt(0) - 'A' + 1;
			int lc = st.nextToken().charAt(0) - 'A' + 1;
			int rc = st.nextToken().charAt(0) - 'A' + 1;
			tree[node][0] = lc;
			tree[node][1] = rc;

		}

		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);

	}

	private static void postorder(int next) {
		if (tree[next][0] != -18) {
			postorder(tree[next][0]);

		}

		if (tree[next][1] != -18) {
			postorder(tree[next][1]);
		}

		int num = 'A' + next - 1;
		System.out.print((char) num);
	}

	private static void inorder(int next) {
		if (tree[next][0] != -18) {
			inorder(tree[next][0]);

		}
		int num = 'A' + next - 1;
		System.out.print((char) num);

		if (tree[next][1] != -18) {
			inorder(tree[next][1]);
		}

	}

	private static void preorder(int next) {
		int num = 'A' + next - 1;
		System.out.print((char) num);
		if (tree[next][0] != -18) {
			preorder(tree[next][0]);

		}

		if (tree[next][1] != -18) {
			preorder(tree[next][1]);
		}
	}
}
