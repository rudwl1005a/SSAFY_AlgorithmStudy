package ssafy.study_07th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/1941 )
 */
public class BJ_01941_소문난칠공주 {
	// 조합 + BFS로 문제 해결

	static int ans;
	static char[][] map = new char[5][5];
	static boolean[][] visit, visit2;

	// 조합
	static int[] tgt = new int[7];

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}

		comb(0, 0);

		System.out.println(ans);
	}

	private static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == 7) {
			int cnt = 0;
			for (int i = 0; i < 7; i++) {
				// 이다솜파인지 확인
				if (map[tgt[i] / 5][tgt[i] % 5] == 'S') {
					cnt++;
				}
			}

			// 이다솜파 우위인지 확인
			if (cnt >= 4) {
				bfs();
			}

			return;
		}
		if (srcIdx == 25) {
			return;
		}

		tgt[tgtIdx] = srcIdx;
		comb(srcIdx + 1, tgtIdx + 1); // src증가, tgt증가 : 현재 srcIdx를 tgt가 받아들이고 다음으로 간다.
		comb(srcIdx + 1, tgtIdx);
	}

	private static void bfs() {
		int cnt = 0;
		visit = new boolean[5][5];
		for (int i = 0; i < 7; i++) {
			visit[tgt[i] / 5][tgt[i] % 5] = true;
		}

		Queue<Node> q = new LinkedList<>();
		visit2 = new boolean[5][5];
		q.offer(new Node(tgt[0] / 5, tgt[0] % 5));
		visit2[tgt[0] / 5][tgt[0] % 5] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5 || visit2[ny][nx] || !visit[ny][nx]) {
					continue;
				}
				cnt++;
				visit2[ny][nx] = true;
				q.offer(new Node(ny, nx));
			}
		}
		
		if(cnt == 6) {
			ans++;
		}

	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

}
