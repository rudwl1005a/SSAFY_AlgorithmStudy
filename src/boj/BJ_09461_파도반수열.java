package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/9461 )
 */
public class BJ_09461_파도반수열 {

	static int T;
	static long dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dp = new long[101];
		dp[1] = dp[2] = dp[3] = 1;
		for (int i = 4; i < 101; i++) {
			dp[i] = dp[i - 3] + dp[i - 2];
		}

		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
		
	}

}
