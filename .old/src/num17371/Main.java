package num17371;

import java.util.Scanner;

public class Main {

	/*
	 * ㄹㅇ 개신박 함.
	 * 개 간단하게 (2/3,1/3)이 (0,1)과 가장 가깝고 (4,-3)과 가장 멀다는 것.
	 * 이는 (0,1)과 (4,-3)을 잇는 선분 위에 존재하고 있고 점을 옮겨도 거리의 합이 달라지지 않는다. 그렇다면 답은 (0,1)이 될 수 있다는 것!
	 * 그렇다면 이를 확장해서 임의의 두 점을 잇는 선분 위에 답이 존재한다는 것.
	 * 
	 * 
	 * 1. 한 점에서 다른 모든 점까지의 거리의 최대값을 구한다.
	 * 
	 * 2. 그 최대값이 최소인 점이 거리의 합의 최소가 될 수 있다.
	 */

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int xarr[] = new int[n];
		int yarr[] = new int[n];

		for (int i = 0; i < n; i++) {
			xarr[i] = scanner.nextInt();
			yarr[i] = scanner.nextInt();
		}

		int index = -1, max_v = 100;

		for (int i = 0; i < n; i++) {
			int m = -1;
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}

				// 이해하기 쉽게 변수 변환했음
				int firstx = xarr[i];
				int firsty = yarr[i];
				int secondx = xarr[j];
				int secondy = yarr[j];
				
				int temp = (secondx - firstx) * (secondx - firstx) + (secondy - firsty) * (secondy - firsty);
				
				m = Math.max(m, temp);

			}
			if (max_v > m) {
				max_v = m;
				index = i;
			}
		}

		System.out.println(xarr[index] + " " + yarr[index]);
	}

}
