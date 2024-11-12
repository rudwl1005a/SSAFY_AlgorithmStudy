package boj;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 S2 ( https://www.acmicpc.net/problem/11722 )
 * 다이나믹 프로그래밍
 */
public class BJ_11722_가장긴감소하는부분수열 {

    static int N, arr[], dp[], ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이
        dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[i]);
        }
        bw.write(ans + "");

        bw.flush();
        bw.close();
    }
}
