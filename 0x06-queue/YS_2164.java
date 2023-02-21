import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] queue;
	static int mx = 1000001;
	static int head = 0;
	static int tail = 0;
	
	public static void push(int x) {
		queue[tail++] = x;
	}
	
	public static int pop() {
		if(head == tail) {
			return -1;
		} else {
			return queue[head++];
		}
	}
	
	public static int front() {
		if (head == tail) {
			return -1;
		} else {
			return queue[head];
		}
	}
	
	public static int size() {
		return tail - head;
	}
	
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	queue = new int[mx];
    	
    	for(int i = 1; i <= n ; i++) {
    		push(i);
    	}
    	
    	int tmp = 0;
    	
		while(size() != 1) {
			pop();
			tmp = pop();
			push(tmp);			
		}
		
		System.out.println(pop());
	}
}
