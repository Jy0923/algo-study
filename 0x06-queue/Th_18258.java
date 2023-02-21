import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Th_18258 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue que = new Queue();
		
		String[] commandLine;
		int numberOfCommands = Integer.parseInt(br.readLine());
		for(int i=0; i<numberOfCommands; i++) {
			commandLine = br.readLine().split(" ");
			String command = commandLine[0];
				
			if(command.equals("push")) {
				que.push(Integer.parseInt(commandLine[1]));
				
			} else if(command.equals("pop")) {
				sb.append(que.pop());
				sb.append("\n");
			
			} else if(command.equals("size")) {
				sb.append(que.size());
				sb.append("\n");
				
			} else if(command.equals("empty")) {
				sb.append(que.empty());
				sb.append("\n");
				
			} else if(command.equals("front")) {
				sb.append(que.front());
				sb.append("\n");
				
			} else if(command.equals("back")) {
				sb.append(que.back());
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	private static class Queue {
		LinkedList<Integer> list = new LinkedList<>();
		
		public void push(int number) {
			list.add(number);
		}
		
		public int pop() {
			if(list.size() == 0) return -1;
			
			int number = list.get(0);
			list.remove(0);
			
			return number;
		}
		
		public int size() {
			return list.size();
		}
		
		public int empty() {
			if(list.size() == 0) {
				return 1;
			} else {
				return 0;
			}
		}
		
		public int front() {
			if(list.size() == 0) {
				return -1;
			}
			return list.get(0);
		}
		
		public int back() {
			if(list.size() == 0) {
				return -1;
			}
			return list.get(list.size()-1);
		}
	}
}