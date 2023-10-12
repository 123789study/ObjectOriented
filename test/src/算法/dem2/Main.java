
package 算法.dem2;

import java.util.*;

public class Main {
    public static final double INF = Double.POSITIVE_INFINITY;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 点的数量
        int m = scanner.nextInt(); // 边的数量
        
        double[][] graph = new double[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        
        int start = scanner.nextInt(); // 起点
        int end = scanner.nextInt(); // 终点
        
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            double weight = scanner.nextDouble();
            
            graph[u][v] = weight;
        }
        
        // 使用Floyd-Warshall算法计算任意两点间的最短路径
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        
        double shortestPath = graph[start][end]; // 第三行两个点之间的最短路径长度
        System.out.println(String.format("%.2f",shortestPath));
    }
}
