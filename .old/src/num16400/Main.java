package num16400;

import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		// int n =8;
		Vector<Integer> primeNumberVector = new Vector<Integer>(n); // 소수 저장 백터

		// 소수 구하기
		for (int i = 2; i <= n; i++) {
			boolean isPrime = true; // 초기 값

			for (int j = 2; j * j <= i; j++) {

				if (i % j == 0) {// 소수가 아니다.
					isPrime = false;
					break;
				}
			}

			if (isPrime) { // 소수라면
				primeNumberVector.add(i);
			}
		}

		// 경우의 수 구하기
		// 사실상 도움을 받았는데 먼 개소린지 모르겟다
		int[] dp = new int[n + 1];
		dp[0] = 1;

		for (int i = 0; i < primeNumberVector.size(); i++) {
			for (int j = 0; j <= n; j++) {
				if (primeNumberVector.get(i) + j <= n) {
					dp[primeNumberVector.get(i) + j] += dp[j];
					dp[primeNumberVector.get(i) + j] %= 123456789;
				}
			}
		}

		System.out.println(dp[n]);

	}

}
