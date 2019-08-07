// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 535.
// Date: 2019.8.8

public class Codec {

    Map<String, String> memo = new HashMap<>();
    String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random rnd = new Random();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int nextPos = memo.size() + 1;
        String key;
        while (true){
            key = "";
            for (int i = 0; i < 6; ++i){
                key += chars.charAt(rnd.nextInt(10000) % 31);
            }
            
            if (!memo.containsKey(chars)){
                memo.put(key, longUrl);
                break;
            }
        }
        
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return memo.get(shortUrl.substring(19));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));