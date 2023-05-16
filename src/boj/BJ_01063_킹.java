package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1063 )
 */
public class BJ_01063_킹 {

	static int ky, kx, sy, sx;

	static int[] dy = { 0, 0, -1, 1, 1, 1, -1, -1 };
	static int[] dx = { 1, -1, 0, 0, 1, -1, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input = br.readLine().split(" ");

		kx = input[0].charAt(0) - 'A';
		ky = input[0].charAt(1) - '0' - 1;
		sx = input[1].charAt(0) - 'A';
		sy = input[1].charAt(1) - '0' - 1;

		int N = Integer.parseInt(input[2]);

		for (int i = 0; i < N; i++) {
			String order = br.readLine();

			List<Integer> pos = move(ky, kx, order);
			// 킹 움직였는데 범위밖일때 continue
			if (!check(pos.get(0), pos.get(1)))
				continue;

			// 킹 움직였는데 돌이랑 겹칠때 -> 킹이랑 같은 방향으로 돌 움직임
			if (pos.get(0) == sy && pos.get(1) == sx) {
				// 돌 이동시킨게 범위 안일때만 명령어 수행
				List<Integer> new_s = move(sy, sx, order);
				if (check(new_s.get(0), new_s.get(1))) {
					// 돌 이동 적용
					sy = new_s.get(0);
					sx = new_s.get(1);
					// 킹 이동 적용
					ky = pos.get(0);
					kx = pos.get(1);
				}

			} else {
				ky = pos.get(0);
				kx = pos.get(1);
			}

		}

		// 마지막 위치 출력
		sb.append((char) (kx + 65)).append(ky + 1).append("\n");
		sb.append((char) (sx + 65)).append(sy + 1).append("\n");
		System.out.print(sb);
	}

	// 범위 체크
	private static boolean check(int y, int x) {
		if (y < 0 || y >= 8 || x < 0 || x >= 8) {
			return false;
		}
		return true;
	}

	private static List<Integer> move(int y, int x, String o) {
		int ny = 0, nx = 0;
		List<Integer> pos = new ArrayList<Integer>();
		switch (o) {
		case "R":// 오른쪽
			ny = y + dy[0];
			nx = x + dx[0];
			break;
		case "L":// 왼쪽
			ny = y + dy[1];
			nx = x + dx[1];
			break;
		case "B":// 아래
			ny = y + dy[2];
			nx = x + dx[2];
			break;
		case "T":
			ny = y + dy[3];
			nx = x + dx[3];
			break;
		case "RT":
			ny = y + dy[4];
			nx = x + dx[4];
			break;
		case "LT":
			ny = y + dy[5];
			nx = x + dx[5];
			break;
		case "RB":
			ny = y + dy[6];
			nx = x + dx[6];
			break;
		case "LB":
			ny = y + dy[7];
			nx = x + dx[7];
			break;

		}
		pos.add(ny);
		pos.add(nx);

		return pos;

	}
}
