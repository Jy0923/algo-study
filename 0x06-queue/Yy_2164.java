package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class No2164_카드2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> queue = new LinkedList<>();
		
		// pollLast해서 push하기 위해 인덱스 반대로 적용
		for(int i=1; i<=n; i++) {
			queue.push(i);
		}
		
		while(queue.size() != 1) {
			queue.pollLast();
			queue.push(queue.pollLast());
		}
		
		System.out.println(queue.peek());
	}
}
