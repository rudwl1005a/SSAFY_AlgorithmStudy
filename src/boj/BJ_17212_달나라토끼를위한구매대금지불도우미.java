package boj;

import java.io.*;

/**
 * 백준 S3 ( https://www.acmicpc.net/problem/17212 )
 * 다이나믹 프로그래밍
 */
public class BJ_17212_달나라토끼를위한구매대금지불도우미 {

    static int N, dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            if(i >= 2) {
                dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            }
            if(i >= 5) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
            if(i >= 7) {
                dp[i] = Math.min(dp[i], dp[i - 7] + 1);
            }

        }
        bw.write(dp[N] + "");

        bw.flush();
        bw.close();
    }

}
