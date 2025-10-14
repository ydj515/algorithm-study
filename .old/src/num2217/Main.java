package num2217;

import java.util.*;

public class Main {

	// 로프가 버틸수 있는 최대 중량은 제일 작은 거 * n개

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		Arrays.sort(arr);

		System.out.println(arr[0] * n);

		scanner.close();
	}
}