class Solution {
    public int reverse(int x) {
        int sign = 1;

        if(x < 0){
            sign = -1;
            x = x * -1;
        }

        int r = 0;
        while(x!=0){
            int d = x % 10;
            if(r > Integer.MAX_VALUE / 10 || r < Integer.MIN_VALUE / 10){
                return 0;
            }
            r = r * 10 + d;
            x = x / 10;
        }

        return sign * r;
        
    }
}