package boj;

import java.io.*;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/11727 )
 */
public class BJ_11727_2xN타일링2 {

	static int N, dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];

		dp[0] = 1;
		dp[1] = 1;

		for(int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
		}

		bw.write(dp[N] + "\n");

		bw.flush();
		bw.close();
	}

	public static void main_old(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new int[1001];

		dp[1] = 1;
		dp[2] = 3;

		// dp[i]는 i-1번째의 경우의 수에서 세로로 하나, i-2번째 경우의 수에서 가로로 두개를 세운 경우, i-2번째 경우의 수에서 2*2 하나를 세운 경우의 합과 같다
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 2]) % 10007;
		}

		System.out.println(dp[N]);
	}

}
