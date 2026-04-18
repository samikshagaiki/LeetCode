class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int len = encodedText.length();
        int n = rows, m = len/n;

        int i=0, count = 0;
        StringBuilder sb = new StringBuilder();
        while (count<=m*n) {
            if (i>=len) break;
            char x = encodedText.charAt(i);
            sb.append(x);
            i+=m+1;
            count++;
            if (count%n==0) {
                i=count/n;
            }
        }
        return sb.toString().stripTrailing();
    }
}