public class Codec {
    private static final String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    HashMap<String, String> urlToCodeMap = new HashMap<>();
    HashMap<String, String> codeToUrlMap = new HashMap<>();
    Random rand = new Random();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while(!urlToCodeMap.containsKey(longUrl)){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<6; i++){
                char nextChar = alphabets.charAt(rand.nextInt(alphabets.length()));
                sb.append(nextChar);
            }
            String code = sb.toString();
            if(!codeToUrlMap.containsKey(code)){
                codeToUrlMap.put(code, longUrl);
                urlToCodeMap.put(longUrl, code);
                return "http://tinyurl.com/" + code;
            }
        }
        
        throw new IllegalArgumentException();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return codeToUrlMap.get(shortUrl.substring(19));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));