class Solution {
    public long repairCars(int[] ranks, int cars) {
        
        Arrays.sort(ranks); 
        
        long low = 1, high = (long) ranks[0] * (long) cars * (long) cars; 
        long answer = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canRepairAllCars(ranks, cars, mid)) {
                answer = mid;
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }
        return answer;
    }

    private boolean canRepairAllCars(int[] ranks, int cars, long time) {
        long total = 0;

        for (int rank : ranks) {
            long carsRepaired = (long) Math.sqrt(time / rank); 
            total += carsRepaired;

            if (total >= cars) return true; 
        }
        return total >= cars;
    }
}
