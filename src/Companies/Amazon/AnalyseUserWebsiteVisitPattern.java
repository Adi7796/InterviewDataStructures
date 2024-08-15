package Companies.Amazon;

import java.util.*;

/*
You are given two string arrays username and website and an integer array timestamp. All the given arrays are of the same length and the tuple [username[i], website[i], timestamp[i]] indicates that the user username[i] visited the website website[i] at time timestamp[i].

A pattern is a list of three websites (not necessarily distinct).

For example, ["home", "away", "love"], ["leetcode", "love", "leetcode"], and ["luffy", "luffy", "luffy"] are all patterns.
The score of a pattern is the number of users that visited all the websites in the pattern in the same order they appeared in the pattern.

For example, if the pattern is ["home", "away", "love"], the score is the number of users x such that x visited "home" then visited "away" and visited "love" after that.
Similarly, if the pattern is ["leetcode", "love", "leetcode"], the score is the number of users x such that x visited "leetcode" then visited "love" and visited "leetcode" one more time after that.
Also, if the pattern is ["luffy", "luffy", "luffy"], the score is the number of users x such that x visited "luffy" three different times at different timestamps.
Return the pattern with the largest score. If there is more than one pattern with the same largest score, return the lexicographically smallest such pattern.



Example 1:

Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
Output: ["home","about","career"]
Explanation: The tuples in this example are:
["joe","home",1],["joe","about",2],["joe","career",3],["james","home",4],["james","cart",5],["james","maps",6],["james","home",7],["mary","home",8],["mary","about",9], and ["mary","career",10].
The pattern ("home", "about", "career") has score 2 (joe and mary).
The pattern ("home", "cart", "maps") has score 1 (james).
The pattern ("home", "cart", "home") has score 1 (james).
The pattern ("home", "maps", "home") has score 1 (james).
The pattern ("cart", "maps", "home") has score 1 (james).
The pattern ("home", "home", "home") has score 0 (no user visited home 3 times).
Example 2:

Input: username = ["ua","ua","ua","ub","ub","ub"], timestamp = [1,2,3,4,5,6], website = ["a","b","a","a","b","c"]
Output: ["a","b","a"]

 */
public class AnalyseUserWebsiteVisitPattern {

    public static void main(String[] args) {

        String[] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = {1,2,3,4,5,6,7,8,9,10};
        String[] website = {"home","about","career","home","cart","maps","home","home","about","career"};

        AnalyseUserWebsiteVisitPattern obj = new AnalyseUserWebsiteVisitPattern();
        List<String> ans = obj.mostVisitedPattern(username, timestamp, website);

        System.out.println(ans);
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        Map<String, ArrayList<Pair>> usernameToWebsiteMap = new HashMap<>();

        for(int i=0;i<username.length; i++)
        {
            if(!usernameToWebsiteMap.containsKey(username[i]))
            {
                ArrayList<Pair> websiteList = new ArrayList<>();
                websiteList.add(new Pair(timestamp[i], website[i]));
                usernameToWebsiteMap.put(username[i], websiteList);
            }
            else
            {
                ArrayList<Pair> list = usernameToWebsiteMap.get(username[i]);
                list.add(new Pair(timestamp[i], website[i]));
            }
        }

        Map<String, Integer> patternToCountMap = new HashMap<>();

        for(Map.Entry<String, ArrayList<Pair>> entry : usernameToWebsiteMap.entrySet())
        {
            List<Pair> websitesList = entry.getValue();
            Collections.sort(websitesList, new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2)
                {
                    return p1.timestamp - p2.timestamp;
                }
            });
            int n = websitesList.size();

            for(int i=0;i< n-2; i++)
            {
                for(int j=i+1; j<n-1; j++)
                {
                    for(int k = j+1; k<n; k++)
                    {
                        StringBuilder sb = new StringBuilder();
                        sb.append(websitesList.get(i).webSite).append("%").append(websitesList.get(j).webSite).append("%").append(websitesList.get(k).webSite);
                        patternToCountMap.put(sb.toString(), patternToCountMap.getOrDefault(sb.toString(), 0) + 1);
                    }
                }
            }
        }

        String maxPattern = null;
        int maxCount = -1;
        for(Map.Entry<String, Integer> entry : patternToCountMap.entrySet())
        {
            int count = entry.getValue();
            String pattern = entry.getKey();

            if(count > maxCount || (count == maxCount && (maxPattern == null || pattern.compareTo(maxPattern) < 0)))
            {
                maxCount = count;
                maxPattern = pattern;
            }
        }

        String[] patternArray = maxPattern.split("%");
        List<String> patternList = new ArrayList<>();

        for(int i = 0; i < patternArray.length; i++)
        {
            patternList.add(patternArray[i]);
        }

        return patternList;
    }

    static class Pair{
        int timestamp;
        String webSite;

        public Pair(int timestamp, String website)
        {
            this.webSite = website;
            this.timestamp = timestamp;
        }
    }

}
