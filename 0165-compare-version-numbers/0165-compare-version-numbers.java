class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");
        int n1 = v1.length, n2 = v2.length;
        // for(String num: v2) System.out.print(num + " ");
        // System.out.println();
        // for(String num: v1) System.out.print(num + " ");
        int hash1[] = new int[n1];
        int hash2[] = new int[n2];
        for(int i=0;i<n1;i++) hash1[i] = Integer.parseInt(v1[i]);
        for(int i=0;i<n2;i++) hash2[i] = Integer.parseInt(v2[i]);

        
        int i=0, j=0;
        while(i<n1 && j < n2){
            if(hash1[i] != hash2[j]){
                if(hash1[i] > hash2[j]) return 1;
                else return -1;
            }
            i++;
            j++;
        }

        while(i<n1){
            if(hash1[i] != 0) return 1;
            i++;
        }

        while(j<n2){
            if(hash2[j] != 0) return -1;
            j++;
        }

        return 0;
    }
}