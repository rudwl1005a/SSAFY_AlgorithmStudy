package ssafy.study_02nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Person {
	int weight;
	int height;
	int rank;
}

/*
 * 백준 실버5 ( https://www.acmicpc.net/problem/7568 )
 */
public class BJ_07568_덩치 {
	
	static int N, cnt;
	static Person[] person;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		person = new Person[N];
		for(int i=0; i<N; i++) {
			person[i] = new Person();
			StringTokenizer st = new StringTokenizer(br.readLine());
			person[i].height = Integer.parseInt(st.nextToken());
			person[i].weight = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			cnt = 1;
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				if(isBig(person[j], person[i])) { // rank는 (자기보다 큰 사람의 수 + 1)과 같다
					cnt++;
				}
			}
			person[i].rank = cnt;
		}
		
		for(Person p : person) {
			System.out.print(p.rank + " ");
		}
	}
	
	static boolean isBig(Person p1, Person p2) { // p1 > p2 : true
		
		if(p1.weight > p2.weight) {
			if(p1.height > p2.height) return true;
		}

		return false;
	}

}
