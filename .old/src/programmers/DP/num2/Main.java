import java.util.*;
class Solution {

	public long solution(int N) {

		long answer = 0;

		List<Long> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(dynamicFibonacci(i));
		}

		// System.out.println(list);

		answer = list.get(N - 1) * 2 + (list.get(N - 1) + list.get(N - 2)) * 2;
		// System.out.println(answer);

		return answer;
	}

	public int Fibonacci(int n) {// 재귀함수 활용

		if (n <= 1)
			return 1;
		else
			return Fibonacci(n - 1) + Fibonacci(n - 2);
	}

	public long dynamicFibonacci(int n) {// 동적프로그래밍

		long last1, last2, result = 0;

		if (n <= 1) {
			return 1;
		}

		last1 = 1;
		last2 = 1;

		for (int i = 1; i < n; i++) {
			result = last1 + last2;
			last1 = last2;
			last2 = result;
		}

		return result;
	}

}