package leetcode.Implement;

import java.util.ArrayList;
import java.util.List;

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
}
