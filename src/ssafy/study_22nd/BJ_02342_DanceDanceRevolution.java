package ssafy.study_22nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/2342 )
 */
public class BJ_02342_DanceDanceRevolution {

	static int move[], dp[][][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		move = new int[input.length - 1];
		for (int i = 0; i < input.length - 1; i++) {
			move[i] = Integer.parseInt(input[i]);
		}

		dp = new int[5][5][input.length]; // 왼쪽방향, 오른쪽방향, 지시사항
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		System.out.println(solve(0, 0, 0));

	}

	static int solve(int left, int right, int cnt) {

		if (cnt == move.length) {
			return 0;
		}

		if (dp[left][right][cnt] != -1) {
			return dp[left][right][cnt];
		}

		dp[left][right][cnt] = Math.min(solve(move[cnt], right, cnt + 1) + energy(left, move[cnt]), solve(left, move[cnt], cnt + 1) + energy(right, move[cnt]));

		return dp[left][right][cnt];
	}

	static int energy(int pos, int des) {
		int num = Math.abs(pos - des);
		if (pos == 0) { // 중간에서 움직인 것이라면
			return 2;
		} else if (num == 0) { // 다시 한번 눌리는 것이라면
			return 1;
		} else if (num == 1 || num == 3) { // 인접한 지점으로 이동
			return 3;
		} else { // 반대편으로 이동
			return 4;
		}
	}

}
