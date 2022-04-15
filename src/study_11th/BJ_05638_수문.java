package study_11th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/5638 )
 */
public class BJ_05638_수문 {

	static int N, M, V, T, min;
	static Door[] door;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		door = new Door[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			door[i] = new Door(f, c);
		}

		M = Integer.parseInt(br.readLine());
		for (int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 비워야하는 물 양
			T = Integer.parseInt(st.nextToken()); // 시간
			min = Integer.MAX_VALUE;
			sb.append("Case ").append(i).append(": ");
			comb(0, 0, 0, 0);
			sb.append(min == Integer.MAX_VALUE ? "IMPOSSIBLE" : min).append("\n");
		}
		System.out.println(sb);
	}

	private static void comb(int cnt, int start, int flag, int sum) {

		if (sum >= V) { // 수문이 비울 수 있는 총 합이 물 양보다 크거나 같다면 최소값 판별
			int sumC = 0;
			for (int i = 0; i < N; i++) {
				if ((flag & 1 << i) != 0) {
					sumC += door[i].c;
				}
			}
			min = Math.min(min, sumC);
		}

		if (cnt == N) { // N개를 뽑았으면 리턴
			return;
		}

		for (int i = start; i < N; i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}

			comb(cnt + 1, i + 1, flag | 1 << i, sum + door[i].f * T);
		}

	}

	static class Door {
		int f, c; // f : 유량, c : 피해비용

		public Door(int f, int c) {
			this.f = f;
			this.c = c;
		}
	}
}
