package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/18427 )
 */
public class BJ_18427_함께블록쌓기 {

	static int N, M, H, dp[][];
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		dp = new int[N + 1][H + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
			dp[i][0] = 1;
		}
		dp[0][0] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= H; j++) {
				for (Integer n : list[i]) {
					if (j >= n) {
						dp[i][j] += dp[i - 1][j - n];
						dp[i][j] %= 10007;
					}
				}
				dp[i][j] += dp[i - 1][j];
				dp[i][j] %= 10007;
			}
		}
		System.out.println(dp[N][H]);
	}
}
