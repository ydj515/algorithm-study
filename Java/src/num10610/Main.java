package num10610;

import java.util.*;

public class Main {
	
	// 조합한 숫자가 30의 배수가 안된다면 0이 입력 값에 없고, 각 자리수의 총합이 3의 배수가 안되면 30의 배수가 아니다.

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