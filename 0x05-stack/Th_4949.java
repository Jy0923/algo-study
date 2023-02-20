import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Th_4949 {
	
	static HashMap<Character, Character> bracketMap = new HashMap<>(); //괄호맵
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		bracketMap.put(')','(');
		bracketMap.put(']','[');
		
		//문자열 입력 받아 균형 확인
		String curSentence = sc.nextLine();
		while(!curSentence.equals(".")) { //종료조건 나올때까지
			Stack<Character> stack = new Stack<>();
			
			boolean isBalanced = true; //균형 확인
			
			//해당 문자열 균형 확인
			for(int i=0; i<curSentence.length(); i++) {
				char cur = curSentence.charAt(i);
				
				if(cur == 40 || cur == 91) //여는 괄호
					stack.push(cur);
				
				if(cur == 41 || cur == 93) {//닫는 괄호
					if(stack.isEmpty()) { //여는 괄호가 스택에 없으면
						isBalanced = false;
						break;
					}
					
					char before = stack.pop();
					
					if(bracketMap.get(cur) != before) { //바로 이전 괄호가 해당 괄호의 여는 괄호가 아니면 
						isBalanced = false;
						break;
					}
				}
			}
			
			if(!stack.isEmpty()) isBalanced = false; //스택에 괄호가 남아있으면
			
			//출력
			System.out.println(isBalanced? "yes" : "no");
			
			//다음 문자열
			curSentence = sc.nextLine();
		}
	}
}