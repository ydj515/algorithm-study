class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
        
        // 1 : 여분 가진 애들
        // 0 : 지꺼만 있는 애들
        // -1 : 잃어버린 애들

		int answer = 0;

		int[] student = new int[n];

		for (int i = 0; i < n; i++) {
			student[i] = 0;
		}

		for (int i = 0; i < lost.length; i++) {
			student[lost[i] - 1] -= 1;
		}

		for (int i = 0; i < reserve.length; i++) {
			student[reserve[i] - 1] += 1;
		}

		for (int i = 0; i < n; i++) {
			System.out.println(student[i]);
		}

		System.out.println("==============");
		for (int i = 0; i < n; i++) {
			System.out.println("i : " + i);

			if (i == 0) { // 처음 index
				System.out.println("index 처음");
				if (student[i] == -1 && student[i + 1] == 1) {

					student[i] = 0;
					student[i + 1] = 0;
				}

			} else if (i == n - 1) { // 마지막 index
				System.out.println("index 마지막");
				if (student[i] == -1 && student[i - 1] == 1) {
					student[i] = 0;
					student[i - 1] = 0;
				}
			}

			else {
				System.out.println("index 중간");
				if (student[i] == -1 && student[i + 1] == 1) {
					System.out.println("오른쪽이1");
					student[i] = 0;
					student[i + 1] = 0;
				}
				if (student[i] == -1 && student[i - 1] == 1) {
					System.out.println("왼쪽이1");
					student[i] = 0;
					student[i - 1] = 0;

				}
			}
			System.out.println("===");

		}

		for (int i = 0; i < n; i++) {
			if (student[i] >= 0) {
				answer++;
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.println(student[i]);
		}
		System.out.println("===================");
		System.out.println(answer);

		return answer;
	}
}