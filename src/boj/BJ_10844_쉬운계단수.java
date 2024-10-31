package boj;

import java.io.*;

/**
 * 백준 S1 ( https://www.acmicpc.net/problem/10844 )
 * 다이나믹 프로그래밍
 */
public class BJ_10844_쉬운계단수 {

    static int N;
    static long dp[][];
    static final long MOD = 1000000000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new long[101][10]; // dp[i][j]는 길이가 i이고 j로 시작하는 계단 수

        // 1의 자리
        for(int i = 0; i<10; i++) {
            dp[1][i] = 1;
        }

        // n의 자리 계산
        for(int i = 2; i <= N; i++) {
            // 0으로 시작하는 계단 수
            dp[i][0] = dp[i - 1][1];
            // 1~8으로 시작하는 계단 수
            for(int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i - 1][j - 1] % MOD) + (dp[i - 1][j + 1] % MOD);
            }
            // 9로 시작하는 계단 수
            dp[i][9] = dp[i - 1][8] % MOD;
        }

        long ans = 0;
        for(int i = 1; i < 10; i++) {
            ans = (ans + dp[N][i]) % MOD;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ans);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
