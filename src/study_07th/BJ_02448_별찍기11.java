package study_07th;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/2448 )
 */
public class BJ_02448_별찍기11 {

	static int N;
	static StringBuilder[] sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		int k = (int) (Math.log(N/3)/Math.log(2));
		sb = new StringBuilder[N];
		
		for (int i = 0; i < N; i++) {
			sb[i] = new StringBuilder();
		}
		
		sb[0].append("  *  ");
		sb[1].append(" * * ");
		sb[2].append("*****");
		
		for (int i = 1; i <= k; i++) {
			
			int n = 3 * (int) Math.pow(2, i);
			
			// 아래 추가
			for (int j = n/2; j < n; j++) {
				sb[j].append(sb[j - n/2]).append(" ").append(sb[j - n/2]);
			}
			
			// 위에 공백 추가
			String blank = "";
			for (int j = 0; j < n/2; j++) {
				blank += " ";
			}
			
			for (int j = 0; j < n/2; j++) {
				StringBuilder s = new StringBuilder(sb[j]);
				sb[j].setLength(0);
				sb[j].append(blank).append(s).append(blank);
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(sb[i]);
		}
		
	}

}
