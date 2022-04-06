package study_04th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1244 )
 */
public class BJ_01244_스위치켜고끄기 {

	static int N, M;
	static int[] swit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 스위치 개수
		swit = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			swit[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());; // 학생 수
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (gender == 1) { // 남학생
				for (int j = 1; j <= N; j++) {
					if (j % num == 0) {
						swap(j);
					}
				}
			} else { // 여학생
				swap(num);
				int index = 1;
				while (true) {
					if(num - index <= 0 || num + index > N) {
						break;
					}
					
					if (swit[num - index] == swit[num + index]) {
						swap(num - index);
						swap(num + index);
						index++;
					} else {
						break;
					}
				}
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=N; i++) {
			sb.append(swit[i]).append(" ");
			if(i%20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	static void swap(int i) {
		if (swit[i] == 1) {
			swit[i] = 0;
		} else {
			swit[i] = 1;
		}
	}

}
