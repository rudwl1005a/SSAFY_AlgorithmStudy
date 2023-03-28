package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/2193 )
 */
public class BJ_02193_이친수 {

	static int N;
	static long dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new long[N + 1];

		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		System.out.println(dp[N]);
	}

}
