package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/1068 )
 */
public class BJ_01068_트리 {

	static int N, ans, root, deleteNum, input[];
	static boolean visit[];
	static Map<Integer, ArrayList<Integer>> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		visit = new boolean[N];
		deleteNum = Integer.parseInt(br.readLine());
		visit[deleteNum] = true;
		map.remove(deleteNum);

		for (int i = 0; i < N; i++) {
			int n = input[i];
			if (n == -1) { // 루트라면
				root = i;
				continue;
			}
			if (i == deleteNum) continue;

			if (map.containsKey(n)) {
				map.get(n).add(i);
			} else {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(i);
				map.put(n, temp);
			}
		}

		if (deleteNum != root) {
			dfs(root);
		}

		System.out.println(ans);
	}

	private static void dfs(int now) {
		visit[now] = true;
		if (!map.containsKey(now)) { // 리프노드라면
			ans++;
			return;
		}

		// 자식 노드 확인
		ArrayList<Integer> list = map.get(now);
		for (int n : list) {
			if (n == deleteNum) { // 없어지는 노드때문에 리프가 하나 더 생긴다
				ans++;
				continue;
			}
			if (visit[n]) continue;
			dfs(n);
		}

	}
}
