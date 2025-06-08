public class Solution {
    int[] parent = new int[26]; // for 'a' to 'z'

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Initialize each character to be its own parent
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Union characters in s1 and s2
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        // Build result by finding smallest equivalent for each character in baseStr
        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            int smallest = find(c - 'a');
            result.append((char) (smallest + 'a'));
        }

        return result.toString();
    }

    // Find with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    // Union by choosing lexicographically smaller parent
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;

        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }
}
