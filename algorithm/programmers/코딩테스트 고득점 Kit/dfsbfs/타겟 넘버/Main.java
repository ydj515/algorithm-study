import java.util.*;
class Solution {

    public static int answer = 0;

    public int solution(int[] numbers, int target) {
        // 모든 경우의 수 찾는것 => DFS
        dfs(target, numbers, 0);

        return answer;
    }

    // recursive 이용
    public static void dfs(int target, int[] numbers, int k) {

        if (k == numbers.length) {
            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }

            if (sum == target) {
                answer++;
            }

        } else {
            numbers[k] *= 1;
            dfs(target, numbers, k + 1); // + 노드

            numbers[k] *= -1;
            dfs(target, numbers, k + 1); // - 노드
        }
    }
}