package boj;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 S2 ( https://www.acmicpc.net/problem/11055 )
 * 다이나믹 프로그래밍
 */
public class BJ_11055_가장큰증가하는부분수열 {

    static int N, arr[], dp[], ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이
        for (int i = 0; i < N; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp[i] < dp[j] + arr[i]) {
                    dp[i] = dp[j] + arr[i];
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
