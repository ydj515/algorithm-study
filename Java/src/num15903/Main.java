package num15903;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int m = scanner.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		Arrays.sort(arr, 1, arr.length);

		// for(int i=0;i<arr.length;i++) {
		// System.out.println(arr[i]);
		// }

		for (int i = 0; i < m; i++) {
			int temp = arr[0] + arr[1];
			arr[0] = temp;
			arr[1] = temp;
			// Arrays.sort(arr,1,arr.length);
		}

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		System.out.println(sum);
	}

}
