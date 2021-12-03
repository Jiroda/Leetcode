class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> result = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0; i<keyName.length; i++){
            String name = keyName[i];
            String time = keyTime[i];
            int timeInSeconds = 0;
            String[] tokens = time.split(":");
            int hour = Integer.parseInt(tokens[0]);
            int min = Integer.parseInt(tokens[1]);
            timeInSeconds = hour*60*60+min*60;
            if(!map.containsKey(name)){
                map.put(name, new ArrayList<>());
            }
            map.get(name).add(timeInSeconds);
        }

         for (String k : map.keySet()) {
            List<Integer> times = map.get(k);
            Collections.sort(times);  // sort to find the connective checkins
            for (int i = 2; i < times.size(); i++)
                if (times.get(i) - times.get(i - 2) <= 3600) {  // connective 3 within 60 mins.
                    result.add(k);
                    break;
                }
        }
        
        Collections.sort(result);
        
        return result;
    }
}