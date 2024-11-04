package boj;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 S1 ( https://www.acmicpc.net/problem/13335 )
 * 구현, 자료 구조, 시뮬레이션, 큐
 */
public class BJ_13335_트럭 {

    static int n, w, L, input[], weight, time, cnt;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static PriorityQueue<Node> temp = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 트럭의 수
        w = Integer.parseInt(st.nextToken()); // 다리의 길이
        L = Integer.parseInt(st.nextToken()); // 다리의 최대하중

        input = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이
        while(cnt < n) {
            // 0. 시간증가
            time++;

            // 1. 다리 위에 있는 트럭 한칸 씩 이동
            while(!pq.isEmpty()) {
                Node tmp = pq.poll();
                if(tmp.time + 1 > w) { // 다리 전부 건넜으면 다리 하중 빼주기
                    weight -= tmp.weight;
                } else { // 다리 아직 못건넜으면 유지 ( 시간 늘려서 넣어주기 )
                    temp.offer(new Node(tmp.weight, tmp.time + 1));
                }
            }

            // 2. 새로운 트럭 올라 올 수 있는지 확인
            if(weight + input[cnt] <= L) {
                weight += input[cnt];
                temp.offer(new Node(input[cnt++], 1));
            }

            // 3. 임시 큐 복사
            while(!temp.isEmpty()) {
                pq.offer(temp.poll());
            }
        }

        // 맨 마지막 기차가 다 건너는 시간 더해주기
        int max = 0;
        while(!pq.isEmpty()) {
            max = Math.max(max, w - pq.poll().time + 1);
        }

        bw.write((time + max) + "");

        bw.flush();
        bw.close();
    }

    static class Node implements Comparable<Node> {
        int weight, time;

        public Node(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return o.time - this.time; // 내림차순 정렬
        }
    }
}
