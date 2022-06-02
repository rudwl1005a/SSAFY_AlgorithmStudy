package ssafy.study_10th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/11052 )
 */
public class BJ_11052_카드구매하기 {

	static int N;
	static int[] card;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		card = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N + 1];
		dp[0] = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				if (i - j > 0 && dp[i] < dp[i - j - 1] + card[j]) {
					dp[i] = dp[i - j - 1] + card[j];
				}
			}
		}

		System.out.println(dp[N]);
	}

}
