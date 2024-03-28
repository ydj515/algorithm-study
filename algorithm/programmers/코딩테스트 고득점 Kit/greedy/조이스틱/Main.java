class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int move = length - 1;  // 그냥 오른쪽으로 쭉 이동한다는 값으로 초기화

        char[] letters = new char[name.length()];

        for (int i = 0; i < name.length(); i++) {
            letters[i] = name.charAt(i);
        }

        // 상하 최솟값
        for (char letter : letters) {
            answer += Math.min(letter - 'A', 'Z' - letter + 1);
        }

        for (int i = 0; i < letters.length - 1; i++) {

            // 다음 문자가 'A'인 경우 연속되는 'A'의 개수를 세어 이동 횟수를 업데이트
            int nextIndex = i + 1;
            while (nextIndex < letters.length && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }
            move = Math.min(move, i * 2 + length - nextIndex);
            move = Math.min(move, (length - nextIndex) * 2 + i); // BBBBAAAAAAAB 인경우 때문에 추가. 뒷부분부터 체크하는 경우가 더 빠른 경우
        }
        return answer + move;
    }
}