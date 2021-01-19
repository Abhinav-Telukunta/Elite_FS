/*
There are pair of words namely W1 and W2 with a limited of word range, 
Create a method to return a true value if W2 contains the anagram of W1. 
In additional, one of the anagram of first word is the substring of the second word.

Your task is to implement the Solution class, and implement a method in it, 
	- public boolean checkPalindromeSubstring(String w1, String w2){}.

Input Format:
-------------
Two space separated words w1 and w2, consist of lowercase letters only.

Output Format:
--------------
Print a boolean value, if W2 contains the anagram of W1 or not.


Sample Input-1:
---------------
abbcbb abbbabbcb

Sample Output-1:
----------------
true


Sample Input-2:
---------------
abbcbbc abbbabbcb

Sample Output-2:
----------------
false

 */
import java.util.*;
public class Rabin_Karp{
    public static boolean checkSubstring(String w1,String w2){
        if(w2.length()<w1.length()) return false;
        int hp=get_hashcode(w1.toCharArray(),0,w1.length());
        int[] fp=new int[26];
        char[] pattern=w1.toCharArray();
        for(char c:pattern) fp[c-'a']++;
        char[] text=w2.toCharArray();
        int prev_ht=get_hashcode(text,0,w1.length());
        if(prev_ht==hp){
            int[] ft=new int[26];
            for(int j=0;j<pattern.length;++j) ft[text[j]-'a']++;
            int flag=0;
            for(int i=0;i<26;++i){
                if(fp[i]!=ft[i]){
                    flag=1;
                    break;
                }
            }
            if(flag==0) return true;
        }
        char prevChar=text[0];
        int lp=pattern.length,lt=text.length;
        for(int i=1;i<lt-lp+1;++i){
            int ht=rolling_hash(text,prevChar,prev_ht,i+lp-1);
            if(ht==hp){
                int[] ft=new int[26];
                for(int j=i;j<i+lp;++j) ft[text[j]-'a']++;
                int flag=0;
                for(int j=0;j<26;++j){
                    if(fp[j]!=ft[j]){
                        flag=1;
                        break;
                    }
                }
                if(flag==0) return true;
            }
            prev_ht=ht;
            prevChar=text[i];
        }
        return false;
    }
    public static int get_hashcode(char[] arr,int low,int high){
        int res=0;
        for(int i=low;i<high;++i){
            res+=(arr[i]-97);
        }
        return res;
        
    }
    public static int rolling_hash(char[] text,char prevChar,int prev_ht,int i){
        int ans=prev_ht-(prevChar-97)+(text[i]-97);
        return ans;
    }
}

