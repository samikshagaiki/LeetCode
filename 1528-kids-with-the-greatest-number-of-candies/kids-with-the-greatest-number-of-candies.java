class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max=0;
        for(int i=0;i<candies.length;i++){
            max=Math.max(max,candies[i]);
        }
        for(int i=0;i<candies.length;i++){
            int sum = candies[i]+extraCandies;
                if(sum>=max){
                    result.add(true);
                }else{
                    result.add(false);
                }
            } 
        return result;
    }
}