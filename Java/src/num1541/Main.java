package num1541;

import java.util.Scanner;

public class Main {
	// - 부호 앞에 괄호 해주면 끝
	// - 부호가 나오면 그 다음 - 부호가 나올 때 괄호를 닫는다.
	// split 할 때 split("-") 하게 되면 만약에 수식에 -가 없으면 에러가 난다 => split("\\-")로 짜르면 오류 안남
	// 만약 짤리지 않을 경우 통으로 들어감
	// ex) 50+80+90 => splitMinus[0]=50+80+90, length=1
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();

		String splitMinus[] = input.split("\\-");

		int result = 0;

		// System.out.println(splitMinus.length);
		// System.out.println(splitMinus[0]);

		for (int i = 0; i < splitMinus.length; i++) {

			String[] splitPlus = splitMinus[i].split("\\+");

			int n = 0;

			for (String s : splitPlus) {
				n += Integer.parseInt(s);
			}

			if (i == 0) {
				n *= -1;
			}

			result -= n;
		}

		System.out.println(result);

		scanner.close();
	}
}
