package ssafy.study_29th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1563 )
 */
public class BJ_01563_개근상 {

	static int N, dp[][][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new int[3][4][N + 1]; // dp[지각한 횟수][연속으로 결석한 횟수][날짜]

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		System.out.println(solve(0, 0, 0));
	}

	private static int solve(int late, int absent, int day) {
		if(dp[late][absent][day] != -1) return dp[late][absent][day];
		if(late > 1 || absent == 3) return 0; // 전에 지각했거나 결석 연속으로 3일이면 안됨
		if(day > N-1) return 1;
		
		dp[late][absent][day] = solve(late+1, 0, day+1) +		/* 지각 */
								solve(late, absent+1, day+1) +	/* 결석 */
								solve(late, 0, day+1);			/* 출석 */
		
		return dp[late][absent][day] % 1000000;
	}

}
