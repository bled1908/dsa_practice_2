class LockingTree {
    private int[] parent;
    private int[] lockedBy;
    private List<List<Integer>> children;

    public LockingTree(int[] parent) {
        this.parent = parent;
        int n = parent.length;
        this.lockedBy = new int[n];
        Arrays.fill(lockedBy, -1);

        this.children = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            this.children.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++) {
            children.get(parent[i]).add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if(lockedBy[num] != -1) return false;
        lockedBy[num] = user;
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(lockedBy[num] != user) return false;
        lockedBy[num] = -1;
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        if(lockedBy[num] != -1) return false;

        int curr = parent[num];
        while(curr != -1) {
            if(lockedBy[curr] != -1) return false;
            curr = parent[curr];
        }

        if(checkAndUnlockDescendants(num)) {
            lockedBy[num] = user;
            return true;
        }

        return false;
    }

    private boolean checkAndUnlockDescendants(int num) {
        boolean foundLocked = false;

        for(int child: children.get(num)) {
            if(lockedBy[child] != -1) {
                foundLocked = true;
                lockedBy[child] = -1;
            }
            if(checkAndUnlockDescendants(child)) {
                foundLocked = true;
            }
        }
        return foundLocked;

    }

}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */