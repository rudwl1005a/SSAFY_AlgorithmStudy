package ssafy.study_34th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/20209 )
 */
public class BJ_20209_스트레이트스위치게임 {

	static int N, K;
	static ArrayList<Integer> swit[], cube;
	static HashMap<ArrayList<Integer>, Integer> map = new HashMap<>(); // (큐브 상태, 클릭 수)를 저장할 맵

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 큐브의 개수
		K = Integer.parseInt(st.nextToken()); // 스위치의 개수

		cube = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cube.add(Integer.parseInt(st.nextToken()));
		}
		swit = new ArrayList[K + 1];
		for (int i = 1; i <= K; i++) { // swit[i]은 i번째 스위치를 누르면 켜지는 큐브의 정보저장
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			swit[i] = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				int m = Integer.parseInt(st.nextToken());
				swit[i].add(m - 1);
			}
		}

		System.out.println(bfs());

	}

	private static int bfs() {
		// 큐브 상태 저장을 위한 큐
		Queue<ArrayList<Integer>> q = new LinkedList<>();

		// 초기 큐브 상태 저장
		map.put(cube, 0);
		q.offer(cube);

		while (!q.isEmpty()) {
			ArrayList<Integer> now = q.poll();

			// 전부 같은지 확인
			boolean equal = true;
			for (int i = 0; i < N - 1; i++) {
				if (now.get(i) != now.get(i + 1))
					equal = false;
			}

			// 같으면 최소횟수 이므로 리턴
			if (equal) {
				return map.get(now);
			}

			// 버튼 수만큼 반복하여 bfs 진행
			for (int i = 1; i <= K; i++) {
				// 새 큐브 생성 및 복사
				ArrayList<Integer> temp = new ArrayList<>();
				for (int j = 0; j < N; j++) {
					temp.add(now.get(j));
				}

				// 버튼 클릭하여 큐브 값 수정
				for (int j : swit[i]) {
					temp.set(j, (temp.get(j) + i) % 5); // 5넘으면 초기화
				}

				// hashmap 및 queue에 추가
				// 최소 클릭 수를 구하기 위함이므로 존재하면 추가X
				if (!map.containsKey(temp)) {
					map.put(temp, map.get(now) + 1);
					q.offer(temp);
				}
			}
		}

		return -1;
	}

}
