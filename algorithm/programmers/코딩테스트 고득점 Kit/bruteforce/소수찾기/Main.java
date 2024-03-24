import java.util.*;
class Solution {

	static ArrayList<Integer> al = new ArrayList<>();
	static Set<Integer> combinationSet = new HashSet<>(); // 01과 1의 경우 동일하기 때문에 HashSet으로 중복 검사
	static ArrayList<Integer> primeNumbers = new ArrayList<>();

	public int solution(String numbers) {

		int answer = 0;

		for (int i = 0; i < numbers.length(); i++) {
			al.add(Integer.parseInt(String.valueOf(numbers.charAt(i))));
		}

		LinkedList<Integer> perArr = new LinkedList<Integer>();
		int[] perCheck = new int[al.size()];

		// 순열 nPr
		for (int i = 1; i <= al.size(); i++) {
			permutation(al.size(), i, perArr, perCheck);
		}

		Iterator<Integer> it = combinationSet.iterator();

		while (it.hasNext()) {
			int n = it.next(); // it.next()를 계속 쓰면 이터레이터로 한개씩 넘어가기 때문에 변수 지정해주고 해줘야 한개씩 체크 가능
			if (isPrimeNumber(n)) {
				primeNumbers.add(n);
			}
		}
		
		return primeNumbers.size();
	}

	// 소수 판별
	public boolean isPrimeNumber(int n) {
		if ((n == 1) || (n == 0)) {
			return false;
		}

		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	// 순열 (순서있게 배열)
	public static void permutation(int n, int r, LinkedList<Integer> perArr, int[] perCheck) {

		if (perArr.size() == r) {
			String temp = "";

			for (int i : perArr) {
				temp += i;
			}

			combinationSet.add(Integer.parseInt(temp)); // 중복 검사 ex) 1, 01은 동일하게 1로 insert
			System.out.println(temp);

			return;
		}

		for (int i = 0; i < n; i++) {

			if (perCheck[i] == 0) {
				perArr.add(al.get(i));
				perCheck[i] = 1;
				permutation(n, r, perArr, perCheck);
				perCheck[i] = 0;
				perArr.removeLast();
			}
		}

	}

}