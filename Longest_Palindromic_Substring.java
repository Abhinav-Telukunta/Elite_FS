/*
Mr. James professor of at Illinois state university, as a part of assignment he created a
problem statement related to strings.
He gave a String S, and asked them to design a method to 
return the longest substring in S, which is a palindrome.

NOTE: Alphabets are case sensitive
"Aa" is not considered a palindrome here.

Input Format:
-------------
A string S, consist of lowercase/uppercase letters or/and digits

Output Format:
--------------
Print a string, longest palindrome substring.


Sample Input-1:
---------------
abbbabbcbbacdb

Sample Output-1:
----------------
abbcbba


Sample Input-2:
---------------
thedivideriswide

Sample Output-2:
----------------
edivide

 */
import java.util.*;
class Longest_Palindromic_Substring{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        for(int i=0;i<n;++i) dp[i][i]=true;
        int lps=0,lpl=0;
        for(int i=n-1;i>=0;--i){
            for(int j=i+1;j<n;++j){
                if(j==i+1 && s.charAt(i)==s.charAt(j)) dp[i][j]=true;
                if(j!=i+1 && s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true) dp[i][j]=true;
                if(dp[i][j] && lpl<j-i+1){
                    lpl=j-i+1;
                    lps=i;
                }
            }
        }
        System.out.println(s.substring(lps,lps+lpl));
    }
}
