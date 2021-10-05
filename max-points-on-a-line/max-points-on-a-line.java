class Solution {
    public int maxPoints(int[][] points) {
        List<Point> p = new ArrayList<>();
        for (int[] point : points) {
            p.add(new Point(point[0], point[1]));
        }
        
        Map<Double, Integer> slopes;
        int max = 1; // the array will have at least one point, so min is one
        
        for (int i = 0; i < p.size(); i++) {
            slopes = new HashMap<>();
            for (int j = i+1; j < p.size(); j++) {
                Double slope = p.get(i).slope(p.get(j));
                if (!slopes.containsKey(slope)){
                    slopes.put(slope, 1);
                }
                // set to one as we want to consider this point as well
                //Inorder for us to enter a new slope into the map we need to default it to 1
                int numberofPoints = slopes.get(slope);
                max = Math.max(max, numberofPoints+1);
                slopes.put(slope, numberofPoints+1);
            }
        }
        
        return max;
    }
    
    class Point {
        double x, y;
        Point(int x, int y) {
            this.x  = x;
            this.y  = y;
        }
        
        double slope(Point p) {
            if (p.y - y == 0) return 0; // edge case
            if (p.x - x == 0) return Double.POSITIVE_INFINITY; // edge case
            return (p.y - y)/(p.x - x);
        }
    }
}