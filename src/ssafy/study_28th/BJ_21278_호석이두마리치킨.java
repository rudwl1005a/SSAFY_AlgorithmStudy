package ssafy.study_28th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/21278 )
 */
public class BJ_21278_호석이두마리치킨 {

	static int N, M, minX, minY, min, map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];

		// map초기화
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (i == j)
					continue;
				map[i][j] = 1000000;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1;
		}

		// 플로이드 워샬 알고리즘
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				for (int k = 1; k < N + 1; k++) {
					map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
				}
			}
		}

		minX = Integer.MAX_VALUE;
		minY = Integer.MAX_VALUE;
		min = Integer.MAX_VALUE;

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				int dist = distance(i, j);
				if (min > dist) { // 최솟값 갱신
					minX = i;
					minY = j;
					min = dist;
				}
			}
		}

		System.out.println(minX + " " + minY + " " + min * 2);
	}

	private static int distance(int x, int y) {
		int result = 0;
		for (int i = 1; i <= N; i++) {
			result += Math.min(map[x][i], map[y][i]);
		}

		return result;
	}

}
