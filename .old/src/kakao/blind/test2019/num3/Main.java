package kakao.blind.test2019.num3;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

	static Comparator<Integer> comp = new Comparator<Integer>() {
		int countBits(int n) {

			int ret = 0;

			while (n != 0) {
				if ((n & 1) != 0) {
					++ret;
				}

				n = n >> 1;
			}

			return ret;
		}

		@Override
		public int compare(Integer a, Integer b) {

			int x = countBits(a);
			int y = countBits(b);

			if (x > y) {
				return 1;
			} else if (x < y) {
				return -1;
			} else {
				return 0;
			}
		}
	};

	static boolean check(String[][] relation, int row, int col, int subset) {

		for (int i = 0; i < row - 1; ++i) {
			for (int j = i + 1; j < row; ++j) {

				boolean isSame = true;

				for (int k = 0; k < col; ++k) {
					if ((subset & 1 << k) == 0) {
						continue;
					}

					if (relation[i][k].equals(relation[j][k]) == false) {
						isSame = false;
						break;
					}
				}

				if (isSame) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String relation[][] = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };

		int answer = 0;
		int col = relation[0].length;
		int row = relation.length;

		List<Integer> candidates = new LinkedList<Integer>();

		for (int i = 1; i < 1 << col; ++i) {
			if (check(relation, row, col, i) == true) {
				candidates.add(i);
			}
		}

		Collections.sort(candidates, comp);

		while (candidates.size() != 0) {
			int n = candidates.remove(0);
			++answer;

			for (Iterator<Integer> it = candidates.iterator(); it.hasNext();) {
				int c = it.next();
				if ((n & c) == n) {
					it.remove();
				}
			}
		}

		System.out.println(answer);
	}

}
