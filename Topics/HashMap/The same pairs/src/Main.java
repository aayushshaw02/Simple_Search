import java.util.*;


class MapFunctions {

    public static void calcTheSamePairs(Map<String, String> map1, Map<String, String> map2) {
        // write your code here
        int s1= map1.size(),s2= map2.size(),ans=0;
        for(String key: map2.keySet()){
            if(map1.containsKey(key)){
                if(map1.get(key).equals(map2.get(key))){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}