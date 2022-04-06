package study_09th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/3190 )
 */
public class BJ_03190_뱀 {

	static int N, K, L, time, dir, dCnt; // dir : 뱀의 방향, dCnt : 방향 바꾼 회수
	static int sy, sx; // sy,sx : 뱀의 머리좌표
	static int[][] map;
	static Rotate[] rotate;
	static Deque<Node> deque = new ArrayDeque<>();

	static int[] dy = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map[y][x] = 2; // 사과
		}
		L = Integer.parseInt(br.readLine());
		rotate = new Rotate[L];
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			rotate[i] = new Rotate(t, d);
		}
		dir = 1;
		deque.add(new Node(1, 1));
		sy = sx = 1;
		map[sy][sx] = 1; // 뱀

		do {
			time++;
		} while (dummy());

		System.out.println(time);
	}

	private static boolean dummy() {

		// 이동
		int ny = sy + dy[dir];
		int nx = sx + dx[dir];

		// 벽이거나 자신의 몸이면 게임 끝
		if (ny < 1 || nx < 1 || ny > N || nx > N || map[ny][nx] == 1) {
			return false;
		}

		if (map[ny][nx] == 2) { // 사과 먹었으면
			// 머리만 이동
			map[ny][nx] = 1;
			sy = ny;
			sx = nx;
			deque.addFirst(new Node(ny, nx));
		} else if (map[ny][nx] == 0) { // 사과 못먹었으면
			// 머리 이동
			map[ny][nx] = 1;
			sy = ny;
			sx = nx;
			deque.addFirst(new Node(ny, nx));

			// 꼬리도 이동
			Node node = deque.pollLast();
			map[node.y][node.x] = 0;
		}

		// 회전하는지 확인
		if (dCnt < L && rotate[dCnt].t == time) {
			if (rotate[dCnt].d == 'D') { // 오른쪽으로 회전
				dir = (dir + 1) % 4;
			}
			if (rotate[dCnt].d == 'L') { // 왼쪽으로 회전
				dir--;
				if (dir < 0) {
					dir = 3;
				}
			}
			dCnt++;
		}

		return true;
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static class Rotate {
		int t;
		char d;

		public Rotate(int t, char d) {
			this.t = t;
			this.d = d;
		}

	}
}
