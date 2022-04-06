package study_07th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/13021 )
 */
public class BJ_13021_공색칠하기 {

	static int N, M, cnt;
	static int[] arr;
	static ArrayList<Integer> al = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		Arrays.fill(arr, -1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			for (int j = L; j < R + 1; j++) {
				arr[j] = cnt;
			}
			cnt++;
		}


		for (int i = 1; i <= N; i++) {
			if (!al.contains(arr[i]) && arr[i] != -1) {
				al.add(arr[i]);
			}
		}

		System.out.println((long) Math.pow(2, al.size()));

	}

}
