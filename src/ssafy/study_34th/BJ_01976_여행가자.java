package ssafy.study_34th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1976 )
 */
public class BJ_01976_여행가자 {

	static int N, M, parent[];
	static boolean ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		makeSet();
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					Union(i, j); // 연결되어있으면 같은 집합으로
				}
			}
		}

		ans = true;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int uni = findSet(Integer.parseInt(st.nextToken())); // 분리집합의 부모요소
		for (int i = 1; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(uni != findSet(n)) { // 부모요소가 같지 않다면 false
				ans = false;
			}
		}
		
		System.out.println(ans ? "YES" : "NO");
	}

	// Union-Find 메서드
	private static void makeSet() {
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	private static int findSet(int a) {
		if (parent[a] == a) {
			return parent[a];
		}
		return parent[a] = findSet(parent[a]);
	}

	private static void Union(int a, int b) {
		int ar = findSet(a);
		int br = findSet(b);
		
		if (ar == br) {
			return;
		}
		parent[br] = ar;
	}

}
