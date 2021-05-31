/*Sumanth has an idea to calculate the ABD value of a string.
An ABD value is defined as the absolute diffrence between
the most occurance count of a charcter and the least occurance count 
of another character in the given string.

Sumanth is given a string S,
He wants to find out, the sum of ABD values of all the substrings of S,
where ABD > 0.

Your task is to help Sumanth to find total ABD value of substrings of S.

Input Format:
-------------
A String S

Output Format:
--------------
Print an integer, sum of ABD of all the strings of S


Sample Input-1:
---------------
abbcc

Sample Output-1:
----------------
5

Explanation: 
------------
The substrings with non-zero ABD are as follows:
Substring and ABD value -> "abb"-1,"abbc"-1,"abbcc"-1,"bbc"-1,"bcc"-1
The total sum of ABD is, 5


Sample Input-2:
---------------
abcbabc

Sample Output-2:
----------------
15

Explanation: 
------------
The substrings with non-zero ABD are as follows:
substring and ABD value -> "abcb"-1,"abcba"-1,"abcbab"-2,"abcbabc"-1,"bcbabc"-2
"bcbab"-2, "bcba"-1, "bcb"-1, "cbab"-1,"cbabc"-1,"bab"-1, "babc"-1.
The total sum of ABD is, 15
*/
import java.util.*;
class abd{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        int ans=0;
        for(int len=2;len<=n;++len){
            for(int i=0;i<n-len+1;++i){
                String substr=s.substring(i,i+len);
                //System.out.println(substr);
                int res=compute_abd(substr);
                //System.out.println(res);
                ans+=res;
            }
        }
        System.out.println(ans);
    }
    public static int compute_abd(String s){
        int[] freq=new int[26];
        Arrays.fill(freq,-1);
        for(int i=0;i<s.length();++i){
            freq[(s.charAt(i)+'0'-145)]++;
        }
        int maxx=Integer.MIN_VALUE,minn=Integer.MAX_VALUE;
        for(int num:freq) maxx=Math.max(maxx,num);
        for(int num:freq) {
            if(num!=-1) minn=Math.min(minn,num);
        }
        return Math.abs(maxx-minn);
    }
}