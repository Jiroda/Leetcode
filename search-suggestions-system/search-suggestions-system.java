//T:O(K*NlogN) k->length of the search word N-> number of suggested products
//S:O(N)
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        PriorityQueue<String> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        //Find each substring of the search word and check if we have any words that start with this prefix
        for (int i = 1; i <= searchWord.length(); i++) {
            String t = searchWord.substring(0, i);
            for (String product: products) {
                if (product.startsWith(t)) {
                    maxHeap.offer(product);
                }
                if (maxHeap.size() > 3) {
                    maxHeap.poll();
                }
            }
            
            LinkedList<String> temp = new LinkedList<>();
            while (!maxHeap.isEmpty()) {
                temp.addFirst(maxHeap.poll());
            }
            result.add(temp);
        }
        return result;
    }
}