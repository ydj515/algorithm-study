import java.util.*;
class Solution {

    static int cnt;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    // 하나의 전력망에 연결된 송전탑 개수 카운트하는 함수
    public static void dfs(int x){
        visited[x] = true;
        for(int i=0; i<graph[x].size(); i++){
            int now = graph[x].get(i);
            if(visited[now]) continue;
            cnt++;
            dfs(now);
        }
    }

    public int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;
        int len = wires.length;

        // 하나씩 전선을 끊으며 2차원 그래프 생성
        for(int i=0; i<len; i++){
            graph = new ArrayList[n+1];
            // 2차원 그래프 개별 초기화
            for(int p=0; p<n+1; p++){
                graph[p] = new ArrayList<>();
            }
            int x = 0;
            for(int j=0; j<len; j++){
                // i번째 송전탑 연결 무시
                if(j == i) continue;
                // 송전탑 연결
                int a = wires[j][0];
                int b = wires[j][1];
                graph[a].add(b);
                graph[b].add(a);
                x = a;
            }
            // 해당 전력망으로 연결된 송전탑 개수 구하기
            cnt = 1;
            visited = new boolean[n+1];
            dfs(x);
            // 두 전력망의 송전탑 차의 최솟값
            answer = Math.min(answer, Math.abs(2*cnt - n));
        }
        return answer;
    }
}