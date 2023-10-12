package 算法.demo1;

import java.util.*;

public class Main {
    public static int constructHuffmanTreeCost(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }

        int cost = 0;
        while(pq.size() > 1) {
            int pa = pq.poll();
            int pb = pq.poll();

            int sum = pa + pb;
            cost += sum;

            pq.offer(sum);
        }

        return cost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int cost = constructHuffmanTreeCost(nums);
        System.out.println(cost);
    }
}
