package ssafy.study_20th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/18808 )
 */
public class BJ_18808_스티커붙이기 {

	static int N, M, K, ans = 0;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int[][] sticker = new int[r][c];

			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < c; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			find(sticker);
		}

		System.out.println(ans);
	}

	static void find(int[][] sticker) {
		int r = sticker.length;
		int c = sticker[0].length;

		for (int d = 0; d < 4; d++) {
			if (d != 0)
				sticker = rotate(sticker, r, c);
			r = sticker.length;
			c = sticker[0].length;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (i + r > N || j + c > M)
						break;

					if (put(i, j, r, c, sticker)) {
						return;
					}
				}
			}
		}
	}

	static boolean put(int x, int y, int r, int c, int[][] sticker) {
		for (int i = x; i < x + r; i++) {
			for (int j = y; j < y + c; j++) {
				if (map[i][j] == 1 && sticker[i - x][j - y] == 1)
					return false;
			}
		}

		for (int i = x; i < x + r; i++) {
			for (int j = y; j < y + c; j++) {
				if (sticker[i - x][j - y] == 1) {
					map[i][j] = 1;
					ans++;
				}
			}
		}

		return true;
	}

	static int[][] rotate(int[][] sticker, int r, int c) {
		int[][] newSticker = new int[c][r];

		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				newSticker[j][r - i - 1] = sticker[i][j];

		return newSticker;
	}
}
