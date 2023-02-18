package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 제로
public class No10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 재민이
		// 재현이는 도와주는 애지만 항상 사고를 치는아이 , 잘못된 수를 부를때마다 0을 외침
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
	
		Stack<Integer> stack = new Stack<>();
		int n;
		int sum = 0;
		for(int i=0; i<k; i++) {
			n = Integer.parseInt(br.readLine());
			
			if(n != 0) 
				sum += stack.push(n);
			else 
				sum -= stack.pop();
		}
		
		System.out.println(sum);
	}
}
