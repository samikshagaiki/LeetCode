class Solution {
   
    public int longestNiceSubarray(int[] nums) {
        int maxLength = 0;
        int left = 0, bitMask = 0;
        
        for (int right = 0; right < nums.length; right++) {
            
            while ((bitMask & nums[right]) != 0) {
                bitMask ^= nums[left]; 
                left++;
            }
            
           
            bitMask |= nums[right];
            
           
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}