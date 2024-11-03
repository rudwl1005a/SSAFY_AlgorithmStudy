package boj;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 S1 ( https://www.acmicpc.net/problem/9465 )
 * 다이나믹 프로그래밍
 */
public class BJ_09465_스티커 {

    static int T, N, input[][], dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            dp = new int[2][N];
            input = new int[2][N];

            StringTokenizer st;
            for(int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    input[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 스티커를 한칸옆의 대각선을 뜯었을 때와, 두칸옆의 대각선을 뜯었을 때의 최대값을 구해야 함
            dp[0][0] = input[0][0];
            dp[1][0] = input[1][0];
            int ans = Math.max(dp[0][0], dp[1][0]);
            for(int i = 1; i < N; i++) {
                if(i == 1) {
                    dp[0][i] = dp[1][i - 1] + input[0][i];
                    dp[1][i] = dp[0][i - 1] + input[1][i];
                } else {
                    dp[0][i] = Math.max(dp[1][i - 1] + input[0][i], dp[1][i - 2] + input[0][i]);
                    dp[1][i] = Math.max(dp[0][i - 1] + input[1][i], dp[0][i - 2] + input[1][i]);
                }
                ans = Math.max(ans, Math.max(dp[0][i], dp[1][i]));
            }

            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
    }
}
