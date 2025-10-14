class Solution {

	public boolean solution(int[][] key, int[][] lock) {

		// 회전 안하고 왼쪽에서부터 쭉 스캔 후 아래로 한칸씩 내리면서 쭉 스캔
		// 회전 한번씩 하면서 루틴반복

		int answerCount = 0; // lock 빵구 갯수

		// lock의 빵꾸 뚤린곳 갯수 세기
		for (int i = 0; i < lock.length; i++) {
			for (int j = 0; j < lock.length; j++) {
				if (lock[i][j] == 0) {
					answerCount++;
				}
			}
		}

		for (int r = 0; r < 4; r++) { // 회전 회오리. 90도씩
			for (int i = -20; i <= 20; i++) { // 좌우 사이즈가 -20 ~ +20
				for (int j = -20; j <= 20; j++) { // 상하 사이즈가 -20 ~ +20

					int cnt = 0;
					boolean successFlag = true;

					for (int y = 0; y < key.length; y++) {
						for (int x = 0; x < key.length; x++) {

							int nx = i + x;
							int ny = j + y;

							// 자물쇠 범위에 있어야 검사할 맛이 나지;;
							// 그 이상 그 이하면 검사할 가치가 없음
							if (nx >= 0 && nx < lock.length && ny >= 0 && ny < lock.length) {
								// 아다리가 딱 안맞으면 fail한다.
								// 자물쇠 튀 나온 부분이랑 열쇠의 부분이랑 겹치면 안됨
								if (lock[nx][ny] == 1 && key[x][y] == 1) {
									successFlag = false;
								} else if (lock[nx][ny] == 0 && key[x][y] == 1) { // 자물쇠에 딱 키가 맞을 경우 cnt++;
									cnt++;
								}
							}
						}
					}

					if (cnt == answerCount && successFlag) {
						return true;
					}

				}
			}

			key = rotate(key);
		}
		return false;

	}

	// 90도 회전
	private int[][] rotate(int[][] key) {
		int[][] tmp = new int[key.length][key.length];
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				tmp[j][key.length - i - 1] = key[i][j];
			}
		}

		return tmp;
	}
}