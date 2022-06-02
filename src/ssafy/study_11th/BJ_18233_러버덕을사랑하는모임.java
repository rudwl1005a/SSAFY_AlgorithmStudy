package ssafy.study_11th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/18233 )
 */
public class BJ_18233_러버덕을사랑하는모임 {

	static int N, P, E;
	static int[][] take;
	static int[] ans;
	static boolean isFound;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 회원 수
		P = Integer.parseInt(st.nextToken()); // 인형 주는 사람 수
		E = Integer.parseInt(st.nextToken()); // 줄 인형 수

		take = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			take[i][0] = Integer.parseInt(st.nextToken());
			take[i][1] = Integer.parseInt(st.nextToken());
		}

		ans = new int[N];
		comb(0, 0, 0);

		if (isFound) {
			for (int i = 0; i < N; i++) {
				System.out.print(ans[i] + " ");
			}
		} else {
			System.out.println(-1);
		}
	}

	private static void comb(int cnt, int start, int flag) {

		if (cnt == P) { // P명 뽑음
			int min = 0;
			int max = 0;
			for (int i = 0; i < N; i++) {
				if ((flag & 1 << i) != 0) { // 뽑힌 사람이면
					min += take[i][0];
					max += take[i][1];
				}
			}

			if (max < E || E < min) { // 줄수 있는 최대의 수가 E보다 작거나, 줄수 있는 최소의 수가 E보다 크다면 조건을 충족하지 못한다.
				return;
			}

			// 각자 최소갯수만큼 준 나머지 재분배
			int remain = E - min;
			for (int i = 0; i < N; i++) {
				if ((flag & 1 << i) != 0) {
					ans[i] = take[i][0]; // 최소 갯수만큼 나눔

					if (remain <= 0) { // 남은 갯수가 없다면 재분배 안함
						continue;
					}

					// 재분배
					int more = take[i][1] - take[i][0]; // 각자 더 받을 수 있는 갯수
					if (remain <= more) { // 남은 갯수가 더 받을 수 있는 갯수보다 작거나 같으면 모두 몰아줌
						ans[i] += remain;
						remain -= more;
					} else { // 남은 갯수가 더 받을 수 있는 갯수보다 크다면 전부 받고 진행
						ans[i] += more;
						remain -= more;
					}
				}
			}

			isFound = true; // 한개만 출력
			return;
		}

		for (int i = start; i < N; i++) {
			if ((flag & 1 << i) != 0 || isFound) {
				continue;
			}
			comb(cnt + 1, i + 1, flag | 1 << i);
		}
	}

}
