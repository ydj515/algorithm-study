package num5585;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int arr[] = { 500, 100, 50, 10, 5, 1 };

		int exchange = 1000 - n;

		int cnt = 0;

		for (int i = 0; i < 6; i++) {
			if ((exchange / arr[i]) >= 1) {
				cnt += (exchange / arr[i]);
				exchange -= (arr[i] * (exchange / arr[i]));
			}
		}

		System.out.println(cnt);

		scanner.close();
	}

}