package ssafy.study_33th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/22252 )
 */
public class BJ_22252_정보상인호석 {

	static int Q;
	static long ans;
	static Map<String, PriorityQueue<Integer>> map = new TreeMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Q = Integer.parseInt(br.readLine()); // 쿼리 개수

		for (int i = 0; i < Q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken()); // 쿼리 타입
			String name = st.nextToken(); // 고릴라 이름
			int n = Integer.parseInt(st.nextToken()); // 정보 개수

			if (type == 1) { // 정보 삽입
				if (map.containsKey(name)) { // 이미 있던 고릴라 이름이면 삽입 후 대체
					PriorityQueue<Integer> pq = map.get(name);
					for (int j = 0; j < n; j++) {
						int a = Integer.parseInt(st.nextToken());
						pq.add(a);
					}
					map.replace(name, pq);
				} else { // 처음 만나는 고릴라 이름이면 우선순위 큐 초기화 및 선언 후 삽입
					PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
					for (int j = 0; j < n; j++) {
						int a = Integer.parseInt(st.nextToken());
						pq.add(a);
					}
					map.put(name, pq);
				}
			} else { // 정보 사기
				if (map.containsKey(name)) {
					PriorityQueue<Integer> pq = map.get(name);
					for (int j = 0; j < n; j++) {
						if (!pq.isEmpty()) {
							ans += pq.poll();
						}
					}
					map.replace(name, pq);
				}
			}
		}

		System.out.println(ans);
	}

}
