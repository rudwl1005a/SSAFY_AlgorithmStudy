package study_07th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/1941 )
 */
public class BJ_01941_소문난칠공주_fail {
	// 조합, 서로소로 풀려했는데 답이 안나옴

	static int ans;
	static char[][] map = new char[5][5];
	static boolean[][] visit, visit2;

	// 조합
	static int[] tgt = new int[7];

	// 서로소
	static int[] parents;

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}

		comb(0, 0);

		System.out.println(ans);
	}

	private static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == 7) {
			int cnt = 0;
			visit = new boolean[5][5];
			visit2 = new boolean[5][5];
			for (int i = 0; i < 7; i++) {
				int n = tgt[i];
				
				// 조합인지 확인
				int y = n / 5;
				int x = n % 5;
				visit[y][x] = true;

				// 이다솜파인지 확인
				if(map[y][x] == 'S') {
					cnt++;
				}
			}

			// 이다솜파 우위인지 확인
			if (cnt >= 4) {
				// disjoint
				// make-set
				parents = new int[25];
				for (int i = 0; i < 25; i++) {
					parents[i] = i;
				}

				for (int i = 0; i < 7; i++) {
					int n = tgt[i];
					int y = n / 5;
					int x = n % 5;
					
					if(i == 0) {
						visit2[y][x] = true;
					}
					
					for (int d = 0; d < 4; d++) {
						int ny = y + dy[d];
						int nx = x + dx[d];
						if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5 || !visit[ny][nx] || visit2[ny][nx]) {
							continue;
						}

						if(union(tgt[i], ny * 5 + nx)) {
							visit2[ny][nx] = true;
						}
						
					}
				}
				
				int isAdj = 1;
				for (int i = 0; i < 6; i++) {
					if(parents[tgt[i]] == parents[tgt[i+1]]) {
						isAdj++;
					}
				}
				if(isAdj == 7) {
					ans++;
				}
			}
			return;
		}
		if (srcIdx == 25) {
			return;
		}

		tgt[tgtIdx] = srcIdx;
		comb(srcIdx + 1, tgtIdx + 1); // src증가, tgt증가 : 현재 srcIdx를 tgt가 받아들이고 다음으로 간다.
		comb(srcIdx + 1, tgtIdx);
	}

	public static int findSet(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}

	public static boolean union(int a, int b) {
		int ar = findSet(a);
		int br = findSet(b);
		if (ar == br) {
			return false;
		}

		parents[br] = ar;
		return true;
	}

}
