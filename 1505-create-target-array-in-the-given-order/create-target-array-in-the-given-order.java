class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int j = index[i];
            ans.add(j,nums[i]);
        }

        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);  
        }

        return arr;
    }
}