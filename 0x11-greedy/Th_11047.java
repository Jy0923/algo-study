import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Th_11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] read = br.readLine().split(" ");
		
		int N = Integer.parseInt(read[0]);
		int K = Integer.parseInt(read[1]);
		
		int[] coins = new int[N];
		
		for(int i=0; i<N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		int idx = N-1;
		
		while(K != 0) {
			if(coins[idx] > K) {
				idx--;
				continue;
			}
			
			cnt += K/coins[idx];
			K %= coins[idx];
		}
		
		System.out.println(cnt);
		
	}
}
