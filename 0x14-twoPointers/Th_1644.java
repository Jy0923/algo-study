import java.util.Scanner;

public class BOJ_1644_소수의연속합_정태희 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int findNum = sc.nextInt();
		
		int[] primeArr = new int[findNum+1];
		boolean[] isPrime = new boolean[findNum+1];
		int idx = 0;
		for(int num=2; num<=findNum; num++) {
			if(!isPrime[num]) {
				primeArr[idx++] = num;
				
				int curNum = num*2;
				while(curNum <= findNum) {
					isPrime[curNum] = true;
					curNum += num;
				}
			}
		}
		
		int l = 0, r = 0, cnt = 0;
		int sum = primeArr[r];
		while(r <= idx) {
			if(sum == findNum) cnt++;
			
			if(sum < findNum) {
				r++;
				sum += primeArr[r];
			} else {
				sum -= primeArr[l];
				l++;
			}
		}
		//출력
		System.out.println(cnt);
		sc.close();
	}
}
