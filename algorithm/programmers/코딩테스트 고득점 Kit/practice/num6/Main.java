import java.util.*;
class Solution {
	public String[] solution(String[] strings, int n) {

		// 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
		// => 우선 사전정렬을 먼저 했다.

		Arrays.sort(strings);

		ArrayList<String> arrayList = new ArrayList<>();
		for (int i = 0; i < strings.length; i++) {
			arrayList.add(strings[i]);
		}

		MyComparator myComparator = new MyComparator(n);
		Collections.sort(arrayList, myComparator);

		String[] answer = arrayList.toArray(new String[arrayList.size()]);

		return answer;
	}
}

class MyComparator implements Comparator<String> {

	private int n;

	public MyComparator(int n) {
		this.n = n;
	}

	@Override
	public int compare(String o1, String o2) {
		char c1 = o1.charAt(n);
		char c2 = o2.charAt(n);

		if (c1 > c2)
			return 1; // 오름차순
		else if (c1 < c2)
			return -1;
		else
			return 0;
	}
}