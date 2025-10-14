package num1049;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt(); // 끊어진 기타 줄 갯수
		int m = scanner.nextInt(); // 기타줄 브랜드 갯수
		int result = 99999;

		int pack[] = new int[m];
		int each[] = new int[m];

		for (int i = 0; i < m; i++) {
			pack[i] = scanner.nextInt();
			each[i] = scanner.nextInt();
		}

		// 오름차순
		Arrays.sort(pack);
		Arrays.sort(each);

		result = Math.min((pack[0] * (n / 6) + 1), each[0] * n); // 가장 싼 6개짜리 팩 구매(무조건 1개는 살 수 밖에 없음_5개 미만이면)vs 가장 싼 낱개 구매
		result = Math.min(result, pack[0] * ((n / 6)) + each[0] * (n % 6)); // 위에서 최솟값 vs 6개팩 + 낱개 섞어 사기

		System.out.println(result);

		scanner.close();
	}

}
