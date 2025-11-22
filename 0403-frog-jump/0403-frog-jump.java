import java.util.*;

class Solution {
    //  Each state is defined by (current_position, last_jump_length)
    //  'vis' stores states already checked (vis.containsKey(new Pair(pos, jump))) that cannot reach the end
    Map<String, Boolean> vis = new HashMap<>();

    //  Parameters:
    //  stones : positions of all stones
    //  unit   : current stone position
    //  k      : length of the last jump
    //  idx    : current index in the stones array (not part of the memoized state)
    boolean recur(int[] stones, long unit, long k, int idx) {
        if (unit == stones[stones.length - 1]) return true; //  Reached the end

        String key = unit + "," + k;
        if (vis.containsKey(key)) return false;
        //  found a state that has been computed (can not reach the end)

        //  Ensure at position 'unit', there is a stone
        //  (advance idx until stones[idx] >= unit)
        while (idx < stones.length && stones[idx] < unit) idx++;

        //  out of bounds or doesn't have stone at unit
        if (idx >= stones.length || stones[idx] > unit) return false;

        //  Try move k - 1 units if k > 1 (initial k is 1 so you can't move k - 1 at first)
        if (k > 1) {
            if (recur(stones, unit + k - 1, k - 1, idx + 1)) return true;
        }

        //  Try move k units
        if (recur(stones, unit + k, k, idx + 1)) return true;

        //  Try moving k + 1 units (skip if first jump)
        if (idx != 0) {
            if (recur(stones, unit + k + 1, k + 1, idx + 1)) return true;
        }

        //  If no way of moving works, mark it as visited (can't reach the end)
        vis.put(key, true);
        return false;
    }

    public boolean canCross(int[] stones) {
        return recur(stones, stones[0], 1, 0);
    }
}