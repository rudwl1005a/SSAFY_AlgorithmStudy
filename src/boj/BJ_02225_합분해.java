package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/2225 )
 */
public class BJ_02225_합분해 {

	static int N, K;
	static long dp[][];
	static final int MOD = 1000000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new long[N + 1][K + 1]; // dp[만들기 위한 수][사용할 숫자 개수]

		// 초기 개수 초기화
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= K; j++) {
				if (i == 0) {
					dp[i][j] = 1; // 초기값을 위해
				} else {
					dp[i][j] = j; // j개를 사용하여 i를 만들 수 있는 경우의 수 -> 0과 i로만 이루어진 경우 j개이다
				}
			}
		}
		for (int i = 0; i <= N; i++) {
			dp[i][1] = 1; // 1개를 사용하여 i를 만들 수 있는 경우의 수
		}

		// k를 사용해서 n이 되는 경우의 수는 k-1개를 사용한 0~n의 경우의 수에서 각각 한개의 수를 더하면 되기 때문에 전부를 합한 값과 같다
		// dp[n][k] = dp[n][k-1] + dp[n-1][k-1] + dp[n-2][k-1] + .. + dp[0][k-1]이다.
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= K; j++) {
				for (int k = i; k >= 0; k--) {
					dp[i][j] += dp[k][j - 1] % MOD;
				}
			}
		}

		System.out.println(dp[N][K] % MOD);
	}

}
