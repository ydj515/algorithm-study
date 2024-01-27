import java.util.*;
class Solution {
    public int solution(int[] budgets, int M) {

        long sum = 0; // 숫자 커져서 int형으로는 감당 불가능
        int answer = 0;

        // 이분탐색 자체가 sort를 하고 진행해야함
        // list, qriority queue 모두 시간초과 나서 그냥 배열을 sort하여 사용

        for (int i = 0; i < budgets.length; i++) {
            sum += budgets[i]; // 모든 필요 예산 총합.
        }

        Arrays.sort(budgets); // 오름차순 정렬

        if (sum <= M) {
            return budgets[budgets.length - 1];
        }
        int max = budgets[budgets.length - 1];
        int min = 1; // budgets[0]으로 놓고 시작 하니까 test9 실패... 그래서 모든 예산 요청은 1 이상이므로 그냥 1 이상으로 시작했음...
        int mid = 0; // 중간값(이분탐색을 위한)
        int mm = 0;

        while (true) {
            mid = (max + min) / 2;
            sum = 0;

            // System.out.println("max : " + max + ", min : " + min + ", mid : " + mid);

            for (int i = 0; i < budgets.length; i++) {
                if (budgets[i] >= mid) {
                    sum += mid;
                } else {
                    sum += budgets[i];
                }
                // System.out.println("temp sum : " + sum);
            }
            // System.out.println("sum : " + sum);
            // System.out.println("==============================");

            // 더 이상 최대값의 변화가 없다면
            // 값을 찾았으므로 종료
            if (mid == mm) {
                answer = mid;
                break;
            }

            // 범위를 좁힌다.
            if (sum > M) {
                max = mid;
            } else {
                min = mid;
            }
            mm = mid;
        }
        // System.out.println(answer);
        return answer;
    }
}