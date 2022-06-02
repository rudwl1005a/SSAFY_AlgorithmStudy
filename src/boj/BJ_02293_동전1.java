package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/2293 )
 */
public class BJ_02293_동전1 {
	
	static int N, K;
	static int[] coin, dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coin = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[K + 1];
		dp[0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = coin[i]; j <= K; j++) {
				dp[j] += dp[j - coin[i]];
			}
		}
		
		System.out.println(dp[K]);
	}

}
