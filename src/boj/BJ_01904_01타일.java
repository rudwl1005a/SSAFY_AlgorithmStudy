package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1904 )
 */
public class BJ_01904_01타일 {

	static int N;
	static long dp[];
	static final int MOD = 15746;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new long[N + 1];

		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < N + 1; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
		}

		System.out.println(dp[N]);
	}

}
