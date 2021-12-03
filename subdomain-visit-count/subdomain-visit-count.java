class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        if(cpdomains==null || cpdomains.length==0){
            return new ArrayList<String>();
        }
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String cpDomain: cpdomains){
            String[] tokens = cpDomain.split(" ");
            int count = Integer.parseInt(tokens[0]);
            String domain = tokens[1];
            
            String[] parts = domain.split("\\.");
            int n = parts.length;
            String prev = parts[n-1];
            if(map.containsKey(prev)){
               map.put(prev, map.get(prev)+count); 
            }else{
               map.putIfAbsent(prev, count);
            }
            for(int i=n-2; i>=0; i--){
                String part = parts[i]+"."+prev;
                if(map.containsKey(part)){
                    map.put(part, map.get(part)+count);
                }else{
                    map.put(part, count);
                }
                prev = part;
            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            res.add(entry.getValue()+" "+entry.getKey());
        }

        return res;
    }
}