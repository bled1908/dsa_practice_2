class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer, Integer> map = new HashMap<>();

        //counting frequency
        for(int i: nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }
            map.computeIfAbsent(i, key->0);
        }

        //this replaces the entire loop above, much more straightforward:
        // map.put(i, map.getOrDefault(i, 0) + 1);

    
        //Converts map to list and then sort by value (frequency) in descending order
        List<Map.Entry<Integer, Integer>> list = new ArrayList<> (map.entrySet());
        list.sort((a,b)->b.getValue()-a.getValue());


        //Take top k elements of the list
        int res[] = new int[k];
        for(int i=0;i<k;i++){
            res[i] = list.get(i).getKey();
        }

        return res;
    }
}