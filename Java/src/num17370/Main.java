package num17370;

import java.util.Scanner;

public class Main {

	static boolean[] chk = new boolean[3000];
	// static int[] weight = { 23, 1, 1, -23, -1, -1 };
	static int[] weight = { 1, 2, 3, 4, 5, 6 };

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(); // 몇번 인지 입력

		chk[100] = true;

		System.out.println(calc(n, 100 + weight[0], 0));
	}

	static int calc(int cnt, int cur, int w) {
		if (cnt == 0) {
			if (chk[cur])
				return 1;
			else
				return 0;
		}
		if (chk[cur])
			return 0;

		chk[cur] = true;
		int temp = calc(cnt - 1, cur + weight[(w + 5) % 6], (w + 5) % 6)
				+ calc(cnt - 1, cur + weight[(w + 1) % 6], (w + 1) % 6);
		chk[cur] = false;
		return temp;
	}
}
