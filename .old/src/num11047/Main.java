package num11047;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		int result = 0;

		for (int i = n - 1; i >= 0; i--) {
			result += k / arr[i];
			k %= arr[i];
		}

		System.out.println(result);
	
		scanner.close();
	}

}
