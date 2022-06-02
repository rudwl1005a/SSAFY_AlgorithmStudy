package ssafy.study_13th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/11054 )
 */
public class BJ_11054_가장긴바이토닉부분수열 {

	static int N, ans;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N];
		// 오름차순으로 LIS
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		// 내림차순으로 LIS
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ans = Math.max(ans, dp[i]);
		}

		System.out.println(ans);
	}

}
