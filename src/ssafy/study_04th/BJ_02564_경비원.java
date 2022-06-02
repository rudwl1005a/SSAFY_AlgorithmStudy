package ssafy.study_04th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/2564 )
 */
public class BJ_02564_경비원 {

	static int W, H, S, dg0, dg1, ans;
	static int[][] store;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); // 가로 길이
		H = Integer.parseInt(st.nextToken()); // 세로 길이
		S = Integer.parseInt(br.readLine()); // 상점 개수

		store = new int[S][2]; // index 0 : 북남서동, 1 : 거리
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			store[i][0] = Integer.parseInt(st.nextToken());
			store[i][1] = Integer.parseInt(st.nextToken());
		}

		// 동근이
		st = new StringTokenizer(br.readLine());
		dg0 = Integer.parseInt(st.nextToken()); // 동근이 위치
		dg1 = Integer.parseInt(st.nextToken()); // 동근이 거리

		if (dg0 == 1) {
			for (int i = 0; i < S; i++) {
				if (store[i][0] == 1) {
					ans += Math.abs(dg1 - store[i][1]);
				} else if (store[i][0] == 2) {
					// 최소
					ans += Math.min(dg1 + H + store[i][1], (W - dg1) + H + (W - store[i][1]));
				} else if (store[i][0] == 3) {
					ans += dg1 + store[i][1];
				} else if (store[i][0] == 4) {
					ans += (W - dg1) + store[i][1];
				}
			}
		} else if (dg0 == 2) {
			for (int i = 0; i < S; i++) {
				if (store[i][0] == 1) {
					// 최소
					ans += Math.min(dg1 + H + store[i][1], (W - dg1) + H + (W - store[i][1]));
				} else if (store[i][0] == 2) {
					ans += Math.abs(dg1 - store[i][1]);
				} else if (store[i][0] == 3) {
					ans += dg1 + (H - store[i][1]);
				} else if (store[i][0] == 4) {
					ans += (W - dg1) + (H - store[i][1]);
				}
			}
		} else if (dg0 == 3) {
			for (int i = 0; i < S; i++) {
				if (store[i][0] == 1) {
					ans += dg1 + store[i][1];
				} else if (store[i][0] == 2) {
					ans += (H - dg1) + store[i][1];
				} else if (store[i][0] == 3) {
					ans += Math.abs(dg1 - store[i][1]);
				} else if (store[i][0] == 4) {
					// 최소
					ans += Math.min(dg1 + W + store[i][1], (H - dg1) + W + (H - store[i][1]));
				}
			}
		} else if (dg0 == 4) {
			for (int i = 0; i < S; i++) {
				if (store[i][0] == 1) {
					ans += dg1 + (W - store[i][1]);
				} else if (store[i][0] == 2) {
					ans += (H - dg1) + (W - store[i][1]);
				} else if (store[i][0] == 3) {
					// 최소
					ans += Math.min(dg1 + W + store[i][1], (H - dg1) + W + (H - store[i][1]));
				} else if (store[i][0] == 4) {
					ans += Math.abs(dg1 - store[i][1]);
				}
			}
		}

		System.out.println(ans);

	}

}
