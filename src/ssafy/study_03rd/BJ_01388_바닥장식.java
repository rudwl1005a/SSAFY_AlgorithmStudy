package ssafy.study_03rd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 S4 ( https://www.acmicpc.net/problem/1388 )
 */
public class BJ_01388_바닥장식 {
	// BFS로 풀기

	static int N, M, count;
	static char[][] map;
	static boolean[][] visit;
	static int[] temp = new int[2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		bfs();
	}

	private static void bfs() {
		// 초기화
		Queue<int[]> q = new LinkedList<>();
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j])
					continue;

				temp[0] = i;
				temp[1] = j;
				q.offer(temp);

				while (!q.isEmpty()) {
					int[] temp = q.poll();

					if (map[temp[0]][temp[1]] == '-') { // '-'라면 오른쪽으로만 확인
						int ni = temp[0];
						int nj = temp[1] + 1;
						if (nj >= M || visit[ni][nj] || map[ni][nj] == '|')
							break;
						visit[ni][nj] = true;
						temp[0] = ni;
						temp[1] = nj;
						q.offer(temp);
					} else { // '|' 라면 아래로만 확인
						int ni = temp[0] + 1;
						int nj = temp[1];
						if (ni >= N || visit[ni][nj] || map[ni][nj] == '-')
							break;
						visit[ni][nj] = true;
						temp[0] = ni;
						temp[1] = nj;
						q.offer(temp);
					}
				}
				count++;
			}
		}

		System.out.println(count);
	}

}
