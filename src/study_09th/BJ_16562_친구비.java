package study_09th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/16562 )
 */
public class BJ_16562_친구비 {

	static int N, M, K, ans;
	static int[] money, parent, min;
	static int[][] set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생 수
		M = Integer.parseInt(st.nextToken()); // 친구 관계 수
		K = Integer.parseInt(st.nextToken()); // 가지고 있는 돈

		money = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}

		makeSet();

		set = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			set[i][0] = Integer.parseInt(st.nextToken());
			set[i][1] = Integer.parseInt(st.nextToken());
			union(set[i][0], set[i][1]);
		}
		
		for (int i = 0; i < M; i++) {
			union(set[i][1], set[i][0]);
		}

		min = new int[N + 1];
		Arrays.fill(min, Integer.MAX_VALUE);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (parent[i] == j) {
					min[j] = Math.min(min[j], money[i]);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (min[i] == Integer.MAX_VALUE) {
				continue;
			}
			ans += min[i];
			if (ans > K) {
				System.out.println("Oh no");
				return;
			}
		}

		System.out.println(ans);

	}

	private static void makeSet() {
		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}
	}

	private static int findSet(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = findSet(parent[a]);
	}

	private static void union(int a, int b) {
		int ar = findSet(a);
		int br = findSet(b);

		if (ar == br) {
			return;
		}

		if (br > ar) {
			parent[br] = ar;
		} else {
			parent[ar] = br;
		}
	}

}
