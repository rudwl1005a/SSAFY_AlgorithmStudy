package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/2579 )
 */
public class BJ_02579_계단오르기 {

	static int N, dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new int[3][N + 1];
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(br.readLine());
			dp[0][i] = Math.max(dp[1][i - 1], dp[2][i - 1]); // 현재 발판을 밟지 않으려면 이전 발판을 밟았어야 함
			dp[1][i] = dp[0][i - 1] + n; // 이전 발판을 밟지 않고 현재 발판을 밟았을 때
			dp[2][i] = dp[1][i - 1] + n; // 이전 밟판을 밟고 현재 발판을 밟았을 때
		}

		System.out.println(Math.max(dp[1][N], dp[2][N]));
	}

}
