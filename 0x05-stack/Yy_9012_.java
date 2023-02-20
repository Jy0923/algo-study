package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No9012_괄호2 {
	/*
	 * 열린괄호( '(' )일 땐, stack에 push
	 * 닫힌괄호( ')' )일 땐, stack에서 pop해준다.
	 * 
	 * 	1. 열린괄호, 닫힌괄호가 알맞게 짝지은경우 
	 * 		-> 에러없이 stack이 empty 상태   ==> return YES
	 * 	2. 열린괄호가 더 많은 경우
	 * 		-> str.length()만큼 반복 후에도 stack이 !empty 상태
	 * 	3. 닫힌괄호가 더 많은 경우
	 * 		-> stack이 empty인데 pop을 해야해서 에러가 나는 상태
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		label:
		for(int i=0; i<t; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			for(int j=0; j<str.length(); j++) {
				char c = str.charAt(j);
				
				// 열린 괄호일 때
				if(c == '(') 
					stack.push(c);
				
				// 닫힌 괄호일 때
				// 1. 스택이 비어있을 때(열린괄호가 부족할 때)
				else if(stack.isEmpty()) { // 에러나기 전에 종료해버리기
					sb.append("NO").append("\n");
					continue label;
				}
				// 2. 스택이 비어있진 않을때
				else 
					stack.pop();
			}
			
			// 문자열 길이만큼 다 돌린 후 Empty면 성공
			if(stack.isEmpty()) 
				sb.append("YES").append("\n");
			// 아니면 실패
			else
				sb.append("NO").append("\n");
		}
		
		System.out.println(sb);
	}
}

/* 맞긴했는데 가독성 0인코드
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			String result = "NO";
			
			int cnt = 0;
			for(int j=0; j<str.length(); j++) {
				cnt++;
				if(str.charAt(j) == '(') {
					stack.push(str.charAt(j));
				} else {
					if(!stack.empty())
						stack.pop();
					else {
						cnt--;
						break;		
					}
				}
			}
			
			if(stack.empty() && cnt == str.length())
				result = "YES";
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);

 */
