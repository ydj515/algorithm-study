package kakao.blind.test2019.num4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int foodTime[] = { 3, 1, 2 };
		int k = 4;

		int cnt = foodTime.length;

		for (int i = 0; i < foodTime.length; i++) {
			System.out.println(foodTime[i]);
		}

		for (int j = 0; j < k; j++) {

			if (foodTime[j % 3] != 0) {
				foodTime[j % 3]--;
				// System.out.println("j: " + j + "초... fotTime : " + foodTime[j%3]);
			} else { // 먹어야할 음식이 0이라면 다음껄 먹어라
				foodTime[(j + 1) % 3]--;
				// System.out.println("else j: " + j + "... fotTime : "+ foodTime[(j+1)%3]);
			}

		}

		System.out.println((k + 1) % foodTime.length + 1);

	}

}
