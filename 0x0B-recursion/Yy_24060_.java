

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yy_24060 {
	// 구글링
	
	static int[] arr, tmp;
	static int count = 0;
	static int result = -1;
	static int k;
	
	public static void main(String[] args) throws IOException {
		// 시간 초과 -> BufferedReader & StringTokenizer 변경
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // n
		
		k = Integer.parseInt(st.nextToken()); // k 
		
		st = new StringTokenizer(br.readLine());
		
		arr = new int[n];
		for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
			
		tmp = new int[n];
		
		// 정렬
		mergeSort(arr, 0, n - 1);
		
		System.out.println(result);
		
	}
	
	// 합병정렬
	public static void mergeSort(int[] arr, int first, int last) {
		if (count > k) return;
		if (first < last) {
			int mid = (first + last) / 2;
			
			mergeSort(arr, first, mid);
			mergeSort(arr, mid + 1, last);
			merge(arr, first, mid, last);
		}
	}
	
	public static void merge(int[] arr, int first, int mid, int last) {
		int i = first;
		int j = mid + 1;
		int t = 0;
		
		while (i <= mid && j <= last) {
			if(arr[i] <= arr[j]) {
				tmp[t] = arr[i];
				i++;
			}else {
				tmp[t] = arr[j];
				j++;
			}
			t++;
		}
		
		while (i <= mid) 
			tmp[t++] = arr[i++];

		while (j <= last) 
			tmp[t++] = arr[j++];

		i = first;
		t = 0;
		while (i <= last) {
			count++;
			if (count == k) {
				result = tmp[t];
				break;
			} 
			arr[i++] = tmp[t++];
		}
	}
	
}
