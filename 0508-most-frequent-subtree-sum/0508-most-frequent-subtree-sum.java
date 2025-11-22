class Solution {
    int max = -1; // maximum frequency of any the subtree sum
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>(); // to keep track of frequency of each subtree sum
        traverse(root,map); 
        List<Integer> res = new ArrayList<>(); // result list
        for(int i:map.keySet()) if(map.get(i) == max) res.add(i); // adding the subtree sum values that have max frequency
        return res.stream().mapToInt(i->i).toArray();  // convert list to array the return 
    }
    public void traverse(TreeNode root,Map<Integer,Integer> map){
        if(root == null) return;
        traverse(root.left,map);
        traverse(root.right,map); 
        // bottom-up
        int sum=root.val; // after reaching the leaf node is is obvious that the subtree sum will be node's value itself
        if(root.left != null) sum+= root.left.val; // if not the leaf node we will calculate the subtree sum
        if(root.right != null) sum+= root.right.val;
        map.put(sum,map.getOrDefault(sum,0)+1); // tracking the frequency of the sunstree sum
        max = Math.max(max,map.get(sum)); // keeping track of the maximum frequency of any subtree sum
        root.val = sum; // as we are operating bottom-up we will update the value of the root with it's subtree sum
    }
}