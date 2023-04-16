import java.util.ArrayList;
import java.util.Scanner;

public class Main{
	
	int n, cnt;
	ArrayList<Integer> prime = new ArrayList<>();
	
	public void getPrime() {
		boolean[] eratosthenes = new boolean[n+1];
		int root = (int) Math.sqrt(n) + 1;
		for (int i = 2; i <= root; i++) {
			if (eratosthenes[i]) {
				continue;
			}
			for (int j = i * 2; j <= n; j += i) {
				eratosthenes[j] = true;
			}
		}
		
		for (int i = 2; i <= n; i++) {
			if (!eratosthenes[i]) {
				prime.add(i);
			}
		}
	}
	
	public void getCnt() {
		cnt = 0;
		int nPrime = prime.size();
		int en = 0;
		int sum = 0;
		sum = prime.get(0);
		for (int st = 0; st < nPrime; st++) {
			
			while (en < nPrime - 1 && sum < n) {
				en++;
				sum += prime.get(en);
			}
			
			if (sum == n) {
				cnt++;
			}
			sum -= prime.get(st);
		}
	}
	
	public void solution() throws Exception{
		n = new Scanner(System.in).nextInt();
		if (n==1) {
			System.out.println(0);
			System.exit(0);
		}
		getPrime();
		getCnt();
		System.out.println(cnt);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution(); 
	}
}
