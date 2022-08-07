package ssafy.study_23st;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/20056 )
 */
public class BJ_20056_마법사상어와파이어볼 {

	static int N, M, K, ans;
	static ArrayList<Fireball>[][] map;

	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 위쪽부터 시계방향으로
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 격자크기
		M = Integer.parseInt(st.nextToken()); // 파이어볼 개수
		K = Integer.parseInt(st.nextToken()); // 이동 횟수

		map = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[r][c].add(new Fireball(r, c, m, s, d, false));
		}

		for (int simul = 0; simul < K; simul++) {
			// 이동
			move();
			// 2개이상 칸에서 진행
			upTwo();
		}

		// 남아있는 질량 합 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = map[i][j].size();
				for (int k = 0; k < cnt; k++) {
					ans += map[i][j].get(k).m;
				}
			}
		}

		System.out.println(ans);

	}

	private static void move() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int size = map[i][j].size();
				if (size == 0)
					continue;
				for (int k = size - 1; k >= 0; k--) {
					Fireball cur = map[i][j].get(k);
					if (cur.move)
						continue;
					map[i][j].remove(k);
					int nr = cur.r;
					int nc = cur.c;
					for (int l = 0; l < cur.s; l++) {
						nr += dy[cur.d];
						nc += dx[cur.d];

						// 처음과 끝이 이어져 있기 때문에
						if (nr < 0)
							nr = N - 1;
						else if (nr >= N)
							nr = 0;
						if (nc < 0)
							nc = N - 1;
						else if (nc >= N)
							nc = 0;
					}
					map[nr][nc].add(new Fireball(nr, nc, cur.m, cur.s, cur.d, true));
				}

			}
		}

	}

	private static void upTwo() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int size = map[i][j].size();
				if (size < 2)
					continue;
				int cnt = 0;
				int sumM = 0;
				int sumS = 0;
				boolean isEven = true;
				boolean isOdd = true;
				// 같은칸 파이어볼 합치기
				for (int k = size - 1; k >= 0; k--) {
					Fireball cur = map[i][j].get(k);
					map[i][j].remove(k);
					cnt++;
					sumM += cur.m;
					sumS += cur.s;
					if (cur.d % 2 == 0) { // 모두 짝수인지
						isOdd = false;
					} else { // 모두 홀수인지
						isEven = false;
					}
				}

				// 파이어볼 4개로 나누기
				if (isEven || isOdd) {
					map[i][j].add(new Fireball(i, j, sumM / 5, sumS / cnt, 0, false));
					map[i][j].add(new Fireball(i, j, sumM / 5, sumS / cnt, 2, false));
					map[i][j].add(new Fireball(i, j, sumM / 5, sumS / cnt, 4, false));
					map[i][j].add(new Fireball(i, j, sumM / 5, sumS / cnt, 6, false));
				} else {
					map[i][j].add(new Fireball(i, j, sumM / 5, sumS / cnt, 1, false));
					map[i][j].add(new Fireball(i, j, sumM / 5, sumS / cnt, 3, false));
					map[i][j].add(new Fireball(i, j, sumM / 5, sumS / cnt, 5, false));
					map[i][j].add(new Fireball(i, j, sumM / 5, sumS / cnt, 7, false));
				}
			}
		}

		// 질량 0인 파이어볼 소멸
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int size = map[i][j].size();
				if (size == 0)
					continue;
				for (int k = size - 1; k >= 0; k--) {
					Fireball cur = map[i][j].get(k);
					if (cur.m == 0) {
						map[i][j].remove(k);
					} else {
						cur.move = false;
					}
				}
			}
		}

	}

	static class Fireball {
		int r, c, m, s, d; // 위치 (r,c), 질량 m, 속력s, 방향d
		boolean move;

		public Fireball(int r, int c, int m, int s, int d, boolean move) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
			this.move = move;
		}

	}

}
