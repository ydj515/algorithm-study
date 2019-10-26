package num1946;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int testCase = scanner.nextInt();

		for (int j = 0; j < testCase; j++) {
			int n = scanner.nextInt();

			List<Rank> list = new ArrayList<Rank>();

			for (int i = 0; i < n; i++) {
				int document = scanner.nextInt();
				int interview = scanner.nextInt();
				list.add(new Rank(document, interview));
			}

			Collections.sort(list); // interview 성적(오름차순)순으로 정렬

			int cnt = 1; // 인터뷰 1등은 합격하므로 1명은 무조건 합격
			int standard = list.get(0).document;

			for (int i = 1; i < n; i++) {
				if (list.get(i).document < standard) {
					cnt++;
					standard = list.get(i).document;
				}
			}

			System.out.println(cnt);
		}

		scanner.close();
	}

}

class Rank implements Comparable<Rank> {

	int document;
	int interview;

	public Rank(int document, int interview) {
		this.document = document;
		this.interview = interview;
	}

	@Override
	public int compareTo(Rank o) {

		int standard = interview - o.interview;

		if (standard == 0) {
			standard = document - o.document;
		}

		return standard;

	}

}