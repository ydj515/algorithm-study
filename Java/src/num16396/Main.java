package num16396;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int arr[][] = new int[n][2];

		// x, y 저장
		for (int i = 0; i < n; i++) {

			int x = scanner.nextInt();
			int y = scanner.nextInt();

			arr[i][0] = x;
			arr[i][1] = y;

		}

		// 최댓값 찾기
		int max = arr[0][1];

		for (int i = 0; i < 4; i++) {
			if (arr[i][1] > max) {
				max = arr[i][1];
			}
		}

		// max 사이즈 만큼의 배열에서 겹치는 숫자를 1로 바꾸면 그게 길이
		int arr2[] = new int[max];
		for (int i = 0; i < max; i++) {
			arr2[i] = 0;
		}

		for (int i = 0; i < 4; i++) {
			for (int j = arr[i][0] - 1; j < arr[i][1] - 1; j++) {
				arr2[j] = 1;
			}
		}

		int sum = 0;

		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] == 1) {
				sum += 1;
			}
		}

		System.out.println(sum);
	}

}
