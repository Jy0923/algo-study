import java.io.*;

public class Th_9184 {

    //각 정수 값마다의 결과값
    static int[][][] dy = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] read = br.readLine().split(" ");
        int a = Integer.parseInt(read[0]); int b = Integer.parseInt(read[1]); int c = Integer.parseInt(read[2]);

        //종료코드 입력받으면 반복 끝
        while(!(a == -1 && b == -1 && c == -1)) {
            int answer = 1; //결과값 입력받을 변수

            // 하나라도 0보다 작으면
            //(배열에 -1이 들어가는거 방지 역할)
            if(a<=0 || b<=0 || c<=0)
                answer = 1;

            // 하나라도 20보다 크면
            else if(a>20 || b>20 || c>20)
                answer = w(20,20,20);

            else
                answer = w(a, b, c);

            bw.append("w("+a+", "+b+", "+c+") = "+answer+"\n");

            read = br.readLine().split(" ");
            a = Integer.parseInt(read[0]); b = Integer.parseInt(read[1]); c = Integer.parseInt(read[2]);
        }

        bw.flush();
        bw.close();
    }

    //각각 값이 나올때마다 배열에 값 저장
    public static int w(int a, int b, int c) {
        //하나라도 0보다 작으면
        if(a<=0 || b<=0 || c<=0)
            return 1;
        
        //혹시 값이 있으면 값 반환
        else if(dy[a][b][c] != 0)
            return dy[a][b][c];

        //조건에 맞으면
        else if(a<b && b<c)
            return dy[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);

        //아무 조건에도 안맞으면
        else 
            return dy[a][b][c] = w(a-1, b, c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
    }
}