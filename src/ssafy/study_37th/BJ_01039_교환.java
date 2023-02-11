package ssafy.study_37th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/1039 )
 */
public class BJ_01039_교환 {

	static int K, ans;
	static char[] N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = st.nextToken().toCharArray();
		K = Integer.parseInt(st.nextToken());

		ans = -1;
		int len = N.length;
		Queue<String> queue = new LinkedList<>();
		queue.offer(String.valueOf(N));

		if (len == 1 || (len == 2 && N[1] == '0')) {
			System.out.println(-1);
			return;
		}

		// K번 바꾸는 만큼 반복
		for (int k = 0; k < K; k++) {
			ArrayList<String> visit = new ArrayList<>(); // 반복 마다 visit check
			int queLen = queue.size();

			for (int q = 0; q < queLen; q++) {
				String s = queue.poll();
				char[] now = s.toCharArray();

				for (int i = 0; i < len; i++) {
					for (int j = i + 1; j < len; j++) {
						if (i == 0 && now[j] == 0) continue; // 맨 앞이 0이면 안됨

						// 위치 교체
						char[] temp = s.toCharArray();
						char c = temp[i];
						temp[i] = temp[j];
						temp[j] = c;

						// list 수열이 없는경우
						if (!visit.contains(String.valueOf(temp))) {
							if (k == K - 1) { // K번 연산 했으면 최대값 갱신
								ans = Math.max(ans, Integer.parseInt(String.valueOf(temp)));
								continue;
							}
							queue.offer(String.valueOf(temp));
							visit.add(String.valueOf(temp));
						}

					}
				}
			}
		}

		System.out.println(ans);

	}

}
