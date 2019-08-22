package num15953;

import java.util.Scanner;

public class Main {

	static int f(int a) {

		if (a == 0)
			return 0;
		if (a <= 1)
			return 500 * 10000;
		if (a <= 3)
			return 300 * 10000;
		if (a <= 6)
			return 200 * 10000;
		if (a <= 10)
			return 50 * 10000;
		if (a <= 15)
			return 30 * 10000;
		if (a <= 21)
			return 10 * 10000;

		return 0;
	}

	static int g(int b) {

		if (b == 0)
			return 0;
		if (b <= 1)
			return 512 * 10000;
		if (b <= 3)
			return 256 * 10000;
		if (b <= 7)
			return 128 * 10000;
		if (b <= 15)
			return 64 * 10000;
		if (b <= 31)
			return 32 * 10000;

		return 0;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n;
		int a, b;

		n = scanner.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			a = scanner.nextInt();
			b = scanner.nextInt();
			arr[i] = f(a) + g(b);
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}

	}

}
