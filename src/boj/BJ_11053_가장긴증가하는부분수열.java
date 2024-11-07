package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S2 ( https://www.acmicpc.net/problem/11053 )
 */
public class BJ_11053_가장긴증가하는부분수열 {

	static int N, arr[], dp[], ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = 1;
		for (int i = 1; i < N; i++) {
			// 모든 수열의 길이는 최소 1
			dp[i] = 1;
			// i이전의 원소들 탐색
			for (int j = 0; j < i; j++) {
				// j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp보다 작거나 같은경우
				if (arr[j] < arr[i] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1; // 수열 증가하여 dp에 저장
				}
			}
		}

		for (int i : dp) {
			ans = Math.max(ans, i);
		}
		System.out.println(ans);
	}

}
