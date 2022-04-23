package study_12th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/20040 )
 */
public class BJ_20040_사이클게임 {

	static int N, M;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 점의 개수
		M = Integer.parseInt(st.nextToken()); // 게임 횟수

		makeSet();
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (!union(a, b)) { // 사이클이 생성된다면
				System.out.println(i);
				return;
			}
		}

		// 입력 끝까지 사이클이 생성되지 않았다면 0 출력
		System.out.println(0);
	}

	private static void makeSet() {
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}

	private static int findSet(int a) {
		if (a == parent[a]) {
			return parent[a];
		}
		return parent[a] = findSet(parent[a]);
	}

	private static boolean union(int a, int b) {
		int ar = findSet(a);
		int br = findSet(b);
		if (ar == br) {
			return false;
		}
		parent[br] = ar;
		return true;
	}

}
