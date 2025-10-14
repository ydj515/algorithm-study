package num15897;

import java.util.Scanner;

public class Main {

	/* j:1 .. 8 j:2 .. 1 j:3 .. 2 j:4 .. 2 j:5 .. 3 j:6 .. 2 j:7 .. 4 j:8 .. 2 
	 * j:1 .. 8 j:3 .. 2 j:5 .. 3 j:7 .. 4 
	 * j:1 .. 8 j:4 .. 2 j:7 .. 4 
	 * j:1 .. 8 j:5 .. 3 
	 * j:1 .. 8 j:6 .. 2 
	 * j:1 .. 8 j:7 .. 4 
	 * j:1 .. 8 j:8 .. 2 
	 * j:1 .. 8 
	 * */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int sum = 0;

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) { // 나누어 떨어 진다면. =>몫이 소수가 아니라면
				sum += (n / i);
			} else { // 몫이 소수라면
				sum += (n / i) + 1;
			}
		}

		System.out.println(sum);

//		int sieve[] = new int[n + 1];
//
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n; j += i) {
//				sieve[j] += 1;
//			}
//		}
//
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n; j += i) {
//				System.out.print("j:" + j + " .. " + sieve[j] + " ");
//			}
//			System.out.println();
//		}
	}

}
