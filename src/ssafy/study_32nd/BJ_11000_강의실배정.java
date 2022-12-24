package ssafy.study_32nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/11000 )
 */
public class BJ_11000_강의실배정 {

	static int N;
	static PriorityQueue<Class> input = new PriorityQueue<>((c1, c2) -> {
		// 시작시간으로 오름차순 정렬, 같다면 종료시간으로 오름차순 정렬
		return c1.s != c2.s ? c1.s - c2.s : c1.t - c2.t;
	});
	static PriorityQueue<Integer> room = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			input.add(new Class(s, t));
		}

		// 맨 처음 종료시간 넣기
		room.add(input.poll().t);
		while (!input.isEmpty()) {
			Class cur = input.poll();
			// 현재 강의의 시작시간이 종료시간이 제일 빠른 강의실의 종료시간보다 크거나 같다면 poll
			if (room.peek() <= cur.s) {
				room.poll();
			}

			// 종료시간 갱신
			room.add(cur.t);
		}

		// 우선순위 큐에 남아있는 갯수가 강의실 개수
		System.out.println(room.size());

	}

	public static class Class {
		int s, t;

		public Class(int s, int t) {
			super();
			this.s = s;
			this.t = t;
		}

	}

}
