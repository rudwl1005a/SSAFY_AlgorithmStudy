package study_extra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1717 )
 */
public class BJ_01717_집합의표현 {

	static int N, M;
	static int[] set;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 원소의 개수
		M = Integer.parseInt(st.nextToken()); // 연산의 개수

		// make-set
		set = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			set[i] = i;
		}

		for (int i = 0; i < M; i++) { // 연산 계산
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (op == 0) { // 합집합 만들기
				union(a, b);
			} else { // a와 b가 같은 집합 안에 있는가?
				if (findSet(a) == findSet(b)) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}
		}

		System.out.println(sb);
	}

	private static int findSet(int a) {
		if (set[a] == a) {
			return a;
		}

		return set[a] = findSet(set[a]);
	}

	private static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) {
			return;
		}
		
		set[bRoot] = aRoot;
	}

}
