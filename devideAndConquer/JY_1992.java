import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JY_1992 {
	
	char[][] arr;
	
	public int countZero(int n, int r, int c) {
		int cnt = 0;
		for (int row = r; row < r+n; row++) {
			for (int col = c; col < c+n; col++) {
				if (arr[row][col] == '0') {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public String bracket(String s) {
		if (s.length() != 1) {
			s = "(" + s + ")";
		}
		return s;
	}
	
	public String dq(int n, int r, int c) {
		if (n == 1) {
			return String.valueOf(arr[r][c]);
		}
		
		int zc = countZero(n, r, c);
		if (zc == (n*n)) {
			return "0";
		} else if (zc == 0) {
			return "1";
		} 
		
		String first = bracket(dq(n/2, r, c)); 
		String second = bracket(dq(n/2, r, c+n/2));
		String third = bracket(dq(n/2, r+n/2, c));
		String forth = bracket(dq(n/2, r+n/2, c+n/2));
		return first + second + third + forth;
	}
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		for (int r = 0; r < n; r++) {
			arr[r] = br.readLine().toCharArray();
		}
		
		System.out.println(bracket(dq(n, 0, 0)));
	}
    
	public static void main(String[] args) throws IOException {
		new JY_1992().solution();
	}
}
