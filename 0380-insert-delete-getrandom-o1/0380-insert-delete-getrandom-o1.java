class RandomizedSet {

    // List to store the elements
    List<Integer> list;
    // Map to store value -> index mapping
    HashMap<Integer, Integer> map;
    // Random object to get random indices
    Random random = new Random();

    // Constructor
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    // Insert a value, return true if inserted, false if already present
    public boolean insert(int val) {
        if (map.containsKey(val)) return false; // Already present
        map.put(val, list.size()); // Record index of new value
        list.add(val);             // Add value at the end of list
        return true;
    }

    // Remove a value, return true if removed, false if not present
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false; // Not present, cannot remove

        int pos = map.get(val);                  // Get index of value to remove
        int lastElement = list.get(list.size() - 1); // Get last element in list

        // If val is not last element, swap it with last element
        if (pos != list.size() - 1) {
            list.set(pos, lastElement);         // Move last element to val's position
            map.put(lastElement, pos);          // Update index of last element in map
        }

        map.remove(val);                        // Remove val from map
        list.remove(list.size() - 1);           // Remove last element from list
        return true;
    }

    // Return a random element from the set
    public int getRandom() {
        int r = random.nextInt(list.size());    // Pick random index
        return list.get(r);                     // Return element at that index
    }
}