package study_8th;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/1644 )
 */
public class BJ_01644_소수의연속합_시간초과 {
	
	static int N, cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int prev = 2;
		while(true) {
			int sum = 0;
			int prev2 = prev;
			while(true) {
				sum += prev2;
				if(sum == N) {
					cnt++;
					break;
				} else if(sum > N) {
					break;
				}
				prev2 = next(prev2);
				if(prev2 == -1) {
					break;
				}
			}
			prev = next(prev);
			if(prev == -1) {
				break;
			}
		}
		
		if(isPrime(N)) {
			cnt++;
		}
		
		System.out.println(cnt);
	}

	private static int next(int n) { // 다음 소수 찾기
		for (int i = n + 1; i < N; i++) {
			if(isPrime(i)) {
				return i; 
			}
		}
		return -1;
	}
	
	private static boolean isPrime(int n) {
		boolean b = true;
		for (int i = 2; i < n; i++) { // 소수인지 판별
			if(n % i == 0) {
				b = false;
				break;
			}
		}
		
		return b;
	}

}
