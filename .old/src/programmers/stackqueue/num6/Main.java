import java.util.*;
class Solution {
    public int[] solution(int[] prices) {

        // 문제 이해 난이도가 더 어려워;;
        // 주식 한개의 가격이다. 여러개가 아님.
        // 바로 뒤에거 까지 비교

        int[] answer = new int[prices.length];
        int cnt = 0;

        for (int i = 0; i < prices.length - 1; i++) {

            cnt = 0;

            for (int j = i + 1; j < prices.length; j++) {
                // System.out.println("price i : " + prices[i] + ", price j : " + prices[j]);
                if (prices[i] <= prices[j]) {
                    cnt++;
                } else {
                    cnt++;
                    break;
                }
            }
            // System.out.println("========" + "cnt : " + cnt);
            answer[i] = cnt;
        }

        // 마지막은 무조건 0 이자나.
        answer[prices.length - 1] = 0;
        
        return answer;
    }
}