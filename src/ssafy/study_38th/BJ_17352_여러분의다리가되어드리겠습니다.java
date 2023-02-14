package ssafy.study_38th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/17352 )
 */
public class BJ_17352_여러분의다리가되어드리겠습니다 {

	static int N, parent[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		makeSet();

		for (int i = 0; i < N - 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			if(parent[i] == i) { // 분리집합이 자기 자신을 가리키는 두개를 이으면 조건에 맞게 이을 수 있다
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}

	private static void makeSet() {
		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}
	}

	private static int findSet(int a) {
		if (parent[a] == a) {
			return parent[a];
		}
		return parent[a] = findSet(parent[a]);
	}

	private static void union(int a, int b) {
		int ar = findSet(a);
		int br = findSet(b);

		if (ar == br) {
			return;
		}

		parent[br] = ar;
		return;
	}

}
