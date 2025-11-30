class Solution {
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        Set<String> pointSet = new HashSet<>();
        for (int[] point : points) {
            pointSet.add(point[0] + "," + point[1]);
        }
        
        double minArea = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] p1 = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] p2 = points[j];
                for (int k = j + 1; k < n; k++) {
                    int[] p3 = points[k];
                    int dx1 = p2[0] - p1[0], dy1 = p2[1] - p1[1];
                    int dx2 = p3[0] - p1[0], dy2 = p3[1] - p1[1];
                    //dx1 and dx2 are the adjacent Sides vector equations

                    if (dx1 * dx2 + dy1 * dy2 == 0) { // finding dot product
                        int[] p4 = new int[]{p2[0] + dx2, p2[1] + dy2};
                        String p4Str = p4[0] + "," + p4[1];
                        if (pointSet.contains(p4Str)) {
                            double area = Math.sqrt(dx1 * dx1 + dy1 * dy1) * Math.sqrt(dx2 * dx2 + dy2 * dy2);
                            minArea = Math.min(minArea, area);
                        }
                    }
                }
            }
        }
        
        return minArea == Double.MAX_VALUE ? 0 : minArea;
    }
}