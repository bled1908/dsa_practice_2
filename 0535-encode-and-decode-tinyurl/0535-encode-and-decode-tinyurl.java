public class Codec {

    Map<String, String> Db = new HashMap<String, String>();
    static final String codes = "0123456789ZXCVBNMLKJHGFDSAQWERTYUIOPqwertyuioplkjhgfdsazxcvbnm";

    private String makeCode() {
        char[] code = new char[6];
        for(int i = 0; i < 6; i++) code[i] = codes.charAt((int)(Math.random() * 62));
        return "http://tinyurl.com/" + String.valueOf(code);
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        for(Map.Entry<String,String> map: Db.entrySet()) {
            if(map.getValue().equals(longUrl)) return map.getKey();
        }
        String code = makeCode();
        while(Db.containsKey(code)) code = makeCode();
        Db.put(code, longUrl);
        return code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return Db.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));