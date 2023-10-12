package 算法.demo22;

import java.util.*;

class Edge implements Comparable<Edge> {
    int u, v, w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge other) {
        return this.w - other.w;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}

public class Main {

    public static int getMinimumSpanningTreeCost(int n, List<Edge> edges) {
        Collections.sort(edges);
        UnionFind uf = new UnionFind(n);
        int mstCost = 0;
        int mstEdges = 0;

        for (Edge edge : edges) {
            if (mstEdges == n - 1) {
                break;
            }

            int u = edge.u;
            int v = edge.v;
            int w = edge.w;

            if (uf.find(u) != uf.find(v)) {
                uf.union(u, v);
                mstCost += w;
                mstEdges++;
            }
        }

        if (mstEdges < n - 1) {
            return -1; // 无法生成最小生成树，返回-1
        }

        return mstCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            edges.add(new Edge(u, v, w));
        }

        int mstCost = getMinimumSpanningTreeCost(n, edges);
        if (mstCost == -1) {
            System.out.println("Imp");
        } else {
            System.out.println(mstCost);
        }
    }
}


