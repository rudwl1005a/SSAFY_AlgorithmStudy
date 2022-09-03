package ssafy.study_26th;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/2140 )
 */
public class BJ_02140_지뢰찾기 {

	static int N, ans;
	static char map[][];

	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 팔방탐색 -> 상에서부터 시계방향
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int y = 1; y < N - 1; y++) {
			for (int x = 1; x < N - 1; x++) {
				// 8방 탐색중에 0이 있다면 지뢰가 들어갈 수 없다
				boolean flag = true;
				for (int d = 0; d < 8; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if (map[ny][nx] == '0') flag = false;
				}
				if (!flag) continue;

				// 지뢰가 들어갈 수 있다면
				for (int d = 0; d < 8; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if (map[ny][nx] == '#') continue;
					map[ny][nx] = (char) ((int) (map[ny][nx]) - 1);
				}
				ans++;
			}
		}

		System.out.println(ans);

	}

}
