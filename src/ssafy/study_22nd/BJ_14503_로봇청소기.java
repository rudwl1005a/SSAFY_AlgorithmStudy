package ssafy.study_22nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/14503 )
 */
public class BJ_14503_로봇청소기 {

	static int N, M, R, C, D, ans, map[][];

	static int[] dy = { -1, 0, 1, 0 }; // 북 동 남 서
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 초기 위치
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken()); // 초기 방향

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			// 1. 현재 위치 청소
			if (map[R][C] == 0) {
				ans++;
				map[R][C] = 2;
			}

			// 2. 현재 위치 기준 왼쪽방향부터 확인 (북->서 / 서->남 / 남->동 / 동->북)
			boolean clean = false;
			for (int i = 0; i < 4; i++) {
				// 2-1. 왼쪽 청소가능하면 한칸 전진
				D = (D + 3) % 4;
				if (map[R + dy[D]][C + dx[D]] == 0) {
					R += dy[D];
					C += dx[D];
					clean = true;
					break;
				}
				// 2-2. 왼쪽 청소 불가능하면 한번더 회전
			}

			if (!clean) { // 2-3. 네 방향이 청소되었거나 벽이면 한칸 후진
				if (map[R + dy[(D + 2) % 4]][C + dx[(D + 2) % 4]] != 1) { // 후진 가능하면 방향 유지한채로 한칸 후진
					R += dy[(D + 2) % 4];
					C += dx[(D + 2) % 4];
				} else { // 2-4. 후진 할 수 없으면 종료
					break;
				}
			}
		}

		System.out.println(ans);
	}

}
