package ssafy.study_38th;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/17268 )
 */
public class BJ_17268_미팅의저주 {

	static int N, MOD = 987654321;
	static long dp[] = new long[10001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()) / 2; // 두명이 짝이니까 2로 나누어 계산하면 된다

		// 카탈란 수
		// dp[n] += dp[i] * dp[n - 1 - i] (i는 0 ~ n-1의 범위)
		dp[0] = 1;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += (dp[j]) * (dp[i - 1 - j]) % MOD;
			}
			dp[i] %= MOD;
		}

		System.out.println(dp[N]);
	}

}
