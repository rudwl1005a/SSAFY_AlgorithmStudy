package boj;

import java.io.*;

/**
 * 백준 S4 ( https://www.acmicpc.net/problem/31460 )
 * 수학, 해구하기
 */
public class BJ_31460_초콜릿과11과팰린드롬 {

    static int T, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            if(N == 1) {
                bw.write("0\n"); // 0도 11의 배수..
                continue;
            }

            bw.write("1");
            for(int i = 0; i < N - 2; i++) {
                bw.write("2");
            }
            bw.write("1\n");

        }

        bw.flush();
        bw.close();
    }

}
