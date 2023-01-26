import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JY_24060 {
	
	int n;
	int k;
	int[] arr;
	
	public void merge_sort(int p, int r) { // 인덱스 시작, 끝
		if (p < r) {
			int q = (p + r) / 2;
			merge_sort(p, q);
			merge_sort(q+1, r);
			merge(p, q, r);
		}
	}
	
	public void merge(int p, int q, int r) {
		int i = p;
		int j = q+1;
		int t = 0;
		int[] tmp = new int[r-p+1];

		while ((i <= q) && (j <= r)) {
			if (arr[i] <= arr[j]) {
				tmp[t++] = arr[i++];
			} else {
				tmp[t++] = arr[j++];
			}
		}
		while (i <= q) {
			tmp[t++] = arr[i++];
		}
		while (j <= r) {
			tmp[t++] = arr[j++];
		}
		i = p;
		t = 0;
		while (i <= r) {
			arr[i++] = tmp[t++];
			k--;
			if (k == 0) {
				System.out.println(tmp[t-1]);
			}
		}
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		merge_sort(0, arr.length - 1);
		if (k > 0) {
			System.out.println(-1);
		}
	}
	
	public static void JY_24060(String[] args) throws Exception {
		new  Main().solution();
	}
}
