class Solution {
    
          private static final String END = "$";

    public int findMinStep(String board, String hand) {
        // count frequency of hand letter occurrence
        final Map<Character, Integer> map = new HashMap<>();
        for (char c : hand.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // basic data structure for bfs
        final Set<String> visited = new HashSet<>();
        final Queue<String[]> queue = new LinkedList<>();
        queue.offer(new String[]{board + END, hand});
        int level = 0;
        // breadth first search start
        while (!queue.isEmpty()) {
            // iterate by level
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final String[] currentPair = queue.poll();
                final String nowBoard = removeSame(currentPair[0]);
                // end condition
                if (nowBoard.equals(END)) {
                    return level;
                }
                final String nowHand = currentPair[1];
                // algo, for each position, for each hand, make new board and new hand,
                // if not visited new board, add it into visited and queue.
                for (int i = 0; i < nowBoard.length(); i++) {
                    for (char h : nowHand.toCharArray()) {
                        // if we has only one letter, then it should equal to its neighbor
                        if (1 == map.getOrDefault(h, 0) && i > 1 && i < nowBoard.length() - 1
                            && nowBoard.charAt(i) != h && h != nowBoard.charAt(i + 1)) {
                            continue;
                        }
                        final String newString =
                            nowBoard.substring(0, i) + h + nowBoard.substring(i);
                        if (!visited.contains(newString)) {
                            final String newHand = removeCharFromHand(nowHand, h);
                            visited.add(newString);
                            queue.offer(new String[]{newString, newHand});
                        }
                    }
                }
            }
            ++level;
        }
        return -1;
    }

    private String removeCharFromHand(String hand, char c) {
        final StringBuilder handBuild = new StringBuilder(hand);
        for (int i = 0; i < handBuild.length(); i++) {
            if (handBuild.charAt(i) == c) {
                handBuild.deleteCharAt(i);
                break;
            }
        }
        return handBuild.toString();
    }

    private String removeSame(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(start)) {
                continue;
            }
            if (i - start >= 3) {
                return removeSame(s.substring(0, start) + s.substring(i));
            } else {
                start = i;
            }
        }
        return s;
    }
}