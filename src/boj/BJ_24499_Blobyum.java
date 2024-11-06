package boj;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 S4 ( https://www.acmicpc.net/problem/24499 )
 * 누적 합, 슬라이딩 윈도우
 */
public class BJ_24499_Blobyum {

    static int N, K, input[], max, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 애플파이 개수
        K = Integer.parseInt(st.nextToken()); // 먹으려는 애플파이 개수
        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            if(i < K) sum += input[i]; // 초기 최대값 설정: 0 ~ (K -1)까지의 합
        }
        max = Math.max(max, sum);

        // 풀이
        int end = K - 1;
        for(int start = 1; start < N; start++) {
            // start와 end를 하나씩 증가시키면서 최대값 구하기 > 원형이기 때문에 end를 증가할 때는 %를 사용하여 index범위 넘지 않게
            sum = sum - input[start - 1] + input[((++end) % N)];
            max = Math.max(max, sum);
        }

        bw.write(max + "");

        bw.flush();
        bw.close();
    }
}
