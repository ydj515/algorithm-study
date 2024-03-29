import java.util.*;

class Solution {

    class Route {
        int start;
        int end;

        public Route(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getEnd() {
            return end;
        }

        public int getStart() {
            return start;
        }
    }

    public int solution(int[][] routes) {

        int answer = 0;

        List<Route> list = new ArrayList<>();

        for (int[] route : routes) {
            list.add(new Route(route[0], route[1]));
        }

        // 끝나는 시간 오름차순으로 정렬
        list.sort(Comparator.comparing(Route::getEnd));

        int cursor = -30001;

        for(Route route : list) {
            if(cursor < route.getStart()) {
                cursor=route.getEnd();
                answer++;
            }
        }
        for (int[] r : routes) {
            if (cursor < r[0]) {
                cursor = r[1];
                answer++; //카메라 설치
            }
        }
        return answer;
    }
}
