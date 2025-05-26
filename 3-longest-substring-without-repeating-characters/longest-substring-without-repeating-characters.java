class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            String current = "";
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);

                if (current.indexOf(c) != -1) {
                    break;
                } else {
                    current += c;
                    maxLen = Math.max(maxLen, current.length());
                }
            }
        }

        return maxLen;
    }
}
