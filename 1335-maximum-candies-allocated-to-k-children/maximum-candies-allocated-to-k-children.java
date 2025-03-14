class Solution {
    public int maximumCandies(int[] candies, long k) {  
        if (k == 0) return 0;
        
        int left = 1;
        int right = Arrays.stream(candies).max().getAsInt();  
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canAllocate(candies, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private boolean canAllocate(int[] candies, long k, int minCandies) {
        long count = 0;  
        
        for (int candy : candies) {
            count += candy / minCandies;
            if (count >= k) return true;  
        }
        
        return count >= k;
    }

    
}
