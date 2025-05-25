class Solution {
    public boolean isPowerOfTwo(int n) {
       if (n <= 0) return false; 
        for (int x = 0; x <= 30; x++) { 
            if (n == (int)Math.pow(2, x)) {
                return true;
            }
        }
        return false;
    }
}