import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Th_13305 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] read;
		
		int N = Integer.parseInt(br.readLine());
		
		long[] road = new long[N-1]; //도로 길이
		long[] oilPrice = new long[N-1]; //도시당 가격
		
		read = br.readLine().split(" ");
		for(int i=0; i<N-1; i++) {
			road[i] = Integer.parseInt(read[i]);
		}
		
		//마지막 도시는 필요없음
		read = br.readLine().split(" ");
		for(int i=0; i<N-1; i++) {
			oilPrice[i] = Integer.parseInt(read[i]);
		}
		
		long minPrice = Integer.MAX_VALUE; //현재까지의 최소 기름 값
		long totalPrice = 0;
		
		for(int i=0; i<N-1; i++) {
			//현재까지의 최소 기름값에
			//도로길이 곱하면서
			//마지막 도로까지
			long curPrice = oilPrice[i];
			minPrice = Math.min(minPrice, curPrice);
			
			totalPrice += minPrice * road[i];
		}

		System.out.println(totalPrice);
	}
}