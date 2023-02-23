package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No10866_덱2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new LinkedList<>();
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String token = st.nextToken();
			
		    if(token.charAt(3) == '_') 
		    	sb.append(deque.isEmpty() ? -1 : token.charAt(4) == 'f' ? deque.pollFirst() : deque.pollLast()).append("\n");
		    
		    else if(token.charAt(0) == 'p') {
				if(token.charAt(5) == 'f') 
					deque.addFirst(Integer.parseInt(st.nextToken()));
				else
					deque.addLast(Integer.parseInt(st.nextToken()));
			}
			
			else if(token.charAt(0) == 's')
				sb.append(deque.size()).append("\n");
			
			else if(token.charAt(0) == 'e') 
				sb.append(deque.isEmpty()?1:0).append("\n");
			
			else if(token.charAt(0) == 'f')
				sb.append(deque.isEmpty()?-1:deque.peekFirst()).append("\n");
			
			else if(token.charAt(0) == 'b') 
				sb.append(deque.isEmpty()?-1:deque.peekLast()).append("\n");
		}
		
		System.out.println(sb);
	}
}
