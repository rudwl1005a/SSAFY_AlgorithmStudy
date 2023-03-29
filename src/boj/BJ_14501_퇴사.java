package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/14501 )
 */
public class BJ_14501_퇴사 {

	static int N, input[][], dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		input = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken()); // 상담을 완료하는데 걸리는 기간
			input[i][1] = Integer.parseInt(st.nextToken()); // 상담을 했을 때 받을 수 있는 금액
		}

		dp = new int[N + 1];
		for (int i = 0; i < N; i++) {
			if (i + input[i][0] <= N) {
				dp[i + input[i][0]] = Math.max(dp[i + input[i][0]], dp[i] + input[i][1]);
			}
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		System.out.println(dp[N]);
	}

}
