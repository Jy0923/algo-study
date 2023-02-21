import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MX = 1000005;
	static int[] data;
	static int pos = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		data = new int[MX];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case ("push"):
				push(Integer.parseInt(st.nextToken()));
				continue;
			case ("pop"):
				System.out.println(pop());
				continue;
			case ("size"):
				System.out.println(size());
				continue;
			case ("empty"):
				System.out.println(empty());
				continue;
			case ("top"):
				System.out.println(top());
				continue;

			}
		}

	}

	public static void push(int x) {
		data[pos++] = x;
	}

	public static int pop() {
		if (pos == 0) {
			return -1;
		} else {
			pos--;
			return data[pos];

		}

	}

	public static int size() {
		return pos;
	}

	public static int empty() {
		if (pos == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int top() {
		if (pos == 0) {
			return -1;
		} else {
			return data[pos - 1];	
		}

	}

}
