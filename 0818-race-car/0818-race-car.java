class Solution {
  public int racecar(int target) {
    int[] dp = new int[target + 1];
    return helper(dp, target);
  }
  private int helper(int[] dp, int target) {
    if (target == 0)
      return -1;
    if (dp[target] > 0)
      return dp[target];
    int near = 1, count;
    for (count = 1; near < target; count++)
      near += near + 1;
    int d1 = near - target, d2 = target - near / 2, d = 0;
    int res = helper(dp, d1) + count + 1;
    for (int back = 0; back < count - 1; back++) {
      res = Math.min(res, helper(dp, d2 + d) + back + 1 + count);
      d += d + 1;
    }
    return dp[target] = res;
  }
}