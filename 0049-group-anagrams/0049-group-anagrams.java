class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            char[] char_arr = s.toCharArray();
            Arrays.sort(char_arr);
            String key = String.valueOf(char_arr);
            List<String> group = map.getOrDefault(key, new ArrayList<>());
            group.add(s);
            map.put(key, group);
        }
        return new ArrayList<>(map.values());
    }
}