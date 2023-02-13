package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1003 )
 */
public class BJ_01003_피보나치함수 {

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 피보나치 DP
		T = Integer.parseInt(br.readLine());
		long[] dp = new long[41]; // DP 배열 초기화
		dp[1] = 1;
		for (int i = 2; i <= 40; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) { // 0이면 1 0 출력
				sb.append("1 0").append("\n");
			} else {
				sb.append(dp[n - 1] + " " + dp[n]).append("\n");
			}
		}
		System.out.print(sb);
	}
}
