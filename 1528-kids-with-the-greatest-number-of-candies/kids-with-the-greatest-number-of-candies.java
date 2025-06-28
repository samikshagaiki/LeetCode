class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max=0;
        for(int m:candies){
            if(max<m){
                max=m;
            }
        }
        for(int i:candies){
                if(i+extraCandies>=max){
                    result.add(true);
                }else{
                    result.add(false);
                }
            } 
        return result;
    }
}