package ssafy.study_29th;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/2156 )
 */
public class BJ_02156_포도주시식 {

	static int N, dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new int[4][N]; // 0 : o o / 1 : o x / 2 : x o / 3 : x x

		int n = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println(n);
			return;
		} else if (N == 2) {
			int m = Integer.parseInt(br.readLine());
			System.out.println(n + m);
			return;
		}

		dp[0][0] = n;
		dp[1][0] = n;
		dp[2][0] = 0;
		dp[3][0] = 0;
		int m = Integer.parseInt(br.readLine());
		dp[0][1] = n + m;
		dp[1][1] = n;
		dp[2][1] = m;
		dp[3][1] = 0;

		/*
		 *  이전 두개 	-> 이번에 포도주 먹을 수 있나? 
		 *   o o	-> x  
		 *   o x	-> o/x
		 *   x o 	-> o/x
		 *   x x 	-> o/x
		 *  이 다섯가지의 경우의 수를 저장해 나가면서 최대값 저장
		 *  n-1번째에 o n번째 o 면 dp[0][n]에 저장, o x : dp[1][n], x o : dp[2][n], x x : dp[3][n]에 저장하는 식으로
		 */
		for (int i = 2; i < N; i++) {
			int k = Integer.parseInt(br.readLine());
			dp[0][i] = dp[2][i - 1] + k;
			dp[1][i] = Math.max(dp[0][i - 1], dp[2][i - 1]);
			dp[2][i] = Math.max(dp[1][i - 1] + k, dp[3][i - 1] + k);
			dp[3][i] = Math.max(dp[1][i - 1], dp[3][i - 1]);
		}

		System.out.println(Math.max(dp[0][N - 1], Math.max(dp[1][N - 1], Math.max(dp[2][N - 1], dp[3][N - 1]))));
	}

}
