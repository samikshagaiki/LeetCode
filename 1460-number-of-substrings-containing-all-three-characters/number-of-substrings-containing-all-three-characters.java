class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int noA = -1, noB = -1, noC = -1; 

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') noA = i;
            else if (ch == 'b') noB = i;
            else if (ch == 'c') noC = i;

            count += 1 + Math.min(noA, Math.min(noB, noC));
        }

        return count;
    }
}
