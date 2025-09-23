class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length() || t.isEmpty()) return "";
        int left = 0, right = 0;
        Map<Character, Integer> t_count = new HashMap<>();
        for(char c: t.toCharArray()) {
            t_count.put(c, t_count.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> window_count = new HashMap<>();
        int matched = 0;
        int min_start = 0, min_length = Integer.MAX_VALUE;
        while(right < s.length()) {
            char r_elem = s.charAt(right);
            window_count.put(r_elem, window_count.getOrDefault(r_elem, 0) + 1);
            if(t_count.containsKey(r_elem) && t_count.get(r_elem).equals(window_count.get(r_elem))) matched++;
            while(matched == t_count.size()) {
                if(right - left + 1 < min_length) {
                    min_length = right - left + 1;
                    min_start = left;
                }
                char l_elem = s.charAt(left);
                window_count.put(l_elem, window_count.get(l_elem) - 1);
                if(t_count.containsKey(l_elem) && t_count.get(l_elem) > window_count.get(l_elem)) matched--;
                left++;
            }
            right++;
        }
        if(min_length == Integer.MAX_VALUE) return "";
        return s.substring(min_start, min_start + min_length);
    }
}