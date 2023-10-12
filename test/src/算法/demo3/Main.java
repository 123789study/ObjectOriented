package 算法.demo3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 迷宫的行数
        int m = scanner.nextInt(); // 迷宫的列数
        
        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上下左右四个方向
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // 添加起点到队列中
        
        int[][] distance = new int[n][m]; // 记录起点到每个位置的最短距离
        distance[0][0] = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && maze[newX][newY] == 0 && distance[newX][newY] == 0) {
                    distance[newX][newY] = distance[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        
        int minDistance = distance[n-1][m-1]; // 终点的最短距离
        System.out.println(minDistance);
    }
}
