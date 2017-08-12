package leetcode.Implement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qifu on 17/3/15.
 */
public class EncodeandDecodeTinyURL {
    List<String> list = new ArrayList<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        list.add(longUrl);
        return String.valueOf(list.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl);
        return (index < list.size()) ? list.get(index) : "";
    }

    //Other
    //It's possible that a randomly generated code has already been generated before.
    //In that case, another random code is generated instead.

    Map<String, String> index = new HashMap<>();
    Map<String, String> reIndex = new HashMap<>();
    static String BASE_HOST = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(reIndex.containsKey(longUrl)) return BASE_HOST + reIndex.get(longUrl);
        String charStr =  "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String str = null;
        do {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 6; i++) {
                int randIndex = (int)(Math.random() * charStr.length());
                sb.append(charStr.charAt(randIndex));
            }
            str = sb.toString();
        } while(index.containsKey(str));
        index.put(longUrl, str);
        reIndex.put(str, longUrl);
        return BASE_HOST + str;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return reIndex.get(shortUrl.replace(BASE_HOST, ""));
    }
}
