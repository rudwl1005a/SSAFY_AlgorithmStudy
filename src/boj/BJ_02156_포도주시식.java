package boj;

import java.io.*;

/**
 * 백준 S1 ( https://www.acmicpc.net/problem/2156 )
 * 다이나믹 프로그래밍
 */
public class BJ_02156_포도주시식 {

    static int N, input[], dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        // 풀이
        if(N == 1) {
            bw.write(input[0] + "");
        } else if(N == 2) {
            bw.write((input[0] + input[1]) + "");
        } else {
            dp = new int[N][4]; // 0: 앞의 포도주 두개 연속 안먹은 경우 ( x x )
                                // 1: 앞의 포도주 중 직전 포도주만 먹은 경우 ( x o )
                                // 2: 앞의 포도주 중 직전 포도주만 안먹은 경우 ( o x )
                                // 3: 앞의 포도주 중 두개 연속 먹은 경우 ( o o )
            dp[0][0] = 0;
            dp[0][1] = 0;
            dp[0][2] = input[0];
            dp[0][3] = input[0];
            dp[1][0] = 0;
            dp[1][1] = input[1];
            dp[1][2] = input[0];
            dp[1][3] = input[0] + input[1];
            for (int i = 2; i < N; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
                dp[i][1] = Math.max(dp[i - 1][0] + input[i], dp[i - 1][2] + input[i]);
                dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][3]);
                dp[i][3] = dp[i - 1][1] + input[i];
            }

            bw.write(Math.max(dp[N - 1][0], Math.max(dp[N - 1][1], Math.max(dp[N - 1][2], dp[N - 1][3]))) + "");
        }

        // flush, close처리 하지 않으면 오답..
        bw.flush();
        bw.close();
    }
}
