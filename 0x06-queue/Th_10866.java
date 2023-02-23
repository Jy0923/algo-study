import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] read;
				
		Deque dq = new Deque();
		
		int numberOfCommand = Integer.parseInt(br.readLine());
		for(int c=0; c<numberOfCommand; c++) {
			read = br.readLine().split(" ");
			String command = read[0];
			
			if(command.equals("push_front")) dq.push_front(Integer.parseInt(read[1]));
			if(command.equals("push_back")) dq.push_back(Integer.parseInt(read[1]));
			if(command.equals("front")) sb.append(dq.front() + "\n");
			if(command.equals("back")) sb.append(dq.back() + "\n");
			if(command.equals("empty")) sb.append(dq.empty() + "\n");
			if(command.equals("size")) sb.append(dq.size() + "\n");
			if(command.equals("pop_front")) sb.append(dq.pop_front() + "\n");
			if(command.equals("pop_back")) sb.append(dq.pop_back() + "\n");
			
		}
		System.out.println(sb);
	}
	
	static class Deque{
		LinkedList<Integer> list = new LinkedList<>();
		
		public void push_front(int num) {
			list.addFirst(num);
		}
				
		public void push_back(int num) {
			list.addLast(num);
		}
		
		public int pop_front() {
			if(empty() == 1) return -1;
			return list.pollFirst();
		}
		
		public int pop_back() {
			if(empty() == 1) return -1;
			return list.pollLast();
		}
		
		public int size() {
			return list.size();
		}
		
		public int empty() {
			if(size() == 0) return 1;
			return 0;
		}
		
		public int front() {
			if(empty() == 1) return -1;
			return list.peekFirst();
		}
		
		public int back() {
			if(empty() == 1) return -1;
			return list.peekLast();
		}
	}
}