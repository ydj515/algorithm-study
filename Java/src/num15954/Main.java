package num15954;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		/*
		 * 평균(mean) : m = (a+b+c) / n 분산(variance) : v = (a-m)^2 + (b-m)^2 + (c-m)^2
		 * 표준편차(standard deviation) : sd = Math.sqrt(v)
		 */

		Scanner scanner = new Scanner(System.in);

		int n, k;

		// double ans = 1e18;
		double result = 0;

		n = scanner.nextInt();
		k = scanner.nextInt();

		int favorite[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			favorite[i] = scanner.nextInt();
		}

		for (int i = 1; i <= n; i++) {

			int sum = 0;

			for (int j = i; j <= n; j++) {

				sum += favorite[j];

				double m = sum / (double) (j - i + 1);

				if (j - i + 1 >= k) {

					double v = 0;

					for (int l = i; l <= j; l++) {
						v += (double) (favorite[l] - m) * (double) (favorite[l] - m);
					}

					v /= (j - i + 1);

					result = v;

				}
			}
		}

		System.out.println(Math.sqrt(result)); // 표준편차
	}

}
