package string;

import java.util.ArrayList;
import java.util.List;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-05-20
 */
public class EncodeandDecodeTinyURL535 {
    public static void main(String[] args) {
        Codec codec = new Codec();
        codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl"));
    }
}
class Codec {
    List<String> urls = new ArrayList<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urls.add(longUrl);
        return String.valueOf(urls.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl);
        return index <= urls.size() ? urls.get(index) : "";
    }
}

