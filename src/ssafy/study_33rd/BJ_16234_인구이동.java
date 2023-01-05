package ssafy.study_33rd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/16234 )
 */
public class BJ_16234_인구이동 {

	static int N, L, R, map[][], union[][], ans;
	static Map<Integer, Union> info = new HashMap<>(); // 연합 인구 총합

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			// 연합 초기화
			union = new int[N][N]; // 연합번호 저장
			info.clear();
			
			// 1. 연합 생성
			int cnt = 1; // 연합 번호
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (union[i][j] != 0) continue; // 연합이 이미 있으면 건너뜀
					dfs(i, j, cnt);
					cnt++;
				}
			}

			if (cnt > N * N) break; // cnt가 N*N이상이라면 연합이 없는것 -> 인구 이동이 없으면 끝

			// 2. 인구이동
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int u = union[i][j]; // 연합번호
					map[i][j] = info.get(u).pop / info.get(u).size; // 인구 나누기
				}
			}
			
			ans++; // 인구이동 일수 증가
		}
		
		System.out.println(ans);

	}

	private static void dfs(int y, int x, int cnt) {

		// 연합 정보 저장
		union[y][x] = cnt;
		if (info.containsKey(cnt)) {
			Union temp = info.get(cnt);
			info.replace(cnt, new Union(temp.pop + map[y][x], temp.size + 1));
		} else {
			info.put(cnt, new Union(map[y][x], 1));
		}

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || nx < 0 || ny >= N || nx >= N || union[ny][nx] != 0) continue;
			int dif = Math.abs(map[y][x] - map[ny][nx]);
			if(L <= dif && dif <= R) { // 인구차이가 L이상 R이하라면 같은 연합
				dfs(ny, nx, cnt);
			}
		}

	}

	static class Union {
		int pop, size; // 총 인구수, 크기

		public Union(int pop, int size) {
			super();
			this.pop = pop;
			this.size = size;
		}

	}

}
