class Solution {
    public int largestAltitude(int[] gain) {
        int[] temp = new int[gain.length+1];
        temp[0]=0;
        int max=0;
        for(int i=1;i<temp.length;i++){
            temp[i] = temp[i-1]+gain[i-1];
        }
        for(int i=0;i<temp.length;i++){
            max= Math.max(max,temp[i]);
        }
        return max;
        
    }
}