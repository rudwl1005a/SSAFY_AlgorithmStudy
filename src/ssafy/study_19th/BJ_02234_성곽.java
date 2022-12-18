package ssafy.study_19th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/2234 )
 */
public class BJ_02234_성곽 {

	static int N, M, brokenMax, maxRoom;
	static int[][] arr, visited;
	static Map<Integer, Integer> map = new HashMap<>(); // 방번호 : 방사이즈

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	static Queue<int[]> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 방번호 및 방 크기 체크(visited에 체크)
		bfs();
		// visited를 돌면서 다른 번호일때, 합구하기
		brokenBfs();

		sb.append(map.size()).append("\n");
		sb.append(maxRoom).append("\n");
		sb.append(brokenMax).append("\n");
		System.out.println(sb);
	}

	// 성 돌기
	public static void bfs() {

		q = new LinkedList<>();
		int roomNum = 0;
		int roomSize = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 미방문한곳이면 방문
				if (visited[i][j] == 0) {
					// 방 번호 설정
					visited[i][j] = ++roomNum;
					// 방 크기
					roomSize = 1;
					q.offer(new int[] { i, j });

					while (!q.isEmpty()) {
						int[] cur = q.poll();

						int y = cur[0];
						int x = cur[1];

						for (int d = 0; d < 4; d++) {
							int ny = y + dx[d];
							int nx = x + dy[d];

							// 성 벗어난 경우
							if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
								continue;
							}
							// 벽이 없으면서 방문하지 않았으면
							if ((arr[y][x] & (1 << d)) == 0 && visited[ny][nx] == 0) {
								visited[ny][nx] = visited[y][x];
								q.offer(new int[] { ny, nx });
								// 방 크기 증가
								roomSize++;
							}
						}
					}
					// 방 저장
					map.put(roomNum, roomSize);
					// 최대방이면 변경
					maxRoom = Math.max(maxRoom, roomSize);
				}

			}
		}
	}

	// 다른 방 만나면 체크
	public static void brokenBfs() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 현재방번호
				int roomNum = visited[i][j];

				for (int d = 0; d < 4; d++) {
					int ny = i + dx[d];
					int nx = j + dy[d];

					// 성 벗어난 경우
					if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
						continue;
					}
					// 현재방번호랑 다를 시
					if (visited[ny][nx] != roomNum) {
						// 현재방 + 다른방 최대값 비교
						brokenMax = Math.max(brokenMax, map.get(roomNum) + map.get(visited[ny][nx]));
					}
				}
			}
		}
	}
}
