class Solution {
    public int[] solution(int brown, int yellow) {

        int[] answer = new int[2];

        // 가로의 길이가 같거나 길다.
        int yellowWidth;
        int yellowHeight;

        // 근의 공식 이용

        int b = -((brown - 4) / 2); // yellow width + yellow height
        int c = yellow; // yellow width * yellow height;

        // ax^2 + bx + c = 0일 때 근의 공식 적용
        // yellow의 width, height
        int x1 = (int) ((-b + Math.sqrt(b*b - (4 * 1 * c)))/2); // width
        int x2 = (int) ((-b - Math.sqrt(b*b - (4 * 1 * c)))/2); // height

        // +2를 하는 이유는 yellow를 가로 세로한칸씩 감싸고 있기에 더해줘야 최종 격자 크기가 나옴
        answer[0] = (x1 >= x2) ? x1 + 2 : x2 + 2;
        answer[1] = (x1 >= x2) ? x2 + 2 : x1 + 2;
        
        return answer;
    }
}