package devideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2740_행렬곱셈 {
	
	static int n, m, k;
	static int[][] a, b;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) 
				a[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		k = Integer.parseInt(st.nextToken());
		
		b = new int[m][k];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<k; j++) 
				b[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<k; j++) {
				int num = 0;
				for(int p=0; p<m; p++) {
					num += a[i][p] * b[p][j];
				}
				sb.append(num).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
