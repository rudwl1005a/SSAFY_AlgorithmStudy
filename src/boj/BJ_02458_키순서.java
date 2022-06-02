package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/2458 )
 */
public class BJ_02458_키순서 {

	static int N, M, ans;
	static int INF = 9999999;
	static int[][] tall;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생들 수
		M = Integer.parseInt(st.nextToken()); // 학생 키 비교 횟수

		tall = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				tall[i][j] = INF;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tall[a][b] = 1;
		}

		// 플로이드-와샬
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i == k)
					continue;
				for (int j = 1; j <= N; j++) {
					if (j == i || j == k)
						continue;
					tall[i][j] = Math.min(tall[i][j], tall[i][k] + tall[k][j]);
				}
			}
		}

		// 순회하면서 자기 자신 외에 키를 비교할 수 있는 사람이 N - 1명이면 자신의 키가 몇번째인지 알 수 있다.
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;
				if (tall[i][j] != INF || tall[j][i] != INF) {
					cnt++;
				}
			}

			if (cnt == N - 1) {
				ans++;
			}
		}

		System.out.println(ans);

	}
}
