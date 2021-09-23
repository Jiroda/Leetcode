//T:O(n)
//S:O(1) or O(26)

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isInSortedOrder(words[i], words[i + 1], map)) return false;
        }
        return true;
    }
    
    private boolean isInSortedOrder(String s1, String s2, Map<Character, Integer> map) {
        int l1 = s1.length(), l2 = s2.length();
        for (int i = 0; i<Math.min(l1,l2); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (map.get(s1.charAt(i)) > map.get(s2.charAt(i))) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        if (l1 > l2) return false;
        return true;
    }
}