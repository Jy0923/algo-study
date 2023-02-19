import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MX = 1000005;
	static int[] data;
	static int pos = 0;
	static int input;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		data = new int[MX];
		for (int i = 0; i < n; i++) {
			input = Integer.parseInt(br.readLine());
			if (input == 0) {
				data[pos - 1] = 0;
				pos--;

			} else {
				data[pos] = input;
				pos++;
			}
		}
		int sum = 0;

		for (int element : data) {
			sum += element;
		}
		System.out.println(sum);

	}
	

}
