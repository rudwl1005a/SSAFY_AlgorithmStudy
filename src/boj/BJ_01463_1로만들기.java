package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 S3 ( https://www.acmicpc.net/problem/1463 )
 * 다이나믹 프로그래밍(DP)
 */
public class BJ_01463_1로만들기 {

    static int N;
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        dp[1] = 0;

        for(int i = 2; i < N+1; i++) {
            if(dp[i] == 0) {
                int x = Integer.MAX_VALUE;
                int y = Integer.MAX_VALUE;
                if(i % 2 == 0) {
                    x = dp[i/2] + 1;
                }
                if(i % 3 == 0) {
                    y = dp[i/3] + 1;
                }
                dp[i] = Math.min(dp[i - 1] + 1, Math.min(x, y));
            }
        }

        System.out.println(dp[N]);
    }

}
