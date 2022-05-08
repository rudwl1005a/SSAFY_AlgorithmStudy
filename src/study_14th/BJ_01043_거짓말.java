package study_14th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1043 )
 */
public class BJ_01043_거짓말 {

	static int N, M;
	static int[] parent;
	static boolean[] truth;
	static HashSet<Integer>[] party;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		truth = new boolean[N + 1]; // 알고있으면 T, 아니면 F
		party = new HashSet[M + 1];

		for (int i = 1; i <= M; i++) {
			party[i] = new HashSet<>();
		}

		st = new StringTokenizer(br.readLine());
		int truth_num = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= truth_num; i++) { // 진실을 아는사람 T
			int tmp = Integer.parseInt(st.nextToken());
			truth[tmp] = true;
		}

		makeSet();

		for (int i = 1; i <= M; i++) { // party number
			st = new StringTokenizer(br.readLine());
			int party_num = Integer.parseInt(st.nextToken()); // 파티에 오는 사람 수

			int prev = Integer.parseInt(st.nextToken());

			if (party_num <= 1) {
				party[i].add(prev);
				continue;
			}

			for (int j = 1; j < party_num; j++) { // 연관 관계 이어줌
				int a = prev;
				int b = Integer.parseInt(st.nextToken());
				
				if (findSet(a) != findSet(b)) {
					union(a, b);
				}

				party[i].add(a); // 파티에 참여하는 사람 저장
				party[i].add(b);

				prev = b;
			}
		}

		// 진실을 아는 사람과 연관 관계 있음 => people_know[i] T로 변경
		boolean[] visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (truth[i] && !visited[i]) {
				int root = findSet(i);
				for (int j = 1; j <= N; j++) {
					if (findSet(j) == root) {
						truth[j] = true;
						visited[j] = true;
					}
				}
			}
		}

		// 모든 파티 참석자가 F여야 과장된 얘기를 할 수 있음
		int result = 0;
		for (int i = 1; i <= M; i++) { // party
			boolean flag = false;
			for (int person : party[i]) { // 참석자
				if (truth[person]) {
					flag = true;
					break;
				}
			}
			if (!flag)
				result++;
		}

		System.out.println(result);
	}

	private static void makeSet() {
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	private static int findSet(int a) {
		if (parent[a] == a) {
			return a;
		}
		parent[a] = findSet(parent[a]);
		return parent[a];
	}

	private static void union(int a, int b) {
		int parent_b = findSet(b);
		parent[parent_b] = a; // b의 parent를 a로 변경
	}

}
