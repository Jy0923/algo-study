import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class JY_15650 {
	
	int n;
	int m;
	int[] result;
	int[] isused;
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public void backtracking(int k) throws IOException {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				bw.write(result[i] + " ");
			}
			bw.newLine();
			return;
		}
		
		int start = 0;
		if (k != 0) {
			start = result[k-1];
		}
		for (int i = start; i < n; i++) {
			
			if (isused[i] == 0) {
				result[k] = i+1;
				isused[i] = 1;
				backtracking(k+1);
				isused[i] = 0;
			}
		}
	}
	
	public void solution() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		result = new int[m];
		isused = new int[n];
		
		backtracking(0);
		bw.flush();
		
	}	
	
	public static void main(String[] args) throws IOException {
		new JY_15650().solution();
	}
}
