import java.io.IOException;
import java.util.Scanner;

public class main {
	public static int fibonacci(int num) {
		if (num == 1) {
			return 1;
		}
		else {
			return num + fibonacci(num-1);
		}
			
		}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

    	Scanner sc = new Scanner(System.in);
    	int key = sc.nextInt();
    	System.out.println(fibonacci(key));
    	
	}
	
	
}
