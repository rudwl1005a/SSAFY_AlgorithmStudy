package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/17626 )
 */
public class BJ_17626_FourSquares {

	static int N, dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		dp[0] = 0;
		dp[1] = 1;
		System.out.println(solve(N));
	}

	public static int solve(int num) {

		for (int i = 2; i <= num; i++) {
			int min = Integer.MAX_VALUE;

			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, dp[i - j * j]);
			}

			dp[i] = min + 1;
		}

		return dp[num];
	}
}
