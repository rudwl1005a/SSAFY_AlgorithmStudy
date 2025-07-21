package boj;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 S3 ( https://www.acmicpc.net/problem/25706 )
 */
public class BJ_25706_자전거묘기 {

    static int N, input[], dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        dp[N - 1] = 1;
        for(int i = N - 2; i >= 0; i--) {
            if(input[i] > 0) {
                if(i + input[i] >= N - 1) dp[i] = 1;
                else dp[i] = dp[i + input[i] + 1] + 1;
            } else {
                dp[i] += dp[i + 1] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(dp[i]).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
