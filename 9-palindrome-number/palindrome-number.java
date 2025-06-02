import java.util.Scanner;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false; 
        }
        
        int original = x;
        int reverse = 0;
        
        while (x != 0) {
            int digit = x % 10;
            x = x / 10;
            reverse = (reverse * 10) + digit;
        }
        
        return original == reverse;
    }

    
}
