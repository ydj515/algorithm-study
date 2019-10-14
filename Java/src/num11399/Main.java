package num11399;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int arr[] = new int[5];

		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		Arrays.sort(arr);

		int result = arr[0];

		for (int i = 1; i < n; i++) {
			arr[i] = arr[i - 1] + arr[i];
			result += arr[i];
		}

		System.out.println(result);

		scanner.close();
	}

}