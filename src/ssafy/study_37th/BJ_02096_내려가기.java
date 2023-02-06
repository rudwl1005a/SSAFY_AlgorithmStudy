package ssafy.study_37th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/2096 )
 */
public class BJ_02096_내려가기 {

	static int N;
	static int max[], min[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		max = new int[3];
		min = new int[3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());

			// 맨 위 초기값
			if (i == 0) {
				max[0] = min[0] = n1;
				max[1] = min[1] = n2;
				max[2] = min[2] = n3;
				continue;
			}

			// 최대값 갱신
			int tempMax = max[1];
			max[1] = n2 + Math.max(max[1], Math.max(max[0], max[2]));
			max[0] = n1 + Math.max(max[0], tempMax);
			max[2] = n3 + Math.max(max[2], tempMax);

			// 최소값 갱신
			int tempMin = min[1];
			min[1] = n2 + Math.min(min[1], Math.min(min[0], min[2]));
			min[0] = n1 + Math.min(min[0], tempMin);
			min[2] = n3 + Math.min(min[2], tempMin);

		}

		System.out.println(Math.max(max[0], Math.max(max[1], max[2])) + " " + Math.min(min[0], Math.min(min[1], min[2])));

	}

}
