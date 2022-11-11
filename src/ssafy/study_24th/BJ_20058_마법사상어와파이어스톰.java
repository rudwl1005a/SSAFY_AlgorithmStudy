package ssafy.study_24th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/20058 )
 */
public class BJ_20058_마법사상어와파이어스톰 {

	static int N, Q, land, totalIce;
	static int[][] A;
	static int[] L;
	static StringTokenizer st;

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, N);

		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		L = new int[Q];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < Q; i++) {
			A = divide(L[i]);
			A = melt();
		}
		findBiggest();
		System.out.println(totalIce);
		System.out.println(land);
	}

	static int[][] divide(int L) {
		int[][] temp = new int[N][N];
		L = (int) Math.pow(2, L);

		for (int i = 0; i < N; i += L) {
			for (int j = 0; j < N; j += L) {
				rotate(i, j, L, temp);
			}
		}
		return temp;
	}

	static void rotate(int r, int c, int L, int[][] temp) {
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++) {
				temp[r + j][c + L - i - 1] = A[r + i][c + j];
			}
		}
	}

	static int[][] melt() {
		int[][] temp = new int[N][N];

		for (int i = 0; i < N; i++) {
			temp[i] = Arrays.copyOf(A[i], N);
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int cnt = 0;
				if (A[r][c] == 0)
					continue;
				for (int d = 0; d < 4; d++) {
					int nr = r + dy[d];
					int nc = c + dx[d];
					if (isIn(nr, nc) && A[nr][nc] > 0) {
						cnt++;
					}
				}
				if (cnt < 3) {
					temp[r][c]--;
				}
			}
		}
		return temp;
	}

	static void findBiggest() {
		boolean[][] visited = new boolean[N][N];
		Stack<int[]> stack = new Stack<>();
		land = 0;
		totalIce = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (A[i][j] > 0 && !visited[i][j]) {
					stack.push(new int[] { i, j });
					visited[i][j] = true;
					totalIce += A[i][j];
					int count = 1;
					while (!stack.isEmpty()) {
						int[] temp = stack.pop();
						int r = temp[0];
						int c = temp[1];

						for (int d = 0; d < 4; d++) {
							int nr = r + dy[d];
							int nc = c + dx[d];

							if (isIn(nr, nc) && A[nr][nc] > 0 && !visited[nr][nc]) {
								count++;
								visited[nr][nc] = true;
								stack.push(new int[] { nr, nc });
								totalIce += A[nr][nc];
							}
						}
					}
					land = Math.max(count, land);

				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
