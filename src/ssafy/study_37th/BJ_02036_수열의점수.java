package ssafy.study_37th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/2036 )
 */
public class BJ_02036_수열의점수 {

	static int N;
	static BigInteger answer = new BigInteger("0"); // 정수가 엄청 커지므로 BigInteger를 사용해야한다

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Long> plus = new ArrayList<Long>();
		ArrayList<Long> minus = new ArrayList<Long>();
		ArrayList<Long> one = new ArrayList<Long>();

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			if (num == 1) {
				one.add(num);
			} else if (num > 1) {
				plus.add(num);
			} else {
				minus.add(num);
			}
		}

		Collections.sort(plus, Collections.reverseOrder());
		Collections.sort(minus);

		// 1이 아닌 양수 처리
		if (plus.size() % 2 == 0) {
			for (int i = 0; i < plus.size(); i += 2) {
				answer = answer.add(BigInteger.valueOf(plus.get(i) * plus.get(i + 1)));
			}
		} else if (plus.size() % 2 != 0) {
			for (int i = 0; i < plus.size() - 1; i += 2) {
				answer = answer.add(BigInteger.valueOf(plus.get(i) * plus.get(i + 1)));
			}
			answer = answer.add(BigInteger.valueOf(plus.get(plus.size() - 1)));
		}

		// 음수 처리
		if (minus.size() % 2 == 0) {
			for (int i = 0; i < minus.size(); i += 2) {
				answer = answer.add(BigInteger.valueOf(minus.get(i) * minus.get(i + 1)));
			}
		} else if (minus.size() % 2 != 0) {
			for (int i = 0; i < minus.size() - 1; i += 2) {
				answer = answer.add(BigInteger.valueOf(minus.get(i) * minus.get(i + 1)));
			}
			answer = answer.add(BigInteger.valueOf(minus.get(minus.size() - 1)));
		}

		long remain = one.size();
		answer = answer.add(BigInteger.valueOf(remain));
		System.out.println(answer);
	}

	/* BigInteger 안쓴버전
	static int N, arr[];
	static long ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	
		Arrays.sort(arr);
		int left = 0;
		int right = N - 1;
		while (left <= right) {
			// right - left가
			if (right - left >= 3) { // 3보다 클 경우
				// 왼쪽 시작
				if (arr[left] * arr[left + 1] >= arr[left] + arr[left + 1]) {
					ans += arr[left] * arr[left + 1];
					left += 2;
				} else {
					ans += arr[left];
					left++;
				}
				// 오른쪽 시작
				if (arr[right] * arr[right - 1] >= arr[right] + arr[right - 1]) {
					ans += arr[right] * arr[right - 1];
					right -= 2;
				} else {
					ans += arr[right];
					right--;
				}
			} else if (right - left == 2) { // 2일 경우
				int sum = arr[left] + arr[left + 1] + arr[right];
				if (sum >= arr[left] * arr[left + 1] && sum >= arr[right - 1] * arr[right]) {
					ans += sum;
				} else if (arr[left] * arr[left + 1] + arr[right] >= arr[right - 1] * arr[right] + arr[left]) {
					ans += arr[left] * arr[left + 1] + arr[right];
				} else if (arr[left] * arr[left + 1] + arr[right] < arr[right - 1] * arr[right] + arr[left]) {
					ans += arr[right - 1] * arr[right] + arr[left];
				}
				left += 3;
			} else if (right - left == 1) { // 1일 경우
				if (arr[left] * arr[right] >= arr[left] + arr[right]) {
					ans += arr[left] * arr[right];
				} else {
					ans += arr[left] + arr[right];
				}
				left += 2;
			} else {
				ans += arr[left];
				left++;
			}
		}
	
		System.out.println(ans);
	}
	*/
}
