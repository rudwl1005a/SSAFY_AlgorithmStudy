package ssafy.study_26th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/16724 )
 */
public class BJ_16724_피리부는사나이 {

	static int N, M, cnt, parent[][], ans;
	static char[][] map;
	static boolean[][] visit;
	
	static ArrayList<Integer> list = new ArrayList<>();
	
	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		parent = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visit[i][j]) continue;
				cnt++;
				dfs(i, j, cnt);
			}
		}
		
		System.out.println(ans);
		
	}

	private static void dfs(int y, int x, int n) {
		visit[y][x] = true;
		parent[y][x] = n;
		
		// 방향 설정
		int dir = -1;
		if(map[y][x] == 'U') dir = 0;
		else if(map[y][x] == 'D') dir = 1;
		else if(map[y][x] == 'L') dir = 2;
		else if(map[y][x] == 'R') dir = 3;
		
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if(parent[ny][nx] == n) ans++;
		if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) return;
		if(parent[ny][nx] < n) {
			dfs(ny, nx, n);
		}
	}


}
