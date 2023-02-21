import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_스택_10828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] read;
		
		int commands = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<commands; i++) {
			read = br.readLine().split(" ");
			String command = read[0];
			
			if(command.equals("push")) {
				stack.push(Integer.parseInt(read[1]));
				continue;
			}
			
			if(command.equals("pop")) {
				if(stack.empty()) {
					bw.write("-1\n");
				} else {
					bw.write(stack.pop() + "\n");
				}
				continue;
			}
			
			if(command.equals("top")) {
				if(stack.empty()) {
					bw.write("-1\n");
				} else {
					int peekNum = stack.peek();
					bw.write(peekNum + "\n");
				}
				continue;
			}
			
			if(command.equals("size")) {
				int stackSize = stack.size();
				bw.write(stackSize + "\n");
				continue;
			}
			
			if(command.equals("empty")) {
				if(stack.empty()) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
				continue;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
