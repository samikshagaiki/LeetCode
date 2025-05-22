import java.util.*;

class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] workload = new int[n + 2];  
        int usedQueries = 0;

        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder());

        int qIndex = 0;

        for (int time = 0; time < n; time++) {
            if (time > 0) {
                workload[time] += workload[time - 1];
            }

            // Add queries that start at this time
            while (qIndex < m && queries[qIndex][0] == time) {
                available.offer(queries[qIndex][1]);
                qIndex++;
            }

            // Use queries to meet the demand at time
            while (workload[time] < nums[time]) {
                if (available.isEmpty() || available.peek() < time) {
                    return -1;  
                }

                int end = available.poll();
                usedQueries++;
                workload[time]++;
                workload[end + 1]--;  
            }
        }

        return m - usedQueries;  
    }
}
