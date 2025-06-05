import java.util.*;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;

        boolean[] hasKey = new boolean[n];
        boolean[] hasBox = new boolean[n];
        boolean[] opened = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();

        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (status[box] == 1) {
                queue.offer(box);
                opened[box] = true;
            }
        }

        int totalCandies = 0;

        while (!queue.isEmpty()) {
            int box = queue.poll();
            totalCandies += candies[box];

            // Process keys in this box
            for (int key : keys[box]) {
                if (!hasKey[key]) {
                    hasKey[key] = true;
                    if (hasBox[key] && !opened[key] && status[key] == 0) {
                        queue.offer(key);
                        opened[key] = true;
                    }
                }
            }

            // Process contained boxes
            for (int contained : containedBoxes[box]) {
                if (!hasBox[contained]) {
                    hasBox[contained] = true;
                    if (status[contained] == 1 || hasKey[contained]) {
                        if (!opened[contained]) {
                            queue.offer(contained);
                            opened[contained] = true;
                        }
                    }
                }
            }

            // If a box was previously skipped because it was locked, but now we got the key, handle it
            for (int i = 0; i < n; i++) {
                if (hasBox[i] && hasKey[i] && !opened[i] && status[i] == 0) {
                    queue.offer(i);
                    opened[i] = true;
                }
            }
        }

        return totalCandies;
    }
}
