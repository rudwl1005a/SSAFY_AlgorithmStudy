package study_12th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/16954 )
 */
public class BJ_16954_움직이는미로탈출 {

	static char[][] map;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static boolean ans;

	static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1, 0 }; // 상, 하, 좌, 우, 좌상, 우상, 좌하, 우하, 제자리
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[8][];
		for (int i = 0; i < 8; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
			for (int j = 0; j < 8; j++) {
				if (map[i][j] == '#') {
					pq.offer(new Node(i, j));
				}
			}
		}

		bfs();

		System.out.println(ans ? 1 : 0);

	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();

		q.offer(new Node(7, 0));

		while (!q.isEmpty()) {

			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node node = q.poll();

				if (node.y == 0 && node.x == 7) {
					ans = true;
					return;
				}

				// 움직임
				for (int d = 0; d < 9; d++) {
					int ny = node.y + dy[d];
					int nx = node.x + dx[d];

					if (ny < 0 || nx < 0 || ny >= 8 || nx >= 8 || map[ny][nx] == '#') {
						continue;
					}

					if (ny - 1 > 0 && map[ny - 1][nx] == '#') { // 바로 위가 #이라면
						continue;
					}

					q.offer(new Node(ny, nx));
				}
			}

			// 맵 이동
			move();

		}
	}

	private static void move() {
		PriorityQueue<Node> temp = new PriorityQueue<>();

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			map[node.y][node.x] = '.';

			int ny = node.y + 1;
			if (ny == 8) { // 가장 아래에 있어서 아래에 행이 없다면 벽이 없어진다
				continue;
			}
			map[ny][node.x] = '#';

			temp.offer(new Node(ny, node.x));
		}

		while (!temp.isEmpty()) {
			pq.offer(temp.poll());
		}

	}

	static class Node implements Comparable<Node> {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(Node o) { // y좌표 내림차순, 같으면 x좌표 내림차순
			return o.y == this.y ? o.x - this.x : o.y - this.y;
		}

	}
}
