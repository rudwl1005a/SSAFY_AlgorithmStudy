package ssafy.study_34th;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/7682 )
 */
public class BJ_07682_틱택토 {

	static char map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String s = br.readLine();
			if (s.equals("end")) break;
			map = new char[3][3];
			for (int i = 0; i < 9; i++) {
				map[i / 3][i % 3] = s.charAt(i);
			}

			sb.append(tictactoe()).append("\n");
		}

		System.out.println(sb);
	}

	private static String tictactoe() {

		// x의 개수, o의 개수, 꽉찼는지 확인
		int x = 0;
		int o = 0;
		boolean full = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[i][j] == '.') full = false;
				else if (map[i][j] == 'X') x++;
				else o++;
			}
		}

		if (full) { // 꽉찼다면 X가 무조건 이기거나 승부가 안나야함
			if ((check('X') && !check('O')) || (!check('X') && !check('O'))) {
				if (x == (o + 1)) {
					return "valid";
				} else {
					return "invalid";
				}
			} else {
				return "invalid";
			}
		} else { // 꽉차지 않았다면
			if (check('X') && check('O')) { // 둘다 이길 수는 없다
				return "invalid";
			} else if (check('X') && !check('O')) { // x가 이겼다면
				if (x == (o + 1)) { // x의 개수가 무조건 하나가 더 많아야한다
					return "valid";
				} else {
					return "invalid";
				}
			} else if (!check('X') && check('O')) { // o가 이겼다면
				if (x == o) { // 개수가 같아야한다
					return "valid";
				} else {
					return "invalid";
				}
			} else { // 둘다 못이겼다면
				return "invalid";
			}
		}
	}

	private static boolean check(char c) {
		// 가로 체크
		for (int i = 0; i < 3; i++) {
			if (map[i][0] == c && map[i][1] == c && map[i][2] == c) {
				return true;
			}
		}

		// 세로 체크
		for (int i = 0; i < 3; i++) {
			if (map[0][i] == c && map[1][i] == c && map[2][i] == c) {
				return true;
			}
		}

		// 대각선 체크
		if (map[0][0] == c && map[1][1] == c && map[2][2] == c) {
			return true;
		}
		if (map[0][2] == c && map[1][1] == c && map[2][0] == c) {
			return true;
		}

		return false;
	}

}
