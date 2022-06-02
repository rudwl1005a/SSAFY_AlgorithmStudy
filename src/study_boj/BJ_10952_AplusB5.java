package study_boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10952_AplusB5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == 0 && b == 0) {
				break;
			}
			
			sb.append(a+b).append("\n");
		}
		System.out.println(sb);
	}

}
