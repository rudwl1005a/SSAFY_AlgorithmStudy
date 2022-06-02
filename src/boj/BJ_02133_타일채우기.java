package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/2133 )
 */
public class BJ_02133_타일채우기 {

	static int N;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];

		dp[0] = 1;
		dp[1] = 0;

		for (int i = 2; i <= N; i += 2) {
			dp[i] = dp[i - 2] * 3;
			for (int j = i - 4; j >= 0; j--) {
				dp[i] += dp[j] * 2;
			}
		}

		System.out.println(dp[N]);
	}

}
