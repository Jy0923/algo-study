package _230130;

import java.util.Scanner;

public class Yy_2231 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		// 자연수 M의 분해합 N => M은 N의 생성자
		// 생성자(M)보다 항상 N이 같거나 큼

		
		boolean isExists = false;
		int i2;
		// 자연수 1~ 최대 n까지
		for(int i=1; i<=n; i++) {
			// i의 초기값 저장
			i2 = i;
			
			// 분해합 확인할 x 변수 생성
			int x = i;
			while(i2 != 0) {
				x += i2 % 10;
				i2 /= 10;
			}
			
			if(x == n) {
				System.out.println(i);
				isExists = true;
				break;
			}
		}
		
		if(!isExists) System.out.println(0);
		
	}
}
