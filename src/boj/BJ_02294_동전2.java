package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/2294 )
 */
public class BJ_02294_동전2 {

	static int N, K;
	static int[] coin, dp;
	static final int INF = 10000001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new int[K + 1];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		
		coin = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			if(coin[i] <= K) {
				dp[coin[i]] = 1;
			}
		}

		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				if (i - coin[j] > 0 && dp[i] > dp[i - coin[j]] + 1) {
					dp[i] = dp[i - coin[j]] + 1;
				}
			}
		}
		
		System.out.println(dp[K] == INF ? -1 : dp[K]);
	}

}
