package Design.LLD;

import java.util.HashMap;

public class TinyURL {

    static HashMap<String, String> tinyToLongUrlMap = new HashMap<>();
    public static void main(String[] args) {
        String longUrl = "https://leetcode.com/problems/partition-array-for-maximum-sum";
        String tinyUrl = createShortUrl(longUrl);
        System.out.println("Short URL for : " + longUrl);
        String completeShortUrl = "http://tiny-url.com/"+ tinyUrl;
        System.out.println(completeShortUrl);

        System.out.println("Long URL for " + completeShortUrl + " : " + getLongUrl(tinyUrl));
    }

    public static String getLongUrl(String tinyUrl)
    {
        return tinyToLongUrlMap.get(tinyUrl);
    }

    public static String createShortUrl(String longUrl)
    {
        String tempUrl = longUrl.split("problems")[1].substring(1);
        System.out.println(tempUrl);

        StringBuilder shortUrl = new StringBuilder();
        /*
        Math.random gives any float between 0-1 ( say 0.5535)
        0.5535 * 100 = 55.35
        floor(55.35) = 55
        (char)55 - gives some character
         */
        shortUrl.append((char)Math.floor(Math.random()*100));
        while(tinyToLongUrlMap.containsKey(shortUrl.toString())){
            shortUrl.append((char)Math.floor(Math.random()*100));
        }
        tinyToLongUrlMap.put(shortUrl.toString(), longUrl);
        return  shortUrl.toString();
    }
}
