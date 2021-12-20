//T:O(NlogN * M)
//S:O(N)
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digitLogs = new ArrayList<>();
        PriorityQueue<Log> pq = new PriorityQueue<>((a, b) -> (a.content.equals(b.content) ? a.id.compareTo(b.id) : a.content.compareTo(b.content)));
        for (String s : logs) {
            int i = s.indexOf(' ');
            String id = s.substring(0, i);
            String content = s.substring(i+1);
            if (Character.isDigit(content.charAt(0)))
                digitLogs.add(s);
            else
                pq.offer(new Log(id, content, s));
        }
        int i = 0;
        String[] result = new String[logs.length];
        while (!pq.isEmpty()) {
            result[i++] = pq.poll().s;
        }
        for (int j = 0; j < digitLogs.size(); j++) {
            result[i++] = digitLogs.get(j);
        }
        return result;
        
    }
}

class Log {
    String id;
    String content;
    String s;

    public Log(String id, String content, String s) {
        this.id = id;
        this.content = content;
        this.s = s;
    }

}