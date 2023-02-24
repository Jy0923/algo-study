import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JY_2630 {
	
	int[][] arr;
	int white = 0;
	int blue = 0;
	
	public int countBlue(int n, int r, int c) {
		int cnt = 0;
		for (int row = r; row < r+n; row++) {
			for (int col = c; col < c+n; col++) {
				if (arr[row][col] == 1) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public void dq(int n, int r, int c) {
		if (n == 1) {
			if (arr[r][c] == 1) {
				blue++;
			} else {
				white++;
			}
			return;
		}
		
		int bc = countBlue(n, r, c);
		if (bc == (n*n)) {
			blue++;
			return;
		} else if (bc == 0) {
			white++;
			return;
		} else {
			
			dq(n/2, r, c);
			dq(n/2, r, c+n/2);
			dq(n/2, r+n/2, c);
			dq(n/2, r+n/2, c+n/2);
		}
	}
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		String[] input;
		for (int r = 0; r < n; r++) {
			 input = br.readLine().split(" ");
			 for (int c = 0; c < n; c++) {
				 arr[r][c] = Integer.parseInt(input[c]);
			 }
		}
		
		dq(n, 0, 0);
		System.out.println(white);
		System.out.println(blue);
	}
    
	public static void main(String[] args) throws IOException {
		new JY_2630().solution();
	}
}
