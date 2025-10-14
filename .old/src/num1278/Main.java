package num1278;

import java.util.*;

public class Main {

	static int N, M, COUNT = 0;

	static boolean visit[][];
	static int map[][];

	// (x,y) => 상(0,1) 좌(-1,0) 하(0,-1) 우(1,0)
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();
		M = scanner.nextInt();

		visit = new boolean[N][M];
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = scanner.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0'; // 숫자 하나씩 입력
			}
		}

		bfs();

		System.out.println(COUNT + 1);

		scanner.close();
	}

	private static void bfs() {

		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0)); // 처음 (0, 0) 인덱스를 큐에 추가

		// 큐에 있는 노드들의 가능한 다음 목적지를 다시 큐에 넣는 작업을 반복
		while (!q.isEmpty()) {

			int size = q.size();

			COUNT++;

			for (int i = 0; i < size; i++) {

				Point node = q.poll();

				for (int j = 0; j < 4; j++) { // 상 좌 하 우 순

					int sx = node.x + dx[j];
					int sy = node.y + dy[j];

					if (sx >= 0 && sx < N && sy >= 0 && sy < M && visit[sx][sy] == false && map[sx][sy] == 1) {

						// 마지막 인덱스와 같다면 더 이상 큐에 안넣음
						if (sx == (N - 1) && sy == (M - 1))
							return;

						visit[sx][sy] = true;

						q.offer(new Point(sx, sy));
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