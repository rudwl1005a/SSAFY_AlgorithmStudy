package study_3rd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S4 ( https://www.acmicpc.net/problem/1388 )
 */
public class BJ_01388_바닥장식2 {
	// DFS로 풀기

	static int N, M, count;
	static char[][] map;
	static boolean[][] visit;

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

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j])
					continue;
				dfs(i, j);
				count++;
			}
		}

		System.out.println(count);
	}

	private static void dfs(int i, int j) {
		if (map[i][j] == '-') { // '-'라면 오른쪽으로만 확인
			int ni = i;
			int nj = j + 1;
			if (nj >= M || visit[ni][nj] || map[ni][nj] == '|')
				return;
			visit[ni][nj] = true;
			dfs(ni, nj);
		} else { // '|' 라면 아래로만 확인
			int ni = i + 1;
			int nj = j;
			if (ni >= N || visit[ni][nj] || map[ni][nj] == '-')
				return;
			visit[ni][nj] = true;
			dfs(ni, nj);
		}
	}

}
