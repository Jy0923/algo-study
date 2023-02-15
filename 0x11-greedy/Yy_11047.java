package greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11047_동전0 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] moneyArr = new int[n];
		
		for(int i=n-1; i>=0; i--)
			moneyArr[i] = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if(k / moneyArr[i] == 0) 
				continue;
			else {
				cnt += k / moneyArr[i];
				k %= moneyArr[i];
			}
		}
		
		System.out.println(cnt);
		
	}
}
