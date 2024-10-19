public class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        // 시작시간과 끝시간을 초단위로 변환
        int startTime = h1 * 3600 + m1 * 60 + s1;
        int endTime = h2 * 3600 + m2 * 60 + s2;

        // 0시, 12시
        if (startTime == 0 * 3600 || startTime == 12 * 3600) {
            answer++;
        }
        
        while (startTime < endTime) {
            // 시침 12시간에 360도 -> 1시간에 30도 -> 1초에 30/3600도 (1/120도)
            // 분침 60분에 360도 -> 1초에 360/3600도 (0.1도)
            // 초침 60초에 360도 -> 1초에 6도
            double hourAngle = (startTime / 120.0) % 360;
            double minAngle = (startTime / 10.0) % 360;
            double secAngle = (startTime * 6.0) % 360;

            // 다음 위치가 360도가 아닌 0도로 계산되어 카운팅에 포함되지 않는 경우 제외
            double hourNextAngle = ((startTime + 1) / 120.0 % 360 == 0) ? 360 : (startTime + 1) / 120.0 % 360;
            double minNextAngle = ((startTime + 1) / 10.0 % 360 == 0) ? 360 : (startTime + 1) / 10.0 % 360;
            double secNextAngle = ((startTime + 1) * 6.0 % 360 == 0) ? 360 : (startTime + 1) * 6.0 % 360;

            if (secAngle < hourAngle && secNextAngle >= hourNextAngle) {
                answer++;
            }
            if (secAngle < minAngle && secNextAngle >= minNextAngle) {
                answer++;
            }
            // 시침/분침과 동시에 겹쳤을 때 중복카운팅 제외 
            if (secNextAngle == hourNextAngle && hourNextAngle == minNextAngle) {
                answer--;
            }

            startTime++;
        }

        return answer;
    }
}
