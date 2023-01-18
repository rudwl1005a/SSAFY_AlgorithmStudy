package ssafy.study_35th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/19644 )
 */
public class BJ_19644_좀비떼가기관총진지에도오다니 {

	static int L, Ml, Mk, C, map[], Bomb;
	static boolean Bomber[], flag = true;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		L = Integer.parseInt(br.readLine()); // 진지 거리
		StringTokenizer st = new StringTokenizer(br.readLine());
		Ml = Integer.parseInt(st.nextToken()); // 유효사거리
		Mk = Integer.parseInt(st.nextToken()); // 기관총 데미지
		C = Integer.parseInt(br.readLine()); // 지뢰 개수
		map = new int[L];
		Bomber = new boolean[L];

		int start = -Ml + 1;
		int end = 0;
		int shootDam = 0;
		int fullDam = Mk * Ml;
		Bomb = Ml - 1; // 빈칸이거나 지뢰로 죽인 좀비 개수
		while (true) {
			map[end] = Integer.parseInt(br.readLine());
			shootDam = fullDam - Bomb * Mk;
			if (shootDam < map[end]) { // 좀비를 죽일 수 없다면
				if (--C < 0) { // 지뢰 개수 하나 줄이고, 0보다 작다면 시뮬 끝
					flag = false;
					break;
				}
				Bomb++; // 지뢰로 죽인 개수 증가
				Bomber[end] = true; // end번째를 지뢰로 죽임
			}
			if (start < 0 || Bomber[start]) { // 지나간 것 체크
				Bomb--;
			}
			start++;
			if (++end == L) { // 끝까지 갔으면 시뮬 끝
				break;
			}
		}

		System.out.println(flag ? "YES" : "NO");
	}

}
