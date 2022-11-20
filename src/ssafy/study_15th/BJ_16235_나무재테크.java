package ssafy.study_15th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/16235 )
 */
public class BJ_16235_나무재테크 {

	static int N, M, K; // N : 전체 땅의 행과 열, M : 처음에 주어진 나무의 개수, K : 년수
	static int[][] foods, lands; // 땅마다 추가되는 양분, 전체 땅
	static ArrayList<Tree> trees = new ArrayList<>(); // 나무들
	static Deque<Integer> deadTrees = new LinkedList<>(); // 죽은 나무들

	public static void main(String[] args) throws IOException {
		// 입력정보 받고 초기화
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] N_M_K = reader.readLine().split(" ");
		N = Integer.parseInt(N_M_K[0]);
		M = Integer.parseInt(N_M_K[1]);
		K = Integer.parseInt(N_M_K[2]);
		foods = new int[N][N];
		lands = new int[N][N];

		// 매년마다 추가 될 양분 정보 받기, 초기 땅의 양분 초기화
		for (int i = 0; i < N; i++) {
			String[] food = reader.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				foods[i][j] = Integer.parseInt(food[j]);
				lands[i][j] = 5;
			}
		}

		// 초기에 주어진 나무들
		for (int i = 0; i < M; i++) {
			String[] tree = reader.readLine().split(" ");
			trees.add(new Tree(tree));
		}

		// 처음에 주어진 나무들을 어린나이 순으로 정렬
		Collections.sort(trees, (t1, t2) -> t1.age - t2.age);

		// 주어진 년수가 0일 때까지 반복
		while (K != 0) {
			spring(); // 봄
			summer(); // 여름
			fall(); // 가을
			winter(); // 겨울
			K--; // 년수 감소
		}

		// 땅에 있는 전체 나무 개수 출력
		System.out.println(trees.size());
	}

	/**
	 * 봄
	 */
	public static void spring() {
		// 현재 나무들 전체 탐색
		for (int i = 0; i < trees.size(); i++) {
			Tree tree = trees.get(i);
			// 땅의 양분이 나무의 나이보다 적으면
			if (lands[tree.row][tree.col] < tree.age) {
				// 나무는 죽음
				deadTrees.add(i);
				continue;
			}
			// 아니라면 땅의 양분 먹고 나무 나이 1증가
			lands[tree.row][tree.col] -= tree.age;
			tree.age++;
		}
	}

	/**
	 * 여름
	 */
	public static void summer() {
		// 죽은 나무들 하나씩 탐색
		while (!deadTrees.isEmpty()) {
			// 죽은 나무의 인덱스 꺼내기
			int deadTreeIndex = deadTrees.pollLast();
			// 인덱스로 죽은 나무 찾기
			Tree deadTree = trees.get(deadTreeIndex);
			// 죽은 나무의 나이 / 2 만큼 양분 땅에 추가
			int food = deadTree.age / 2;
			lands[deadTree.row][deadTree.col] += food;
			// 나무는 죽음
			deadTree.dead = true;
		}
	}

	/**
	 * 가을
	 */
	public static void fall() {
		// 8군데 좌표계산에 사용할 배열
		int[] moveRow = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] moveCol = { -1, 0, 1, -1, 1, -1, 0, 1 };
		// 새로 생성될 나무들 저장할 리스트
		ArrayList<Tree> newTrees = new ArrayList<>();
		// 현재 나무들 전체 탐색
		for (int p = 0; p < trees.size(); p++) {
			Tree tree = trees.get(p);
			// 죽은 나무는 건너뛰기
			if (tree.dead) {
				continue;
			}
			// 살아있는 나무의 나이가 5의 배수라면
			if (tree.age % 5 == 0) {
				// 전체 땅을 벗어나지 않을 때 번식
				for (int i = 0; i < 8; i++) {
					int nr = tree.row + moveRow[i];
					int nc = tree.col + moveCol[i];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
						continue;
					}
					// 나이가 1인 나무 생성
					newTrees.add(new Tree(nr, nc, 1));
				}
			}
		}
		// 새로 생성된 나무들이 저장된 리스트에 기존의 살아있는 나무들 추가
		for (Tree tree : trees) {
			if (!tree.dead) {
				newTrees.add(tree);
			}
		}
		// 기존 나무 + 새로 생성된 나무
		trees = newTrees;
	}

	/**
	 * 겨울
	 */
	public static void winter() {
		// 땅마다 새로 양분 추가
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				lands[i][j] += foods[i][j];
			}
		}
	}

	// 나무
	static class Tree {
		int row; // 나무가 있는 행
		int col; // 나무가 있는 열
		int age; // 나무의 나이
		boolean dead; // 나무 생존 여부

		public Tree(String[] tree) {
			this.row = Integer.parseInt(tree[0]) - 1;
			this.col = Integer.parseInt(tree[1]) - 1;
			this.age = Integer.parseInt(tree[2]);
		}

		public Tree(int row, int col, int age) {
			this.row = row;
			this.col = col;
			this.age = age;
		}
	}
}
