package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/11726 )
 */
public class BJ_11726_2xN타일링 {

	static int N, dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new int[1001];

		dp[1] = 1;
		dp[2] = 2;

		// dp[i]는 i-1번째의 경우의 수에서 세로로 하나, i-2번째 경우의 수에서 가로로 두개를 세운 경우의 합과 같다
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}

		System.out.println(dp[N]);
	}

}
