package ict3;

import java.util.*;

public class Main {

	static int N, M, COUNT = 0;

	static int visit[][];
	static int map[][];

	// (x,y) 이동 가능한 좌표값
	static int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] dy = { 2, 1, -1, -2, -2, -1, 1, 2 };

	public static void main(String[] args) {
		// 말을 움직일 수 있는 모든 경우를 map에 체크 해준다.
		// 말들을 움직일 수 있는 곳을 모두 map에 1로 바꿔준다.
		// 말이 3개가 되면 rank 값이 3이 되면 그점에 모두 모이는 것이다.

		String[] board = { "........", ".1......", "........", "....3...", "........", "........", ".7......",
				"........" };

		System.out.println(board.length);
		System.out.println(board[0].length());

		visit = new int[board.length][board[0].length()];
		map = new int[board.length][board[0].length()];

		for (int[] row : visit) {
			Arrays.fill(row, 0);
		}

		ArrayList<Point> al = new ArrayList<>();

		// 말들의 초기 위치를 넣는다.
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length(); j++) {
				String s = board[i];
				if (s.charAt(j) != '.') {
					al.add(new Point(i, j));
				}
			}
		}

		for (int i = 0; i < al.size(); i++) {
			bfs(al);
		}

	}

	private static void bfs(ArrayList<Point> al) {

		Queue<Point> q = new LinkedList<>();

		for (int i = 0; i < al.size(); i++) {
			q.offer(al.get(i)); // 처음 말을 큐에 추가

			// 큐에 있는 노드들의 가능한 다음 목적지를 다시 큐에 넣는 작업을 반복
			while (!q.isEmpty()) {

				int size = q.size();

				COUNT++;

				for (int k = 0; k < size; k++) {

					Point node = q.poll();

					for (int j = 0; j < 8; j++) { // 시계방향으로 갈수 있는 8방향 쳌크

						int sx = node.x + dx[j];
						int sy = node.y + dy[j];

						if (sx >= 0 && sx < N && sy >= 0 && sy < M && visit[sx][sy] == 0 && map[sx][sy] == 1) {

							// 마지막 인덱스와 같다면 더 이상 큐에 안넣음
							if (sx == (N - 1) && sy == (M - 1))
								return;

							visit[sx][sy] += 1;

							q.offer(new Point(sx, sy));
						}
					}
				}
			}

		}

	}
}

class Point {

	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
