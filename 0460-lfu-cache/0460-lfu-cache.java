class LFUCache {

    HashMap<Integer, Integer> keyToValue;
    HashMap<Integer, Integer> keyToFreq;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKey;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        keyToValue = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKey = new HashMap<>();
        this.capacity = capacity;
        minFreq = 0;
    }
    
    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }

        int curr = keyToValue.get(key);
        int freq = keyToFreq.get(key);
        freqToKey.get(freq).remove(key);

        if (freqToKey.get(freq).isEmpty()) {
            freqToKey.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }

        freqToKey.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKey.get(freq + 1).add(key);
        keyToFreq.put(key, freq + 1);

        return curr;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            get(key);
            return;
        }

        if (keyToValue.size() == capacity) {
            LinkedHashSet<Integer> st = freqToKey.get(minFreq);
            int oldKey = st.iterator().next();
            st.remove(oldKey);
            if (st.isEmpty()) {
                freqToKey.remove(minFreq);
            }
            keyToFreq.remove(oldKey);
            keyToValue.remove(oldKey);
        }

        keyToValue.put(key, value);
        keyToFreq.put(key, 1);
        minFreq = 1;
        freqToKey.putIfAbsent(1, new LinkedHashSet<>());
        freqToKey.get(1).add(key);
    }
}