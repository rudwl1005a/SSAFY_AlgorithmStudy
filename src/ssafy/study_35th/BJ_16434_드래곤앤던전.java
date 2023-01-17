package ssafy.study_35th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/16434 )
 */
public class BJ_16434_드래곤앤던전 {

	static int N;
	static long atk, maxHp, curHp = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 방의 개수
		atk = Long.parseLong(st.nextToken()); // 공격력

		maxHp = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken()); // 1이면 몬스터 2면 포션
			int a = Integer.parseInt(st.nextToken()); // 몬스터 공격력/공격력 증가
			int h = Integer.parseInt(st.nextToken()); // 몬스터 체력/생명력 회복

			if (type == 1) { // 몬스터
				if (h % atk == 0) { // 나머지가 없으면 한번 덜 맞는다
					curHp += (long) (((h / atk) - 1) * a);
				} else {
					curHp += (long) ((h / atk) * a);
				}
			} else { // 포션
				atk += a;
				curHp = curHp - h < 1 ? 1 : curHp - h; // 0이하로 내려가지 않게
			}

			maxHp = Math.max(maxHp, curHp); // 최대값 갱신
		}

		System.out.println(maxHp);
	}

}
