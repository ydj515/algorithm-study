import java.util.Arrays;

// 이분탐색을사용하여 찾기도 가능.
class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int answer = 0;

        // h의 가능한 범위를 0부터 n까지로 설정
        int left = 0;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2; // h의 후보

            // mid번 이상 인용된 논문이 몇 편인지 계산
            int count = 0;
            for (int citation : citations) {
                if (citation >= mid) {
                    count++;
                }
            }

            // H-Index 정의에 따라 조건을 확인
            if (count >= mid) {
                // 조건을 만족 -> h가 더 커질 수 있는지 확인하기 위해 범위를 오른쪽으로
                answer = mid; // 현재 mid는 유효한 h이므로 정답 후보로 저장
                left = mid + 1;
            } else {
                // 조건을 만족하지 못함 -> h가 더 작아져야 함
                right = mid - 1;
            }
        }

        return answer;
    }
}