import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_24060 {
    
  static int [] A, tmp;
	static int K;
	static int cycle = 0;
	static int result = -1;

	public static void main(String[] args) throws IOException {
	    
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);

		String[] str2 = br.readLine().split(" ");
		
		A = new int[N];
		tmp = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(str2[i]);
		}
		br.close();
		
		mergeSort(A, 0, (N - 1));
		System.out.println(result);

	}

	static void mergeSort(int[] A, int first, int last) {
		if (cycle > K)
			return;
		if (first < last) {
			int mid = (first + last) / 2;
			mergeSort(A, first, mid);
			mergeSort(A, mid + 1, last);
			merge(A, first, mid, last);
		}
	}

	static void merge(int[] A, int first, int mid, int last) {
		int i = first;
		int j = mid + 1;
		int t = 0;

		while (i <= mid && j <= last) { // 왼쪽, 오른쪽 배열 비교 및 정렬
			if (A[i] <= A[j])
				tmp[t++] = A[i++];
			else
				tmp[t++] = A[j++];

		}

		while (i <= mid) { // 왼쪽 배열이 남음
			tmp[t++] = A[i++];
		}

		while (j <= last) { // 오른쪽 배열이 남음
			tmp[t++] = A[j++];
		}

		i = first;
		t = 0;

		while (i <= last) {
			cycle++;
			if (cycle == K) {
				result = tmp[t];
		    System.out.println(result);
				System.exit(0);
			}
			A[i++] = tmp[t++];
			
		}

	}

}
