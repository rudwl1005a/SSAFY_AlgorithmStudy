package ssafy.study_09th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/17281 )
 */
public class BJ_17281_야구 {

	static int N, ans;
	static int[] src;
	static int[][] hit;
	static boolean[] select;
	static boolean[] ru;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = Integer.MIN_VALUE;
		hit = new int[N][9];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				hit[i][j] = Integer.parseInt(st.nextToken()); // 1~9번 타자 안타 종류
			}
		}

		src = new int[9];
		select = new boolean[9];

		// 1번은 4번타자 고정
		src[3] = 0;
		select[3] = true;

		perm(1);

		System.out.println(ans);
	}

	public static void perm(int tgtIdx) {
		if (tgtIdx == 9) {
			ans = Math.max(ans, countMaxScore());
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (select[i]) {
				continue;
			}
			select[i] = true;
			src[i] = tgtIdx;
			perm(tgtIdx + 1);
			select[i] = false;
		}
	}

	private static int countMaxScore() {
		int score = 0; // 점수
		int start = 0; // 시작 선수
		for (int i = 0; i < N; i++) { // 이닝 수
			ru = new boolean[3]; // 1루 2루 3루 사람 있는지 확인
			int out = 0; // 아웃 카운트
			while (out < 3) {
				// out
				if (hit[i][src[start]] == 0) { // 안타 못치면 out카운트 증가
					out++;
					start = (start + 1) % 9; // 다음타자 - 9번타자 이후에는 다시 처음부터
					continue;
				}

				// hit
				if (hit[i][src[start]] == 1) { // 1루타
					if (ru[2]) { // 3루는 득점
						score++;
						ru[2] = false;
					}
					for (int j = 1; j >= 0; j--) { // 2,1루는 한칸씩 전진
						if (ru[j]) {
							ru[j + 1] = true;
							ru[j] = false;
						}
					}
					ru[0] = true; // 친사람 1루
				} else if (hit[i][src[start]] == 2) { // 2루타
					for (int j = 2; j > 0; j--) { // 3,2루는 득점
						if (ru[j]) {
							score++;
							ru[j] = false;
						}
					}
					if (ru[0]) { // 1루는 두칸 전진
						ru[2] = true;
						ru[0] = false;
					}
					ru[1] = true; // 친사람 2루
				} else if (hit[i][src[start]] == 3) { // 3루타
					for (int j = 2; j >= 0; j--) { // 3,2,1루 득점
						if (ru[j]) {
							score++;
							ru[j] = false;
						}
					}
					ru[2] = true; // 친사람 3루
				} else if (hit[i][src[start]] == 4) { // 홈런
					for (int j = 2; j >= 0; j--) { // 3,2,1루 득점
						if (ru[j]) {
							score++;
							ru[j] = false;
						}
					}
					score++; // 친사람 득점
				}

				start = (start + 1) % 9; // 다음타자 - 9번타자 이후에는 다시 처음부터
			}
		}

		return score;
	}

}
