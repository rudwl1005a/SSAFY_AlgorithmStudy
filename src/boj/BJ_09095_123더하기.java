package boj;

import java.io.*;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/9095 )
 */
public class BJ_09095_123더하기 {

	static int T, N, dp[];

	public static void main_old(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dp = new int[11];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i < 11; i++) {
			dp[i] += dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for(int i = 4; i < 12; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		// 출력
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			sb.append(dp[N] + "\n");
		}
		sb.delete(sb.length() - 1, sb.length());
		bw.write(sb.toString());

		bw.flush();
		bw.close();
	}
}
