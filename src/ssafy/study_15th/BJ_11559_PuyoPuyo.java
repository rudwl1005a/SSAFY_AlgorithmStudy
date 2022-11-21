package ssafy.study_15th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/11559 )
 */
public class BJ_11559_PuyoPuyo {

	static int answer = 0;
	static char[][] map = new char[12][6];
	static boolean[][] visited = new boolean[12][6];
	
	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 12; i++) {
			String str = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		while (true) {
			for (int i = 0; i < 12; i++) {
				Arrays.fill(visited[i], false);
			}
			int count = 0;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (!visited[i][j] && map[i][j] != '.') {
						if (bfs(i, j)) {
							count++;
						}
					}
				}
			}

			if (count == 0) {
				break;
			}
			answer++;
			gravity();
		}
		System.out.println(answer);
	}

	static boolean bfs(int r, int c) {
		Queue<Position> queue = new LinkedList<>();
		List<Position> list = new ArrayList<>();
		queue.offer(new Position(r, c));
		list.add(new Position(r, c));
		visited[r][c] = true;
		char color = map[r][c];
		while (!queue.isEmpty()) {
			Position temp = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = temp.r + dy[d];
				int nc = temp.c + dx[d];

				if (isIn(nr, nc) && map[nr][nc] == color && !visited[nr][nc]) {
					list.add(new Position(nr, nc));
					queue.offer(new Position(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}

		if (list.size() >= 4) {
			for (Position temp : list) {
				map[temp.r][temp.c] = '.';
			}
			return true;
		}
		return false;
	}

	static void gravity() {
		for (int j = 0; j < 6; j++) {
			for (int i = 11; i >= 0; i--) {
				if (map[i][j] != '.') {
					int nr = i;
					while (true) {
						nr++;
						if (isIn(nr, j) && map[nr][j] == '.') {
							map[nr][j] = map[nr - 1][j];
							map[nr - 1][j] = '.';
						} else {
							break;
						}
					}
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < 12 && c >= 0 && c < 6;
	}

	static class Position {
		int r, c;

		public Position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

}
