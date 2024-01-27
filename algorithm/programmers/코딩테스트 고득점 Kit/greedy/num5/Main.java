import java.util.*;
class Solution {

    class Route implements Comparable<Route> {

        int start;
        int end;

        public Route(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Route o) {

            int standard = start - o.start; // 시작하 시간 순으로 정렬

            if (standard == 0) { // 끝나는 시간이 같다면 끝나는 시간순으로 정렬
                standard = start - o.start;
            }

            return standard;
        }
    }

    public int solution(int[][] routes) {

        int answer = 1; // 무조건 1대는 설치 되자나

        List<Route> list = new ArrayList<>();

        for (int i = 0; i < routes.length; i++) {
            list.add(new Route(routes[i][0], routes[i][1]));
        }

        // 정렬해서 사용
        Collections.sort(list);

        // for (int i = 0; i < list.size(); i++) {
        //     System.out.println(list.get(i).start + ", " + list.get(i).end);
        // }

        int cur = list.get(0).end;

        for (int i = 1; i < routes.length; i++) {

            if (list.get(i).end < cur) {
                cur = list.get(i).end;
            }

            if (list.get(i).start > cur) {
                answer++;
                cur = list.get(i).end;
            }
        }

        // System.out.println(answer);

        return answer;
    }
}