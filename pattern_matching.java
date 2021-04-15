/*Given two strings S1 and S2, find if S2 can match S1 or not.

A match that is both one-to-one (an injection) and onto (a surjection), 
i.e. a function which relates each letter in string S1 to a separate and 
distinct non-empty substring in S2, where each non-empty substring in S2 
also has a corresponding letter in S1.

Return true,if S2 can match S1.
Otherwise false.

Input Format:
-------------
Line-1 -> Two strings S1 and S2

Output Format:
--------------
Print a boolean value as result.


Sample Input-1:
---------------
abab kmitngitkmitngit

Sample Output-1:
----------------
true


Sample Input-2:
---------------
aaaa kmjckmjckmjckmjc

Sample Output-2:
----------------
true

Sample Input-3:
---------------
aabb xyzabcxyzabc

Sample Output-3:
----------------
false
*/
import java.util.*;
public class pattern_matching{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        Map<Character,String>map=new HashMap<>();
        int i=0,j=0;
        System.out.println(isMatch(s1,j,s2,i,map));
    }
    public static boolean isMatch(String s1,int j,String s2,int i,Map<Character,String>map){
        if(j==s1.length() && i==s2.length()) return true;
        if(j==s1.length() || i==s2.length()) return false;
        char c=s1.charAt(j);
        if(map.get(c)!=null){
            String s=map.get(c);
            if(i+s.length()>s2.length() || !s2.substring(i,i+s.length()).equals(s)){
                return false;
            }
            return isMatch(s1,j+1,s2,i+s.length(),map);
        }
        for(int k=i;k<s2.length();++k){
            map.put(c,s2.substring(i,k+1));
            if(isMatch(s1,j+1,s2,k+1,map)) return true;
        }
        map.remove(c);
        return false;
    }
}

/*
Solution with comments
public class Solution {
	  
	  public boolean isMatch(String str, String pat) {
	    Map<Character, String> map = new HashMap<>();
	    return isMatch(str, 0, pat, 0, map);
	  }
	  
	  boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map) {
	    // base case
	    if (i == str.length() && j == pat.length()) return true;
	    if (i == str.length() || j == pat.length()) return false;
	    
	    // get current pattern character
	    char c = pat.charAt(j);
	    
	    // if the pattern character exists
	    if (map.containsKey(c)) {
	      String s = map.get(c);
	      
	      // then check if we can use it to match str[i...i+s.length()]
	      if (i + s.length() > str.length() || !str.substring(i, i + s.length()).equals(s)) {
	        return false;
	      }
	      
	      // if it can match, great, continue to match the rest
	      return isMatch(str, i + s.length(), pat, j + 1, map);
	    }
	    
	    // pattern character does not exist in the map
	    for (int k = i; k < str.length(); k++) {
	      // create or update the map
	      map.put(c, str.substring(i, k + 1));
	      
	      // continue to match the rest
	      if (isMatch(str, k + 1, pat, j + 1, map)) {
	        return true;
	      }
	    }
	    
	    // we've tried our best but still no luck
	    map.remove(c);
	    
	    return false;
	  }
	  
	}

*/