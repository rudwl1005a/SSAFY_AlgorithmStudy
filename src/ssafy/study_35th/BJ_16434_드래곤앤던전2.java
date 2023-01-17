package ssafy.study_35th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/16434 )
 * 이분탐색 방법 해결 ( 56332KB, 640ms )
 */
public class BJ_16434_드래곤앤던전2 {

	static int N;
	static long atk;
	static Room[] rooms;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 방의 개수
		atk = Long.parseLong(st.nextToken()); // 공격력

		rooms = new Room[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			rooms[i] = new Room(type, a, h);
		}

		// 이분탐색
		long left = 0;
		long right = ((long) 2 << 62) - 1; // 적당히 큰 수
		while (left <= right) {

			long mid = (left + right) / 2;
			long tAtk = atk;
			long hp = mid;
			boolean end = false;

			for (int i = 0; i < N; i++) {
				if (rooms[i].type == 1) {
					// 체력 깎기
					if (rooms[i].h % tAtk == 0) {
						hp -= ((rooms[i].h / tAtk) - 1) * rooms[i].a;
					} else {
						hp -= (rooms[i].h / tAtk) * rooms[i].a;
					}
					// 체력 0이하면 끝
					if (hp <= 0) {
						end = true;
						break;
					}
				} else {
					hp += rooms[i].h;
					hp = hp > mid ? mid : hp;
					tAtk += rooms[i].a;
				}
			}
			if (end)
				left = mid + 1;
			else
				right = mid - 1;
		}

		System.out.println(left);
	}

	static class Room {
		int type, a, h; // type: 1이면 몬스터 2면 포션
						// a: 몬스터 공격력/공격력 증가
						// h: 몬스터 체력/생명력 회복

		public Room(int type, int a, int h) {
			super();
			this.type = type;
			this.a = a;
			this.h = h;
		}

	}
}
