package ssafy.study_41st;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G2 ( https://www.acmicpc.net/problem/17136 )
 */
public class BJ_17136_색종이붙이기 {

	static int map[][], paper[], ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[10][10]; // 종이
		paper = new int[6]; // 색종이

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.fill(paper, 5);
		ans = Integer.MAX_VALUE;
		solve(0, 0, 0);

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	private static void solve(int y, int x, int cnt) {
		if (y == 9 && x == 10) { // 마지막
			ans = Math.min(ans, cnt);
			return;
		}
		if (x == 10) { // 아래로 이동
			solve(y + 1, 0, cnt);
			return;
		}
		if (cnt >= ans)
			return;

		if (map[y][x] == 1) {
			for (int k = 5; k >= 1; k--) {
				if (isPossible(y, x, k) && paper[k] > 0) {
					cover(y, x, k);
					paper[k]--;
					solve(y, x + 1, cnt + 1);
					uncover(y, x, k);
					paper[k]++;
				}
			}
		} else { // 1 없으면 옆으로 이동
			solve(y, x + 1, cnt);
		}
	}

	private static void cover(int y, int x, int k) {
		for (int i = y; i < y + k; i++) {
			for (int j = x; j < x + k; j++) {
				map[i][j] = 0;
			}
		}
	}

	private static void uncover(int y, int x, int k) {
		for (int i = y; i < y + k; i++) {
			for (int j = x; j < x + k; j++) {
				map[i][j] = 1;
			}
		}
	}

	private static boolean isPossible(int y, int x, int k) {
		for (int i = y; i < y + k; i++) {
			for (int j = x; j < x + k; j++) {
				if (i >= 10 || j >= 10 || map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

}
