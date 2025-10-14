import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        // 이분 탐색을 위해 심사 시간 배열을 정렬합니다.
        // 정렬하지 않아도 기능상 문제는 없지만, right의 상한선을 더 타이트하게 잡는 최적화가 가능합니다.
        // 여기서는 가장 보편적인 풀이를 위해 정렬을 포함합니다.
        Arrays.sort(times);
        
        long left = 1;
        // 최악의 경우: 가장 오래 걸리는 심사관에게 모든 사람이 심사받는 경우
        // n과 times의 원소는 int 범위지만, 곱셈 결과는 long 범위를 초과할 수 있으므로 형변환에 주의해야 합니다.
        long right = (long) n * times[times.length - 1]; 
        
        long answer = right; // 정답을 최댓값으로 초기화

        while (left <= right) {
            long mid = left + (right - left) / 2; // '(left + right) / 2' 를 쓰지 않음. 숫자가 너무 크기때문에 오버플로우 방지
            long sum = 0; // mid 시간 동안 심사할 수 있는 총 사람의 수

            // 각 심사관이 mid 시간 동안 몇 명을 처리할 수 있는지 계산하여 합산
            for (int time : times) {
                sum += mid / time;
                // sum이 n을 초과하면 더 이상 계산할 필요가 없으므로 루프를 중단하여 최적화
                if (sum >= n) {
                    break;
                }
            }

            if (sum >= n) {
                // mid 시간으로 충분하거나 시간이 남는 경우
                // 더 짧은 시간을 찾아보기 위해 범위를 줄임
                answer = mid;
                right = mid - 1;
            } else {
                // mid 시간으로 부족한 경우
                // 더 긴 시간이 필요하므로 범위를 늘림
                left = mid + 1;
            }
        }
        
        return answer;
    }
}