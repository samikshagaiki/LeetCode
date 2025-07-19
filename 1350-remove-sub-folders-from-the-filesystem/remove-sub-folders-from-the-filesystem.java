import java.util.*;
public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);  // Sort the folders lexicographically
        List<String> result = new ArrayList<>();
        String prev = "";

        for (String f : folder) {
            // Only add if it's not a subfolder of the previous folder in result
            if (prev.isEmpty() || !f.startsWith(prev + "/")) {
                result.add(f);
                prev = f;
            }
        }

        return result;
    }
}