package sort.b10814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 실버5 ( https://www.acmicpc.net/problem/10814 )
 */

// 출처 : 백준 nogy21님의 코드(https://www.acmicpc.net/source/38759215)
// 메모리: 39,044KB , 시간: 476ms
public class Main3 {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder[] ageSb = new StringBuilder[201];
        StringTokenizer st;

        for (int i = 0; i < 201; i++) {
            ageSb[i] = new StringBuilder("");
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            ageSb[age].append(age).append(" ").append(st.nextToken()).append("\n");
        }

        for (StringBuilder sb : ageSb) {
            System.out.print(sb);
        }
    }

}
