package boj;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 백준 S3 ( https://www.acmicpc.net/problem/18115 )
 * 자료 구조, 덱
 */
public class BJ_18115_카드놓기 {

    static int N, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 덱 사용하여 상황에 맞게 앞뒤로 넣어주기
        Deque<Integer> dq = new LinkedList<>();
        for(int i = N - 1; i >= 0; i--) {
            if(arr[i] == 1) { // 제일 위의 카드 1장을 바닥에 내려놓는다.
                dq.addFirst(N - i);
            } else if(arr[i] == 2) { // 위에서 두 번째 카드를 바닥에 내려놓는다.
                int tmp = dq.pollFirst();
                dq.addFirst(N - i);
                dq.addFirst(tmp);
            } else { // 제일 밑에 있는 카드를 바닥에 내려놓는다.
                dq.addLast(N - i);
            }
        }

        for(int i = 0; i < N; i++) {
            bw.write(dq.poll() + " ");
        }

        bw.flush();
        bw.close();
    }
}
