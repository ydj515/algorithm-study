package num17362;

import java.util.Scanner;

public class Main { // https://www.acmicpc.net/problem/17362

	public static void main(String[] args) {

		/* 
		 * 1  2  3  4  5
		 * 9  8  7  6
		 *    10 11 12 13
		 * 17 16 15 14
		 *    18 19 20 21   
		 * */
		
		int n;
		
		Scanner scanner = new Scanner(System.in);

		n = scanner.nextInt();
		
		if (n % 8 >= 1 && n % 8 <= 5) {
			System.out.println(n % 8);
		} else if (n % 8 == 6) {
			System.out.println(4);
		} else if (n % 8 == 7) {
			System.out.println(3);
		} else if (n % 8 == 0) {
			System.out.println(2);
		}
	}

}
