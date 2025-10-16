import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 1. 사람들의 몸무게를 오름차순으로 정렬
        Arrays.sort(people);
        
        // 2. 투 포인터 초기화
        int left = 0; // 가장 가벼운 사람의 인덱스
        int right = people.length - 1; // 가장 무거운 사람의 인덱스
        
        while (left <= right) {
            // 3. 가장 무거운 사람과 가장 가벼운 사람의 무게를 합쳐서 limit과 비교
            if (people[left] + people[right] <= limit) {
                // 함께 탈 수 있는 경우, 두 사람 모두 구출 처리
                left++;
                right--;
            } else {
                // 함께 탈 수 없는 경우, 가장 무거운 사람만 구출 처리
                right--;
            }
            // 어떤 경우든 보트는 한 대 사용됨 => 여기가 포인트. 어쨋든 한대가 출발했다.
            answer++;
        }
        
        return answer;
    }
}