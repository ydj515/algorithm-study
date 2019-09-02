package num17370;

import java.util.Scanner;

public class Main2 {

	private static boolean[][] map;
	private static int n, answer;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();

		map = new boolean[50][50];
		map[25][25] = true;

		dfs(24, 25, 1, 0);
		System.out.println(answer);
	}

	private static void dfs(int y, int x, int dir, int depth) {
		if (depth == n) {
			if (map[y][x])
				answer++;
			return;
		}
		if (map[y][x])
			return;

		if (dir == 1) {
			map[y][x] = true;
			dfs(y - 1, x + 1, 3, depth + 1);
			dfs(y - 1, x - 1, 5, depth + 1);
			map[y][x] = false;
		} else if (dir == 2) {
			map[y][x] = true;
			dfs(y + 1, x + 1, 4, depth + 1);
			dfs(y + 1, x - 1, 6, depth + 1);
			map[y][x] = false;
		} else if (dir == 3) {
			map[y][x] = true;
			dfs(y - 1, x, 1, depth + 1);
			dfs(y + 1, x + 1, 4, depth + 1);
			map[y][x] = false;
		} else if (dir == 4) {
			map[y][x] = true;
			dfs(y + 1, x, 2, depth + 1);
			dfs(y - 1, x + 1, 3, depth + 1);
			map[y][x] = false;
		} else if (dir == 5) {
			map[y][x] = true;
			dfs(y - 1, x, 1, depth + 1);
			dfs(y + 1, x - 1, 6, depth + 1);
			map[y][x] = false;
		} else {
			map[y][x] = true;
			dfs(y + 1, x, 2, depth + 1);
			dfs(y - 1, x - 1, 5, depth + 1);
			map[y][x] = false;
		}
	}
}
