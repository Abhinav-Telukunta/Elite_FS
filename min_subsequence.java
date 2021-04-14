/*Kiran is playing with strings and its subsequences.
A subsequence can be formed from a string by deleting some characters 
(may be string itself)

Kiran has given two strings S and T, 
your task to form T by concatenating the subsequences of S  

Return the minimum number of subsequences required to form T.
If the task is impossible, return -1 .

Input Format:
-------------
Line-1 -> Two strings S and T

Output Format:
--------------
Print an integer as result.


Sample Input-1:
---------------
abc abcbc

Sample Output-1:
----------------
2

Explanation: 
------------
T = "abcbc" can be formed by "abc" and "bc",
which are subsequences of S = "abc".


Sample Input-2:
---------------
abc acdbc

Sample Output-2:
----------------
-1

Explanation: 
------------
string T cannot be constructed from the
subsequences of string S due to the character "d" in string T.
*/
import java.util.*;
class min_subsequence{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String t=sc.next();
        Set<Character>set=new HashSet<>();
        for(int i=0;i<s.length();++i) set.add(s.charAt(i));
        int flag=0;
        for(int i=0;i<t.length();++i){
            if(!set.contains(t.charAt(i))){
                System.out.println(-1);
                flag=1;
                break;
            }
        }
        if(flag==0){
            int ans=0,i=0;
            while(i<t.length()){
                int sidx=0;
                while(sidx<s.length() && i<t.length()){
                    if(s.charAt(sidx)==t.charAt(i)) i++;
                    sidx++;
                }
                ans++;
            }
            System.out.println(ans);
        }
    }
}
