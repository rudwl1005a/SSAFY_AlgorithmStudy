package ssafy.study_43rd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/1613 )
 */
public class BJ_01613_역사 {

	static int N, K, S;
	static boolean dist[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 사건의 개수
		K = Integer.parseInt(st.nextToken()); // 사건의 전후 관계의 개수

		dist = new boolean[N + 1][N + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dist[a][b] = true;
		}

		// 플로이드-와샬 알고리즘
		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (i == j) continue;
					if (dist[i][k] && dist[k][j]) { // k를 지나서 i -> j로 갈 수 있다면
						dist[i][j] = true;
					}
				}
			}
		}

		S = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (dist[a][b]) {
				sb.append(-1).append("\n");
			} else if (dist[b][a]) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}

		System.out.println(sb);

	}

}
