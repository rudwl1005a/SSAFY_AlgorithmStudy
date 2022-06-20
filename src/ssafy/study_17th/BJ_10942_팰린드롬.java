package ssafy.study_17th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/10942 )
 */
public class BJ_10942_팰린드롬 {

	static int N, M;
	static int[] input;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		input = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			dp[i][i] = 1; // 길이가 1인것들은 팰린드롬
			if (input[i - 1] == input[i]) { // 바로 앞과 같으면 길이가 2인 팰린드롬
				dp[i - 1][i] = 1;
			}
		}

		// 길이가 2이상인 팰린드롬 찾기
		for (int i = 2; i < N; i++) { // i:길이
			for (int j = 1; j <= N - i; j++) { // 길이를 늘려가면서 맨앞 숫자와 맨 뒤 숫자를 확인하고 팰린드롬인지 확인
				if (input[j] == input[j + i] && dp[j + 1][j + i - 1] == 1) { // 맨 앞과 맨 뒤가 같고, 맨앞 + 1, 맨뒤 - 1이 팰린드롬이면 팰린드롬
					dp[j][j + i] = 1;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(dp[s][e]).append("\n");
		}
		System.out.println(sb);

	}

}
