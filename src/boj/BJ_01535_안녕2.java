package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S2 ( https://www.acmicpc.net/problem/1535 )
 * 배낭 알고리즘
 */
public class BJ_01535_안녕2 {

	static int N, L[], J[], dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		L = new int[N + 1]; // 잃는 체력
		J = new int[N + 1]; // 얻는 기쁨

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			J[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N + 1][99 + 1]; // 체력이 0이되면 안되므로 99가 최대
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < 100; j++) {
				if (L[i] <= j) { // 인사 할 체력이 남아있다면
					dp[i][j] = Math.max(dp[i - 1][j - L[i]] + J[i], dp[i - 1][j]);
				} else { // 인사 할 체력이 없다면
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[N][99]);
	}

}
