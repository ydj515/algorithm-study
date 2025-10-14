package ict1;

import java.util.*;

public class Main {

	public int solution(int[] goods) {

		int reuslt = 0;

		Arrays.sort(goods); // 오름차순

		if (goods[0] >= 50) {
			for (int i = 0; i < 3; i++) {
				reuslt += goods[i];
			}
			reuslt -= 30;
		} else if (goods[1] >= 50) {
			for (int i = 0; i < 3; i++) {
				reuslt += goods[i];
			}
			reuslt -= 20;
		} else if (goods[2] >= 50) {
			if (goods[0] + goods[1] < 50) {
				for (int i = 0; i < 3; i++) {
					reuslt += goods[i];
				}
				reuslt -= 10;
			} else {
				for (int i = 0; i < 3; i++) {
					reuslt += goods[i];
				}
				reuslt -= 20;
			}
		} else {
			for (int i = 0; i < 3; i++) {
				reuslt += goods[i];
			}
			if (reuslt >= 50) {
				reuslt -= 10;
			}
		}

		return reuslt;
	}
}
