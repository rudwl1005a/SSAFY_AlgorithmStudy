package ssafy.study_43rd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/17370 )
 */
public class BJ_17370_육각형우리속의개미 {

	static int N, ans;
	static boolean visit[][];

	// 육각형 움직임 위(0), 오른쪽 위(1), 오른쪽 아래(2), 아래(3), 왼쪽 아래(4), 왼쪽 위(5)
	static int[] dy = { -1, -1, 1, 1, 1, -1 };
	static int[] dx = { 0, 1, 1, 0, -1, -1 };
	// 육각형 움직임 후 다음 움직임 저장
	// 0 -> 1, 5 / 1 -> 0, 2 / 2 -> 1, 3 / 3 -> 2, 4 / 4 -> 3, 5 / 5 -> 0, 4
	static int dir[][] = { { 1, 5 }, { 0, 2 }, { 1, 3 }, { 2, 4 }, { 3, 5 }, { 0, 4 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		// 5이하는 다시 돌아올 수 없다
		if (N < 5) {
			System.out.println(0);
			return;
		}

		visit = new boolean[45][45]; // 최대 이동거리가 22이므로 크기 45로 잡기
		visit[23][22] = true; // 시작점 체크
		dfs(22, 22, 0, 0); // 위로 먼저

		System.out.println(ans);

	}

	private static void dfs(int y, int x, int cnt, int d) { // y,x : 좌표, cnt : 이동 횟수, d : 이전 방향
		if (cnt == N) {
			if (visit[y][x]) {
				ans++;
			}
			return;
		}
		if (visit[y][x]) return;

		visit[y][x] = true;
		dfs(y + dy[dir[d][0]], x + dx[dir[d][0]], cnt + 1, dir[d][0]);
		dfs(y + dy[dir[d][1]], x + dx[dir[d][1]], cnt + 1, dir[d][1]);
		visit[y][x] = false;

	}

}
