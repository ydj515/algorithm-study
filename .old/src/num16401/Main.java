package num16401;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int m = scanner.nextInt();
		int n = scanner.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		// 막대과자 최대 길이
		int max = 0;

		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		int cnt = 0;

		for (int i = max; i > 1; i--) {

			cnt = 0; // 조각의 갯수

			for (int j = 0; j < arr.length; j++) {

				cnt += arr[j] / i;
			}

			if (cnt == m) { // 조각의 갯수가 조카수와 같다면 더이상 진행할 필요 x
				System.out.println(i);
				break;
			}
		}

	}

}
