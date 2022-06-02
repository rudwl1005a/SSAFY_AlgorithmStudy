package ssafy.study_04th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/2564 )
 * rekalux님의 코드 참고 ( https://www.acmicpc.net/source/22782801 )
 */
public class BJ_02564_경비원2 {

	static int W, H, S, ans;
	static int[] store;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); // 가로 길이
		H = Integer.parseInt(st.nextToken()); // 세로 길이
		S = Integer.parseInt(br.readLine()); // 상점 개수

		store = new int[S + 1]; // 왼쪽 위 꼭지점부터의 시계방향 거리 저장
		for (int i = 0; i < S + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			if (a == 1) {
				store[i] = p;
			} else if (a == 2) {
				store[i] = 2 * W + H - p;
			} else if (a == 3) {
				store[i] = 2 * W + 2 * H - p;
			} else if (a == 4) {
				store[i] = W + p;
			}
		}

		for (int i = 0; i < S; i++) {
			// 시계방향 반시계방향 중에 짧은 거리
			ans += Math.min(Math.abs(store[i] - store[S]), (2 * W + 2 * H) - Math.abs(store[i] - store[S]));
		}

		System.out.println(ans);
	}

}
