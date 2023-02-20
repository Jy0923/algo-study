package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No4949_균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = br.readLine();
			if(str.equals(".")) 
				break;
			
			Stack<Character> stack = new Stack<>();
			boolean isYes = true;
			
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if(c == '(' || c == '[') {
					stack.push(c);
				}
				else if(c == ')'){
					if(!stack.empty() && stack.peek() == '(')
						stack.pop();
					else {
						isYes = false;
						break;
					}
				}
				else if(c == ']') {
					if(!stack.empty() && stack.peek() == '[')
						stack.pop();
					else {
						isYes = false;
						break;
					}
				}
				else continue;
			}
			
			if(isYes && stack.empty())
				System.out.println("yes");
			else {
				System.out.println("no");
			}
			
		}
	}
}
