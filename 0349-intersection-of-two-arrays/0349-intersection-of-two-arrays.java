// HashMap Approach
import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums1)
            map.put(x, 1);
        
        for(int x : nums2)
            if(map.getOrDefault(x, 0) == 1)
                map.put(x, 2);
        
        List<Integer> ansList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            if(entry.getValue() == 2)
                ansList.add(entry.getKey());
        
        int[] ans = new int[ansList.size()];
        for(int i = 0; i < ansList.size(); i++)
            ans[i] = ansList.get(i);
        return ans;
    }
}