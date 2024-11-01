package boj;

import java.io.*;

/**
 * 백준 S1 ( https://www.acmicpc.net/problem/11057 )
 * 다이나믹 프로그래밍
 */
public class BJ_11057_오르막수 {

    static int N, dp[][];
    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][10]; // dp[i][j]는 i자리의 수 중 j로 시작하는 오르막 수

        // 1의자리
        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        // n의 자리
        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD; // j보다 작은 (i-1)자리의 오르막수의 합
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < 10; i++) {
            ans = (ans + dp[N][i]) % MOD;
        }
        bw.write(ans + "\n");

        bw.flush();
        bw.close();
    }
}
