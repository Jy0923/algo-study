import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6549_히스토그램에서가장큰직사각형_ {

    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int numOfRectangle = Integer.parseInt(st.nextToken());
            if (numOfRectangle == 0) break;

            nums = new int[numOfRectangle];

            for (int i = 0; i < numOfRectangle; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(getArea(0,numOfRectangle-1));
        }
    }

    private static long getArea(int l, int r) {
        if (l == r) return nums[l];

        int mid = (l + r) / 2;

        long leftArea = getArea(l, mid);
        long rightArea = getArea(mid + 1, r);

        long max = Math.max(leftArea, rightArea);

        max = Math.max(max, getMidArea(l, r, mid));

        return max;
    }

    private static long getMidArea(int l, int r, int mid) {
        int toLeft = mid;
        int toRight = mid;

        long height = nums[mid];

        long maxArea = height;

        while(l < toLeft && toRight < r) {
            if(nums[toLeft - 1] < nums[toRight + 1]) {
                toRight++;
                height = Math.min(height, nums[toRight]);
            } else {
                toLeft--;
                height = Math.min(height, nums[toLeft]);
            }

            maxArea =  Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        while(toRight < r) {
            toRight++;
            height = Math.min(height, nums[toRight]);
            maxArea =  Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        while(toLeft > l) {
            toLeft--;
            height = Math.min(height, nums[toLeft]);
            maxArea =  Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        return maxArea;
    }
}