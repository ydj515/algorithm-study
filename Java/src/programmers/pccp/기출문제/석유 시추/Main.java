import java.util.*;

class Solution {
    static int n, m; // 가로, 세로 길이
    static int[] oil;     // 시추관 위치별 석유량 
    static boolean[][] visited;
    
    public int solution(int[][] land) {
        int answer = 0;

        n = land.length;
        m = land[0].length;
        oil = new int[m];

        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && visited[i][j] == false) {
                    // 석유는 있지만 방문하지 않은 곳은 방문
                    bfs(land, visited, i, j);
                }
            }
        }

        answer = Arrays.stream(oil).max().getAsInt();
        System.out.println(answer);
        return answer;
    }

    public void bfs(int[][] land, boolean[][] visited, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true; // 방문처리

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 석유 덩어리 개수
        int count = 1;
        // 석유 덩어리의 열 위치 저장
        Set<Integer> set = new HashSet<>();

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            set.add(temp[1]);

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                // 땅 범위를 넘는 경우 생략
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (land[nx][ny] == 1 && visited[nx][ny] == false) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count += 1;
                }
            }
        }

        for (int index : set) {
            oil[index] += count;
        }
    }
}