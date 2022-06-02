package study_extra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/12852 )
 */
public class BJ_12852_1로만들기2 {

	static int N;
	static int[] dp, path;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		dp = new int[N + 1];
		path = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		for (int i = 2; i <= N; i++) {

			// 1을 뺀다
			dp[i] = dp[i - 1] + 1;
			path[i] = i - 1;

			// 2로 나눈다
			if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
				dp[i] = dp[i / 2] + 1;
				path[i] = i / 2;
			}

			// 3으로 나눈다
			if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
				dp[i] = dp[i / 3] + 1;
				path[i] = i / 3;
			}
		}

		sb.append(dp[N]).append("\n");

		while (N > 0) {
			sb.append(N + " ");
			N = path[N];
		}

		System.out.println(sb);

	}

}
