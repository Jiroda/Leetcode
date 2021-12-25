//T:O(nlogn)
//S:O(n)
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((pairA,pairB)->pairB.count-pairA.count);
        StringBuilder sb = new StringBuilder();
        if(a>0){
            pq.offer(new Pair('a', a));
        }
        if(b>0){
            pq.offer(new Pair('b', b));
        }
        if(c>0){
            pq.offer(new Pair('c', c));
        }
        
        while(pq.size()>=2){
            Pair firstMostFreqPair = pq.poll();
            if(firstMostFreqPair.count>=2){
                sb.append(firstMostFreqPair.alphabet);
                sb.append(firstMostFreqPair.alphabet);
                firstMostFreqPair.count-=2;
            }else{
                sb.append(firstMostFreqPair.alphabet);
                firstMostFreqPair.count-=1;
            }
            
            Pair secondMostFreqPair = pq.poll();
            if(secondMostFreqPair.count>=2 && firstMostFreqPair.count < secondMostFreqPair.count){
                sb.append(secondMostFreqPair.alphabet);
                sb.append(secondMostFreqPair.alphabet);
                secondMostFreqPair.count-=2;
            }else{
                sb.append(secondMostFreqPair.alphabet);
                secondMostFreqPair.count-=1;
            }
            
            if(firstMostFreqPair.count>0){
                pq.offer(firstMostFreqPair);
            }
            
            if(secondMostFreqPair.count>0){
                pq.offer(secondMostFreqPair);
            }
        }
        
        //fill the last remaining character but not more than 2 times
        if(!pq.isEmpty()){
            if(pq.peek().count>=2){
                sb.append(pq.peek().alphabet);
                sb.append(pq.peek().alphabet);
            }else{
                sb.append(pq.peek().alphabet);
            }
        }
        
        return sb.toString();
    }
}

class Pair{
    char alphabet;
    int count;
    public Pair(char alphabet, int count){
        this.alphabet = alphabet;
        this.count = count;
    }
}