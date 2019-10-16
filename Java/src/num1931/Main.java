package num1931;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		List<Meeting> list = new ArrayList<Meeting>();

		for (int i = 0; i < n; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			list.add(new Meeting(start, end));
		}

		Collections.sort(list);

		int cnt = 1; // 1개는 무조건 사용할 수 잇으므로
		int end = list.get(0).end;

		for (int i = 1; i < n; i++) {
			if (list.get(i).start >= end) {
				cnt++;
				end = list.get(i).end;
			}
		}

		System.out.println(cnt);

		scanner.close();
	}

}

class Meeting implements Comparable<Meeting> {

	int start;
	int end;

	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting o) {

		int standard = end - o.end; // 끝나는 시간 순으로 정렬

		if (standard == 0) { // 끝나는 시간이 같다면 시작 시간순으로 정렬
			standard = start - o.start;
		}

		return standard;
	}

}