package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/1584 )
 */
public class BJ_01584_게임 {

	static int N, M, ans;
	static boolean warn[][], visit[][];
	static ArrayDeque<int[]> dq = new ArrayDeque<>();

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		warn = new boolean[501][501];
		visit = new boolean[501][501];
		N = Integer.parseInt(st.nextToken()); // 위험구역 수
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int temp = -1;
			if (x1 > x2) {
				temp = x1;
				x1 = x2;
				x2 = temp;
			}
			if (y1 > y2) {
				temp = y1;
				y1 = y2;
				y2 = temp;
			}
			for (int j = x1; j <= x2; j++) {
				for (int j2 = y1; j2 <= y2; j2++) {
					warn[j][j2] = true;
				}
			}
		}

		M = Integer.parseInt(br.readLine()); // 죽음 구역 수
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int temp = -1;
			if (x1 > x2) {
				temp = x1;
				x1 = x2;
				x2 = temp;
			}
			if (y1 > y2) {
				temp = y1;
				y1 = y2;
				y2 = temp;
			}
			for (int j = x1; j <= x2; j++) {
				for (int j2 = y1; j2 <= y2; j2++) {
					visit[j][j2] = true;
				}
			}
		}

		ans = -1;
		warn[0][0] = false;
		visit[0][0] = true;
		dq.add(new int[] { 0, 0, 0 });
		while (!dq.isEmpty()) {
			int now[] = dq.poll();
			if (now[0] == 500 && now[1] == 500) {
				ans = now[2];
				break;
			}
			for (int d = 0; d < 4; d++) {
				int ny = now[0] + dy[d];
				int nx = now[1] + dx[d];
				if (ny < 0 || nx < 0 | ny > 500 || nx > 500 || visit[ny][nx])
					continue;

				if (warn[ny][nx]) {
					dq.addLast(new int[] { ny, nx, now[2] + 1 });
				} else {
					dq.addFirst(new int[] { ny, nx, now[2] });
				}
				visit[ny][nx] = true;
			}
		}
		System.out.println(ans);
	}
}
