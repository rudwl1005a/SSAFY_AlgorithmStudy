package study_06th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/17144 )
 */
public class BJ_17144_미세먼지안녕 {

	static int R, C, T, ans;
	static int[][] map, tmp;
	static int c1 = -1, c2 = -1; // 공기청정기 y좌표

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		T = Integer.parseInt(st.nextToken()); // 진행 시간

		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					if (c1 == -1) {
						c1 = i; // 위쪽 공기청정기 좌표
					} else {
						c2 = i; // 아래쪽 공기청정기 좌표
					}
				}
			}
		}

		for (int i = 0; i < T; i++) {
			spread(); // 확산
			clean1(); // 위쪽 공기청정기
			clean2(); // 아래쪽 공기청정기
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ans += map[i][j];
			}
		}

		System.out.println(ans + 2);
	}

	private static void spread() {

		tmp = new int[R][C];
		copyMap(tmp, map);

		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				int cnt = 0; // 확산된 수
				if (map[y][x] > 0) {
					for (int d = 0; d < 4; d++) {
						int ny = y + dy[d];
						int nx = x + dx[d];

						if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == -1) {
							continue;
						}

						tmp[ny][nx] += map[y][x] / 5;
						cnt++;
					}
					tmp[y][x] -= (map[y][x] / 5 * cnt);
				}
			}
		}

		copyMap(map, tmp);
	}

	private static void copyMap(int[][] to, int[][] from) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				to[i][j] = from[i][j];
			}
		}
	}

	private static void clean1() { // 위쪽 공기청정기 반시계방향 순회
		int sy = c1 - 1;
		int sx = 0;

		// 좌
		for (int i = sy; i > 0; i--) {
			map[i][sx] = map[i - 1][sx];
		}
		sy = 0;

		// 상
		for (int i = sx; i < C - 1; i++) {
			map[sy][i] = map[sy][i + 1];
		}
		sx = C - 1;

		// 우
		for (int i = sy; i < c1; i++) {
			map[i][sx] = map[i + 1][sx];
		}
		sy = c1;

		// 하
		for (int i = sx; i > 0; i--) {
			if (map[sy][i - 1] == -1) {
				map[sy][i] = 0;
				continue;
			}
			map[sy][i] = map[sy][i - 1];
		}

	}

	private static void clean2() { // 아래쪽 공기청정기 시계방향 순회
		int sy = c2 + 1;
		int sx = 0;

		// 좌
		for (int i = sy; i < R - 1; i++) {
			map[i][sx] = map[i + 1][sx];
		}
		sy = R - 1;

		// 하
		for (int i = sx; i < C - 1; i++) {
			map[sy][i] = map[sy][i + 1];
		}
		sx = C - 1;

		// 우
		for (int i = sy; i > c2; i--) {
			map[i][sx] = map[i - 1][sx];
		}
		sy = c2;

		// 상
		for (int i = sx; i > 0; i--) {
			if (map[sy][i - 1] == -1) {
				map[sy][i] = 0;
				continue;
			}
			map[sy][i] = map[sy][i - 1];
		}

	}

}
