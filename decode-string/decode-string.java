class Solution {
    int i =0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int times = 0;
        String tempString = "";

        while (i < s.length()) {
            char c = s.charAt(i);
            i++;

            if (c == '[') {
                tempString = decodeString(s); // recurse
                while(times>0) {
                    sb.append(tempString);
                    times--;
                }
            } else if (c == ']') { // subproblem complete
                break;
            } else if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else {
                times = times * 10 + c - '0';
            }
        }

        return sb.toString();
    }
}