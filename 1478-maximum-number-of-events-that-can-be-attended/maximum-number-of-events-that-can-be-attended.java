import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        // Step 1: Sort events by start day
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int day = 0, i = 0, n = events.length, attended = 0;

        while (i < n || !minHeap.isEmpty()) {
            // Step 2: Move to the next available day
            if (minHeap.isEmpty()) {
                day = events[i][0];
            }

            // Step 3: Add all events starting today
            while (i < n && events[i][0] <= day) {
                minHeap.offer(events[i][1]); // add event's end day
                i++;
            }

            // Step 4: Attend event with earliest end day
            if (!minHeap.isEmpty()) {
                minHeap.poll();  // attend event today
                attended++;
                day++;           // move to next day
            }

            // Step 5: Remove expired events
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }
        }

        return attended;
    }
}
