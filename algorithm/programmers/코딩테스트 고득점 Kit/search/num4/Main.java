import java.util.*;
class Solution {
    public int[] solution(int brown, int red) {

        int[] answer = new int[2];

        // 가로가 항상 길다.
        // brown + red
        // red가 1이면 brown은 3이상
        // red가 2이면 brown은 4
        // 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.

        for (int i = 1; i <= red; i++) {
            if ((red % i) == 0) {
                if (((2 * i) + (2 * red / i) + 4) == brown) {
                    answer[0] = (red / i) + 2;
                    answer[1] = i + 2;
                    break;
                }
            }
        }

        // System.out.println(answer[0]);
        // System.out.println(answer[1]);


        return answer;
    }
}