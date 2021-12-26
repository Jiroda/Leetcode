//T:O(n)
//S:O(n)
class Solution {
	public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		int count = 0;
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int [] row: reservedSeats) {
			if (map.containsKey(row[0]))
				map.get(row[0]).add(row[1]);
			else
				map.put(row[0], new ArrayList<>(Arrays.asList(row[1])));
		}
		count = (n - map.size()) * 2; 
		for (List<Integer> seats: map.values()) {
			boolean filled = false;
			if (!seats.contains(2) && !seats.contains(3) && !seats.contains(4) && !seats.contains(5)) {
				filled = true;
				count += 1;
			}
			if (!seats.contains(6) && !seats.contains(7) && !seats.contains(8) && !seats.contains(9)) {
				filled = true;
				count += 1;
			}
			if (!filled) {
				if (!seats.contains(4) && !seats.contains(5) && !seats.contains(6) && !seats.contains(7)) {
					count += 1;
				}
			}
		}
		return count;
    }
}