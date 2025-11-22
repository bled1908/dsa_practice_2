class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public List<Integer> vals = new ArrayList<>();
}

class WordFilter {
    private TrieNode pTrie = new TrieNode();
    private TrieNode sTrie = new TrieNode();
    
    public WordFilter(String[] words) {
        Set<String> wordSet = new HashSet<>();
        for (int index = words.length - 1; index > -1; index--) {
            if (wordSet.contains(words[index]))
                continue;
            wordSet.add(words[index]);
            char[] word = words[index].toCharArray();
            int wlen = word.length;
            insert(word, index, pTrie, 0, wlen, 1);
            insert(word, index, sTrie, wlen-1, -1, -1);
        }
    }
            
    private void insert(char[] word, int index, TrieNode trie, int start, int end, int step) {
        for (int i = start; i != end; i += step) {
            int c = word[i] - 'a';
            if (trie.children[c] == null)
                trie.children[c] = new TrieNode();
            trie = trie.children[c];
            trie.vals.add(index);
        }
    }
    
    private List<Integer> retrieve(char[] word, TrieNode trie, int start, int end, int step) {
        for (int i = start; i != end; i += step) {
            trie = trie.children[word[i]-'a'];
            if (trie == null) return new ArrayList<>();
        }
        return trie.vals;
    }
    
    public int f(String pre, String suf) {
        List<Integer> pVals = retrieve(pre.toCharArray(), pTrie, 0, pre.length(), 1);
        List<Integer> sVals = retrieve(suf.toCharArray(), sTrie, suf.length()-1, -1, -1);
        int svix = 0, pvix = 0;
        while (svix < sVals.size() && pvix < pVals.size()) {
            int sVal = sVals.get(svix), pVal = pVals.get(pvix);
            if (sVal == pVal) return sVal;
            if (sVal > pVal) svix++;
            else pvix++;
        }
        return -1;
    }
}