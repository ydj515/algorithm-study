package num10610;

import java.util.*;

public class Main {

	// 조합한 숫자가 30의 배수가 안된다면 0이 입력 값에 없고, 각 자리수의 총합이 3의 배수가 안되면 30의 배수가 아니다.

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		List<Integer> numCountArr = new ArrayList<Integer>();
		int sum = 0;

		for (int i = 0; i < input.length(); i++) {
			int n = Integer.parseInt(input.substring(i, i + 1)); // 숫자 한개씩 짜름
			numCountArr.add(n);
			sum += n; // 각 자리수 다 더하기
		}

		// 30배수가 아닐 조건
		if (!input.contains("0") || sum % 3 != 0) {
			System.out.println("-1");
		} else {
			// 내림차순 정렬
			Collections.sort(numCountArr, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				}

			});

			String result = "";

			for (int i = 0; i < input.length(); i++) {
				result += numCountArr.get(i);
			}

			System.out.println(result);
		}

		scanner.close();

	}
}