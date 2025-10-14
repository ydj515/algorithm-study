package num2875;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int result = 0;

		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int k = scanner.nextInt();

		int sum = n + m - k;

		while (n >= 2 && m >= 1 && sum >= 3) {
			n -= 2;
			m -= 1;
			sum -= 3;
			result++;
		}

		System.out.println(result);

		scanner.close();
	}

}
