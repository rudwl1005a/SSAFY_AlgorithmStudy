package ssafy.study_34th;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/20208 )
 */
public class BJ_20208_진우의민트초코우유 {

	static int N, M, H, ans, sy, sx, target[];
	static boolean select[];
	static List<Point> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 마을 크기
		M = Integer.parseInt(st.nextToken()); // 초기 체력
		H = Integer.parseInt(st.nextToken()); // 증가 체력 양

		// 정보 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1) {
					sy = i;
					sx = j;
				} else if (n == 2) {
					list.add(new Point(i, j));
				}
			}
		}

		target = new int[list.size()]; // 민트 순서 저장
		select = new boolean[list.size()]; // 중복 탐색 방지 위해
		perm(0);
		System.out.println(ans);
	}

	private static void perm(int tgtIdx) {
		if (tgtIdx == list.size()) {
			// 민트 순서에 따라 방문
			int hp = M; // 체력
			int cnt = 0; // 민초 먹은 개수
			Point now = new Point(sy, sx); // 현재 위치 저장
			for (int i = 0; i < list.size(); i++) {
				Point next = list.get(target[i]);
				if (dist(now, next) <= hp) { // 다음 민초 먹을 수 있으면
					cnt++;
					hp += H; // 체력 회복
					hp -= dist(now, next); // 거리만큼 체력 감소
					if (dist(next, new Point(sy, sx)) <= hp) { // 집에 갈 체력이 된다면
						ans = Math.max(ans, cnt);
					}
					now = next; // 현재위치 변경
				} else { // 민초 먹을 수 없으면 그만
					return;
				}
			}
			return;
		}

		// 순열로 민트의 순서 저장
		for (int i = 0; i < list.size(); i++) {
			if (select[i]) continue;
			target[tgtIdx] = i;
			select[i] = true;
			perm(tgtIdx + 1);
			select[i] = false;
		}
	}

	// 맨해튼 거리계산
	private static int dist(Point now, Point next) {
		return Math.abs(now.y - next.y) + Math.abs(now.x - next.x);
	}

}
