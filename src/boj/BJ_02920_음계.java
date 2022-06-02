package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 B2 ( https://www.acmicpc.net/problem/2920 )
 */
public class BJ_02920_음계 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[8];
		for (int i = 0; i < 8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if (arr[0] == 1) {
			boolean isAscending = true;
			for (int i = 1; i < 8; i++) {
				if (arr[i] != (i + 1)) {
					isAscending = false;
				}
			}
			System.out.println(isAscending ? "ascending" : "mixed");
		} else if (arr[0] == 8) {
			boolean isDecending = true;
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] != (8 - i)) {
					isDecending = false;
				}
			}
			System.out.println(isDecending ? "descending" : "mixed");
		} else {
			System.out.println("mixed");
		}
	}

}
