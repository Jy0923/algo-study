package algo_study;

import java.util.Scanner;

public class No1436 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// '666'을 포함하는 숫자가 있으면 cnt++
		int cnt = 0;
		
		// 반복문에서 정수를 str으로 변환해서 넣어줄 변수
		String parseStr = "";
			
		for(int i=666; ;i++) {
			
			parseStr = String.valueOf(i);
			
			if(parseStr.contains("666"))
				cnt++;
			
			if(cnt == n) {
				System.out.println(i);
				break;
			}
		}
	}
}
