package num17364;

import java.util.Scanner;

public class Main {

	static int calculateScore(int recentdice[]) {

		int x = recentdice[0];
		int y = recentdice[1];
		int z = recentdice[2];
		int score = 0;
		int max = 0;

		if (x == y && x == z && y == z) {
			score = 10000 + x * 1000;
		} else if (x == y || x == z) {
			score = 1000 + x * 100;
		} else if (y == z) {
			score = 1000 + y * 100;
		} else {
			if (x > y && x > z) {
				max = x;
			} else if (y > x && y > z) {
				max = y;
			} else if (z > x && z > y) {
				max = z;
			}

			score = max * 100;
		}

		return score;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int dice[] = new int[n];
		int recentdice[] = new int[3];

		for (int i = 0; i < n; i++) { // 기본 3번 이상이므로 주사위 굴려서 배열에 저장
			double random = Math.random();
			int value = (int) (random * 6) + 1;
			dice[i] = value;
			// n--;
			recentdice[i % 3] = dice[i];

			if (i >= 2) { // 3번 이상 굴린 후 부터 prize 계산
				// for (int j = 0; j < 3; j++) {
				// System.out.println("recentdice : " + j + " : " + recentdice[j]);
				// }
				System.out.println("score : " + calculateScore(recentdice));
				System.out.println("======================");
			}
		}
		// System.out.println("==========");
		// for (int i = 0; i < dice.length; i++) {
		// System.out.println(dice[i]);
		// }
		// System.out.println("==========");

		// recentdice[0] = dice[dice.length - 1]; // 제일 최신꺼
		// recentdice[1] = dice[dice.length - 2];
		// recentdice[2] = dice[dice.length - 3];
		// recentdice[3] = n;

		// for (int i = 0; i < recentdice.length; i++) {
		// System.out.println(recentdice[i]);
		// }

		// System.out.println("==========");

		// score 계산
		// int prize = calculateScore(recentdice);
		// System.out.println(prize);
	}

}
