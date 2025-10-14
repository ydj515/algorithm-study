package kakao.blind.test2019.num2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();// stage 갯수

		int stage[] = { 2, 1, 2, 6, 2, 4, 3, 3 }; // 각 user들이 도달해 있는 단계
		int userNum = stage.length; // user 수

		Vector<Double> failure = new Vector<Double>();
		ArrayList<Double> temp = new ArrayList<Double>(); // failure의 sort된 형태
		ArrayList<Integer> result = new ArrayList<Integer>(); // 결과 배열. failure의 index가 들어옴

		int cnt[] = new int[n]; // 각 스테이지에 머물고 있는 사람

		for (int i = 0; i < stage.length; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (stage[i] == j) {
					cnt[j - 1]++;
				}
			}
		}

		// for(int i=0;i<n;i++) {
		// System.out.println(cnt[i]);
		// }

		// System.out.println("==========");

		for (int i = 0; i < n; i++) {
			failure.add((double) cnt[i] / userNum);
			userNum -= cnt[i];
			// System.out.println(failure.get(i));
			temp.add(failure.get(i));
		}

		temp.sort(Comparator.reverseOrder());
		// System.out.println("" + temp.toString());

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (failure.get(j) == temp.get(i)) {
					result.add(j + 1);
					break;
				}
			}

		}

		System.out.println("" + result.toString());

	}

}
