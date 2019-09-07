package programmers.hash.num2;

public class Main {

	public boolean solution(String[] phone_book) {
		boolean answer = true;

		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 0; j < phone_book.length; j++) {
				// System.out.println("phone_book[i] : " + phone_book[i]);
				// System.out.println("phone_book[j] : " + phone_book[j]);
				if (i == j) // i와 j같다면 비교할 필요 x
					continue;
				if (phone_book[i].startsWith(phone_book[j])) {
					answer = false;
					return answer;
				}

			}
		}
		// System.out.println(answer);
		return answer;
	}
}
