package study_2nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 실버5 ( https://www.acmicpc.net/problem/1436 )
 */
// 메모리: 14,288KB, 실행시간: 272ms
public class BJ_01436_영화감독숌 {

	static int N, count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int i = 666;
		int ten = 1; // 자리수 체크
		while(true) {
			
			if(i / ten == 0) { // 자리수 넘어가면 숫자 바꿔서 다시 체크
				ten = 1;
				i++;
			}
			
			if((i/ten)%10 == 6) { // 연속된 6중 첫번째 체크
				ten *= 10;
				if((i/ten)%10 == 6) { // 연속된 6중 두번째 체크
					ten *= 10;
					if((i/ten)%10 == 6) { // 연속된 6중 세번째 체크
						count++;
						if(count == N) {
							System.out.println(i);
							break;
						}
						// 찾았으면 숫자 바꿔서 다시 체크
						ten = 1;
						i++;
					} else ten /= 10;
				} else ten /= 10;
			} 
			
			ten *= 10; // 자리수 변경
		}
	}
}
