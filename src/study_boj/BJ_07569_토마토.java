package study_boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/7569 )
 */
public class BJ_07569_토마토 {
	
	static int N, M, H, ans;
	static int[][][] map;
	
	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };
	
	static Queue<Tomato> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k] == 1) {
						q.offer(new Tomato(i, j, k, 0));
					}
				}
			}
		}
		
		bfs();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(map[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		System.out.println(ans);
	}

	private static void bfs() {
		
		while(!q.isEmpty()) {
			Tomato to = q.poll();
			
			ans = Math.max(ans, to.day);
			
			// 같은 줄의 상자 상하좌우
			for (int d = 0; d < 4; d++) {
				int ny = to.y + dy[d];
				int nx = to.x + dx[d];	
				
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[to.h][ny][nx] != 0) {
					continue;
				}
				
				map[to.h][ny][nx] = 1;
				q.offer(new Tomato(to.h, ny, nx, to.day + 1));
			}
			
			// 윗상자
			if(to.h + 1 < H && map[to.h + 1][to.y][to.x] == 0) {
				map[to.h + 1][to.y][to.x] = 1;
				q.offer(new Tomato(to.h + 1, to.y, to.x, to.day + 1));
			}
			
			// 아랫상자
			if(to.h - 1 >= 0 && map[to.h - 1][to.y][to.x] == 0) {
				map[to.h - 1][to.y][to.x] = 1;
				q.offer(new Tomato(to.h - 1, to.y, to.x, to.day + 1));
			}
			
		}
		
	}

	static class Tomato {
		int h, y, x, day;

		public Tomato(int h, int y, int x, int day) {
			this.h = h;
			this.y = y;
			this.x = x;
			this.day = day;
		}
		
	}
}
