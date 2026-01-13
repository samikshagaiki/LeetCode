class Solution {
    public boolean isHappy(int n) {

        int digit;

        while (n != 1 && n != 4) {   // 4 indicates an unhappy loop
            digit = 0;

            while (n > 0) {
                int rem = n % 10;
                digit += rem * rem;   // square of each digit
                n = n / 10;
            }

            n = digit;   // update n with sum of squares
        }

        return n == 1;
    }
}
