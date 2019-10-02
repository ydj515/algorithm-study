package num15896;

import java.util.*;

public class Main {

	// 첫번째 답은
	// 입력
	// 3
	// 4 5 12
	// 2 10 6
	// 일 때 모든 수를 2진수로 변환한 후
	// 0100 0101 1100
	// 0010 1010 0110

	// 아래의 값의 연산을 모두 더한 결과값이다.
	// 0100 & 0010
	// 0100 & 1010
	// 0100 & 0110
	// 0101 & 0010
	// 0101 & 1010
	// 0101 & 0110
	// 1100 & 0010
	// 1100 & 1010
	// 1100 & 0110

	// 두번째 답은
	// 먼 개소리인지 질문을 이해하질 못하겟누;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int a[] = new int[n];
		int b[] = new int[n];

		Vector<String> av = new Vector<String>();
		Vector<String> bv = new Vector<String>();

		Vector<Integer> resultTempVector = new Vector<Integer>();
		Vector<Integer> resultVector = new Vector<Integer>();

		// 첫번째 줄 입력
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
			String as = Integer.toBinaryString(a[i]); // 2진수로 변환
			int cnt = as.length();

			for (int j = 0; j < 4 - cnt; j++) { // 4자리 2진수로 바꿈
				as = "0" + as;
			}
			av.add(as);
		}

		// 두번째 줄 입력
		for (int i = 0; i < n; i++) {
			b[i] = scanner.nextInt();
			String bs = Integer.toBinaryString(b[i]); // 2진수로 변환
			int cnt = bs.length();

			for (int j = 0; j < 4 - cnt; j++) { // 4자리 2진수로 바꿈
				bs = "0" + bs;
			}
			bv.add(bs);
		}

		// av, bv는 string 형태로 이진수 저장되어있음
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				String t1 = av.get(i);
				String t2 = bv.get(j);

				for (int k = 0; k < 4; k++) {
					// String "1000"에서 첫자리부터 한글자씩 따서 int로 변환해줌
					int c1 = t1.charAt(k) - '0';
					int c2 = t2.charAt(k) - '0';

					// 첫 자리 부터 비교해서 이진수 & 연산 진행
					if ((c1 == 1) & (c2 == 1)) {
						resultTempVector.add(1);
					} else {
						resultTempVector.add(0);
					}
				}

				int sum = 0;
				int m = 0;

				// 각 자리수 별로 2의 몇승 이런거 곱함
				for (int l = 3; l >= 0; l--) {
					sum = sum + resultTempVector.get(m) * (int) Math.pow(2, l);
					m++;
				}

				resultVector.add(sum); // 결과 vector에 sum을 더함

				// 변수 초기화
				sum = 0;
				m = 0;
				resultTempVector.clear();
			}
		}

		// 첫번째 답 도출
		int resultASum = 0;
		for (int i = 0; i < resultVector.size(); i++) {
			System.out.println(resultVector.get(i));
			resultASum += resultVector.get(i);
		}
		resultASum %= 1999;

		System.out.println("result : " + resultASum);

		scanner.close();
	}

}
