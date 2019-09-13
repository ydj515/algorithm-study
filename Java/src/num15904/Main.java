package num15904;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String s = scanner.nextLine();

		int count = 0;

		for (int i = 0; i < s.length(); i++) {

			String temp = s.substring(i, i + 1);

			if (count == 0) {
				if (temp.equals("U")) {
					count++;
				}
			} else if (count == 1) {
				if (temp.equals("C")) {
					count++;
				}
			} else if (count == 2) {
				if (temp.equals("P")) {
					count++;
				}
			} else if (count == 3) {
				if (temp.equals("C")) {
					count++;
				}
			}
		}

		if (count == 4) {
			System.out.println("I love UCPC");
		} else {
			System.out.println("I hate UCPC");
		}
	}

}