package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No18258_큐2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> queue = new LinkedList<>(); // peekLast
		StringTokenizer str;
		
		for(int i=0; i<n; i++) {
			str = new StringTokenizer(br.readLine());
			
			switch(str.nextToken()) {
			case "push":
				queue.add(Integer.parseInt(str.nextToken()));
				break;
				
			case "pop":
				if(!queue.isEmpty())
					sb.append(queue.poll()).append("\n");
				else
					sb.append(-1).append("\n");
				break;
				
			case "size":
				sb.append(queue.size()).append("\n");
				break;
				
			case "empty":
				if(queue.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
				
			case "front":
				if(!queue.isEmpty()) 
					sb.append(queue.peek()).append("\n"); // peek(): head 제일 처음꺼
				else
					sb.append(-1).append("\n");
				break;
				
			case "back":
				if(!queue.isEmpty())
					sb.append(queue.peekLast()).append("\n");
				else
					sb.append(-1).append("\n");
				break;
			}
		}
		
		System.out.println(sb);
	}
}
