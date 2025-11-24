class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        
        String[] words = paragraph.split("\\s+");
        
        Set<String> bannedSet = new HashSet<>();
        for (String ban : banned) {
            bannedSet.add(ban.toLowerCase());
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        String result = "";
        int max = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                result = entry.getKey();
                max = entry.getValue();
            }
        }

        return result;
    }
}