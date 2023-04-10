package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1749 )
 */
public class BJ_01749_점수따먹기 {

	static int N, M, map[][], ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 구간 합 구하기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = map[i][j] + map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
			}
		}

		// 최대값 구하기
		ans = -400000000;
		for (int x1 = 1; x1 <= N; x1++) {
			for (int y1 = 1; y1 <= M; y1++) {
				for (int x2 = x1; x2 <= N; x2++) {
					for (int y2 = y1; y2 <= M; y2++) {
						ans = Math.max(ans, map[x2][y2] - map[x1 - 1][y2] - map[x2][y1 - 1] + map[x1 - 1][y1 - 1]);
					}
				}
			}
		}

		System.out.println(ans);
	}

}
