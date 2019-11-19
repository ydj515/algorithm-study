package ict2;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		int[] prices = { 80, 90, 80, 90, 80 };

		int rank = 1;

		Arrays.sort(prices); // 오름차순

		int result = prices[0];

		if (prices.length < 3) {
			result = -1;
		} else {
			for (int i = 0; i < prices.length; i++) {
				if (rank == 3) {
					break;
				}
				if (prices[i] > result) {
					result = prices[i];
					rank++;
				}
			}

			if (rank < 3) {
				result = -1;
			}

		}

		System.out.println(result);
	}

}
