import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class JY_15651 {
	
	int n;
	int m;
	int[] arr;
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public void backtracking(int k) throws IOException {
		if (k == m) {
			for (int e : arr) {
				bw.write(e + " ");
			}
			bw.newLine();
			return;
		}
		for (int i = 0; i < n; i++) {
			arr[k] = i+1;
			backtracking(k+1);
		}
	}
	
	public void solution() throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[m];
		
		backtracking(0);
		bw.flush();
	}	
	
	public static void main(String[] args) throws IOException {
		new JY_15651().solution();
	}
}
