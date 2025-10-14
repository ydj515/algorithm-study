import java.util.*;
class Solution {
    
    // 크루스칼
    // 유니온 파인드

    public static int[] parent;
    public static ArrayList<Edge> edgeList;

    public static void union(int x, int y) {

        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }

    }

    public static int find(int x) {

        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static boolean isSameParent(int x, int y) {

        x = find(x);
        y = find(y);

        if (x == y) {
            return true;
        } else {
            return false;
        }
    }

    public int solution(int n, int[][] costs) {

        edgeList = new ArrayList<Edge>();

        for (int i = 0; i < costs.length; i++) {
            edgeList.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }

        parent = new int[100]; // 걍 엄청 큰 배열을 선언 해준다.

        for (int i = 1; i <= 99; i++) {
            parent[i] = i;
        }

        Collections.sort(edgeList);

        int sum = 0;

        for (int i = 0; i < edgeList.size(); i++) {

            Edge edge = edgeList.get(i);

            if (!isSameParent(edge.v1, edge.v2)) {
                sum += edge.cost;
                union(edge.v1, edge.v2);
            }
        }

        // System.out.println(sum);

        return sum;
    }
}

class Edge implements Comparable<Edge> {

    int v1;
    int v2;
    int cost;

    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.cost < o.cost) {
            return -1;
        } else if (this.cost == o.cost) {
            return 0;
        } else {
            return 1;
        }

    }
}