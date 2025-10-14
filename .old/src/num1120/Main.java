package num1120;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();

		String a[] = input.split(" ");

		int len = a[1].length() - a[0].length();

		int cnt = 0;
		int ans = 99999;

		for (int i = 0; i <= len; i++) {

			cnt = 0;

			for (int j = 0; j < a[0].length(); j++) {
				if (a[0].charAt(j) != a[1].charAt(j + i)) {
					cnt++;
				}
			}

			System.out.println("cnt : " + cnt);
			ans = Math.min(cnt, ans); // if문으로 min 값을 계속 갱신해도 되지만 Math함 써봣다 bro
		}

		System.out.println(ans);

		scanner.close();
	}
}
