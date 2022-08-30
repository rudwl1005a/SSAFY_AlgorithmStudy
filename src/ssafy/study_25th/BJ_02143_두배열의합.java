package ssafy.study_25th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/2143 )
 */
public class BJ_02143_두배열의합 {

	static long T, ans;
	static int N, M, A[], B[];
	static ArrayList<Long> sumA, sumB;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Long.parseLong(br.readLine());
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		B = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		// A의 부분합 저장
		sumA = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			long sum = 0;
			for (int j = i; j < N; j++) {
				sum += A[j];
				sumA.add(sum);
			}
		}

		// B의 부분합 저장
		sumB = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			long sum = 0;
			for (int j = i; j < M; j++) {
				sum += B[j];
				sumB.add(sum);
			}
		}
		Collections.sort(sumB); // 이분탐색을 위한 정렬

		for (long a : sumA) {
			binarySearch(0, sumB.size() - 1, a);
		}

		System.out.println(ans);
	}

	private static void binarySearch(int left, int right, long a) {
		if (left > right)
			return;

		int mid = (left + right) / 2;
		long sum = a + sumB.get(mid);

		if (sum == T) {
			ans += (upper(0, sumB.size() - 1, sumB.get(mid)) - lower(0, sumB.size() - 1, sumB.get(mid)));
		} else if (sum < T) {
			binarySearch(mid + 1, right, a);
		} else {
			binarySearch(left, mid - 1, a);
		}
	}

	// a보다 큰 값이 나오는 첫번째 인덱스
	private static long upper(int left, int right, long a) {
		right++;
		while (left < right) {
			int mid = (left + right) / 2;
			if (sumB.get(mid) <= a) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return right;
	}

	// a값이 나오는 첫번째 인덱스
	private static long lower(int left, int right, long a) {
		right++;
		while (left < right) {
			int mid = (left + right) / 2;
			if (sumB.get(mid) < a) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return right;
	}
}
