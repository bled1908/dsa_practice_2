# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rob(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        dp = {}

        def dfs(node):

            if not node:
                return 0
            if node in dp:
                return dp[node]
            dontRob = dfs(node.left) + dfs(node.right)
            rob_root = node.val
            if node.left:
                rob_root +=  dfs(node.left.right) + dfs(node.left.left)
            if node.right:
                rob_root += dfs(node.right.right) + dfs(node.right.left)
            
            dp[node] = max(dontRob, rob_root)
            return dp[node]
        return dfs(root)
        
        