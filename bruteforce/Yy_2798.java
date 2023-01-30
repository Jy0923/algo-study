package _230130;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Yy_2798 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int n = Integer.parseInt(str.split(" ")[0]);
		int m = Integer.parseInt(str.split(" ")[1]);
		
		List<Integer> list = new ArrayList<>();
		
		str = br.readLine();
		
		for(int i=0; i<n; i++) 
			list.add(Integer.parseInt(str.split(" ")[i]));
		
		
		// m과 제일 가까운 합
		int similar = 0;
		// 반복문마다 합
		int sum;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					
					if(i != j && j != k && k != i) {
						// sum 초기화
						sum = 0;
						
						sum += list.get(i) + list.get(j) + list.get(k);
						
						// 세가지 숫자의 합이 m보다 크면 continue
						if(sum > m) continue;
						
						// m 이하에서 제일 큰 수 저장
						if(similar <= sum) similar = sum;
					}
				}
			}
		}
		System.out.println(similar);
		
	}
}
