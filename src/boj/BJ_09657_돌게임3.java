package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/9657 )
 */
public class BJ_09657_돌게임3 {

	static int N;
	static boolean dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new boolean[1001];

		dp[1] = true;
		dp[3] = true;
		dp[4] = true;
		for (int i = 5; i <= N; i++) {
			if (dp[i - 1] && dp[i - 3] && dp[i - 4]) {
				dp[i] = false;
			} else {
				dp[i] = true;
			}
		}

		System.out.println(dp[N] ? "SK" : "CY");
	}

}
