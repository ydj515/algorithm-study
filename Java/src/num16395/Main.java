package num16395;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int k = scanner.nextInt();

		int arr[][] = new int[n + 1][k + 1];

		arr[1][1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
			}
		}

		System.out.println(arr[n][k]);
	}

}
