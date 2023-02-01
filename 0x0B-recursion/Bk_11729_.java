import java.util.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    static int cnt;
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        // 원판  갯수
        int N = sc.nextInt();
        sc.close();
        
        hanoi(1, 2, 3, N);
        
        System.out.println(cnt);
        System.out.println(sb);
        
    }
    
    public static void hanoi(int from, int via, int to, int n) {
        cnt++;
        if(n==1) { // 원판이 1개면 그냥 이동 (종료 조건) 
            sb.append(from + " " + to + "\n");
            return;
        }
        
        hanoi(from, to, via, n-1); // n-1개의 원판을 경유지에 쌓음
        
        sb.append(from + " " + to + "\n"); // 가장  아래 원판를  목적지로 이동
        
        hanoi(via, from, to, n-1); //경유지에 쌓아놓은 n-1개의 원판을 목적지로 이동 
        
            
    }
}
