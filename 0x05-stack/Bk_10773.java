package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bk_10773 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		Stack<Integer> st = new Stack<>();
		
		int input=0;
		for(int i=0; i<K; i++) {
			input = Integer.parseInt(br.readLine());
			if(input != 0)
				st.push(input);
			else st.pop();
		}
		
		int sum = 0;
		while(!st.empty()) {
			sum += st.peek();
			st.pop();
		}
		
		System.out.println(sum);
		
	}

}
