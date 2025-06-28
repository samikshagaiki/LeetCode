class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int temp=0;
        for(int i=0;i<n;i++){
            ans[temp++] = nums[i];
            ans[temp++] = nums[i+n];
            
        }
        return ans;
    }
}