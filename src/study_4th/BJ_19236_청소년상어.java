package study_4th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G2 ( https://www.acmicpc.net/problem/19236 )
 */
public class BJ_19236_청소년상어 {

	static int ans; // 상어 먹은 번호의 합
	static int[][] map = new int[4][4]; // 물고기 num만 저장
	static Fish[] fish = new Fish[17]; // 물고기 정보
	static boolean[] eat = new boolean[17]; // 물고기 16
	static Fish shark; // 상어

	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 0상 1좌상 2좌 3좌하 4하 5우하 6우 7우상
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 17; i++) {
			fish[i] = new Fish(0, 0, 0);
		}

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				if (i == 0 && j == 0) { // 상어는 항상 0,0부터 시작
					shark = new Fish(0, 0, d - 1);
					eat[n] = true;
					ans += n;
					map[i][j] = 17;
					continue;
				}
				fish[n].y = i;
				fish[n].x = j;
				fish[n].dir = d - 1;
				map[i][j] = n;
			}
		}

		dfs(0, 0, shark.dir, ans, map, fish);

		System.out.println(ans);
	}

	private static void dfs(int y, int x, int dir, int sum, int[][] tempMap, Fish[] tempFish) { // 상어 정보 파라미터로

		ans = Math.max(ans, sum);

		int[][] copy = copyMap(tempMap);
		Fish[] copyFish = copyFish(tempFish);
		
		move(copy, copyFish); // 물고기 이동
		
		for (int i = 1; i <= 3; i++) { // 상어가 한 방향으로 갈 수 있는 최대 이동거리는 3이다
			int ny = y + dy[dir] * i;
			int nx = x + dx[dir] * i;

			if (ny < 0 || nx < 0 || ny >= 4 || nx >= 4 || copy[ny][nx] == 0 || copy[ny][nx] == 17) {
				continue;
			}
			
			// 상어 이동
			int n = copy[ny][nx]; // 그 칸에 있는 물고기 번호
			eat[n] = true;
			copy[y][x] = 0; // 빈칸
			copy[ny][nx] = 17; // 상어
			
			dfs(ny, nx, copyFish[n].dir, sum + n, copy, copyFish);
			
			// 되돌리기
			eat[n] = false;
			copy[y][x] = 17;
			copy[ny][nx] = n;
		}

	}

	private static void move(int[][] tempMap, Fish[] tempFish) {
		for (int i = 1; i < 17; i++) {
			if (eat[i]) { // 먹혔으면 건너뜀
				continue;
			}

			int ny = tempFish[i].y + dy[tempFish[i].dir];
			int nx = tempFish[i].x + dx[tempFish[i].dir];

			int index = 0;
			while (true) {
				if (index == 8) { // 방향 한바퀴 다 돌았는데 못 움직이면 이동x
					break;
				}

				if (ny < 0 || nx < 0 || ny >= 4 || nx >= 4 || tempMap[ny][nx] == 17) {
					index++;
					tempFish[i].dir = (tempFish[i].dir + 1) % 8; // 우상(7)에서 + 1 하면 우(0)으로
					ny = tempFish[i].y + dy[tempFish[i].dir];
					nx = tempFish[i].x + dx[tempFish[i].dir];
					continue;
				}

				if (tempMap[ny][nx] > 0 && tempMap[ny][nx] < 17) { // 물고기 있는 칸이면 서로 바꿈
					swap(tempFish[i], tempFish[tempMap[ny][nx]], tempMap);
					break;
				} else if(tempMap[ny][nx] == 0) { // 빈칸이면 이동만
					tempMap[tempFish[i].y][tempFish[i].x] = 0;
					tempMap[ny][nx] = i;
					tempFish[i].y = ny;
					tempFish[i].x = nx;
				}
			}
		}
	}

	private static void swap(Fish f1, Fish f2, int[][] tempMap) {
		// map 숫자 바꿔주기
		int tmp = tempMap[f1.y][f1.x];
		tempMap[f1.y][f1.x] = tempMap[f2.y][f2.x];
		tempMap[f2.y][f2.x] = tmp;
		
		// Fish객체 좌표 정보 바꿔주기
		int ty = f1.y;
		int tx = f1.x;
		f1.y = f2.y;
		f1.x = f2.x;
		f2.y = ty;
		f2.x = tx;
	}

	private static Fish[] copyFish(Fish[] tempFish) { // 깊은 복사
		Fish[] copy = new Fish[17];
		for (int i = 0; i < 17; i++) {
			copy[i] = new Fish(tempFish[i].y, tempFish[i].x, tempFish[i].dir);
		}
		return copy;
	}

	private static int[][] copyMap(int[][] origin) { // 얕은 복사
		int[][] copy = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		return copy;
	}

	static class Fish {
		int y, x; // 물고기 좌표
		int dir; // 물고기 방향

		public Fish(int y, int x, int diec) {
			this.y = y;
			this.x = x;
			this.dir = diec;
		}

	}
}
