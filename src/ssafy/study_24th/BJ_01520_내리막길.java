package ssafy.study_24th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/1520 )
 */
public class BJ_01520_내리막길 {

	static int M, N;
	static int[][] arr, dp;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { -1, 0, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[M + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[M + 1][N + 1]; // (x, y)에서 도착점으로 가는 경로의 개수
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = -1;
			}
		}

		sb.append(DFS(1, 1));
		System.out.println(sb);
		
	}

	public static int DFS(int x, int y) {
		if (x == M && y == N) {
			return 1;
		}

		if (dp[x][y] != -1) {
			return dp[x][y];
		}

		dp[x][y] = 0; // 현재 위치에서 끝점까지 도달하는 경로의 개수를 0으로 초기화.
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (nx < 1 || ny < 1 || nx > M || ny > N) {
				continue;
			}

			// arr[x][y]보다 arr[nx][ny]가 높이가 더 낮다면
			// arr[nx][ny]에서 끝점까지 도달하는 경로의 개수를 더한다.
			if (arr[x][y] > arr[nx][ny]) {
				dp[x][y] += DFS(nx, ny);
			}
		}

		return dp[x][y];
	}
}
