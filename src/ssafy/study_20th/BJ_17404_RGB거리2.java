package ssafy.study_20th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/17404 )
 */
public class BJ_17404_RGB거리2 {

	static int N, ans;
	static int[] min;
	static int[][] map, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][3];
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken()); // red
			map[i][1] = Integer.parseInt(st.nextToken()); // green
			map[i][2] = Integer.parseInt(st.nextToken()); // blue
		}

		min = new int[3]; // 0: 첫집이 red, 1 : 첫집이 green, 2 : 첫 집이 blue일 때,
		for (int i = 0; i < 3; i++) {
			dp = new int[N + 1][3];
			for (int j = 0; j < 3; j++) {
				if (i == j) dp[1][j] = map[1][j];
				else dp[1][j] = 1001;
			}

			for (int j = 2; j <= N; j++) {
				dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + map[j][0];
				dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + map[j][1];
				dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + map[j][2];
			}

			if (i == 0) min[0] = Math.min(dp[N][1], dp[N][2]); // 처음 집이 red일때는 N번째 집이 green또는 blue일때만
			else if (i == 1) min[1] = Math.min(dp[N][0], dp[N][2]); // 처음 집이 green일때는 N번째 집이 red or blue
			else if (i == 2) min[2] = Math.min(dp[N][0], dp[N][1]); // 처음 집이 blud -> N번째 집 red or green
		}

		System.out.println(Math.min(Math.min(min[0], min[1]), min[2]));

	}

}
