package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No10828 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		String tmp, method;
		int num;
		for(int i=0; i<n; i++) {
			tmp = br.readLine();
			method = tmp.split(" ")[0];
			
			switch(method) {
			
			case "push":
				num = Integer.parseInt(tmp.split(" ")[1]);
				stack.push(num);
				break;
				
			case "pop":
				if(stack.empty())
					System.out.println(-1);
				else
					System.out.println(stack.pop()); // 실제 data 꺼내기
				break;
				
			case "size":
				System.out.println(stack.size());
				break;
				
			case "empty":
				if(stack.empty()) // isEmpty & empty
					System.out.println(1);
				else 
					System.out.println(0);
				break;
			
			case "top":
				if(stack.empty())
					System.out.println(-1);
				else 
					System.out.println(stack.peek()); // 최상단 data 반환(실제로 스택에서 꺼내진 X)
				break;
				
			}
			
			
			
		}
		
	}
	
}
