package list;

import java.util.Scanner;
import java.util.Stack;

public class Th_9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCases = Integer.parseInt(sc.nextLine());
		
		for(int tc=0; tc<testCases; tc++) {
			String brackets = sc.nextLine(); //괄호 문자열
			int numberOfBracket = brackets.length(); //괄호의 개수
			
			Stack<Character> stack = new Stack<>(); //괄호 저장할 스택
			stack.push(')'); //시작 괄호가 )이면 바로 끝내기 위해 추가
			
			boolean isProper = true; //올바른 괄호 문자열인가?
			
			for(int i=0; i<numberOfBracket; i++) {
				char cur = brackets.charAt(i); //현재 괄호
			
				if(cur == ')') { // ')'인 경우
					char before = stack.pop(); //이전 괄호 꺼내기
					
					if(before != '(') { //이전 괄호도 ')'라면
						isProper = false; //올바르지 않은 괄호 문자열
						break;
					}
					continue;
				}
					
				stack.push(cur); //'('라면 스택에 넣기
			}
			
			if(stack.size() != 1) isProper = false; //괄호가 모두 매치 되었나
			
			//출력
			System.out.println(isProper? "YES" : "NO");
		}
	}
}
