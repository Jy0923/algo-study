import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jy_1475{
	
	static int getMaxValue(int[] array) {
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int[] counter = new int[10];
		int c;
		
		for (int i = 0; i < n.length(); i++) {
			c = Character.getNumericValue(n.charAt(i));
			if (c == 6 || c == 9) {
				if (counter[6] <= counter[9]) {
					counter[6] += 1;
				}
				else {
					counter[9] += 1;
				}
			}
			else {
				counter[c] += 1;
			}
		}
		System.out.println(getMaxValue(counter));	
		
	}
	
}