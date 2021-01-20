/*
 Vihaan is given a pair of words likely word1 and word2, 
he is asked to create a method which returns the numbers of characters in a word 
formed from long lasting frequent posteriority.

Posteriority is the word formed from the original word with few characters removed
without modifying the corresponding order of the left over characters.

Find the longest common posteriority of two words.
Return 0 if no common posteriority.

Input Format:
-------------
Two space separated strings S1, S2.

Output Format:
--------------
Print an integer, the length of longest common prosperity.


Sample Input-1:
---------------
abcde ace

Sample Output-1:
----------------
3


Sample Input-2:
---------------
acd bef

Sample Output-2:
----------------
0


 */
import java.util.*;
public class Longest_common_subseq{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String word1=sc.next();
        String word2=sc.next();
        int len1=word1.length(),len2=word2.length();
        int[][] dp=new int[len1+1][len2+1];
        int ans=longest_comm_subseq(dp,word1,word2,len1,len2);
        System.out.println(ans);
    }
    public static int longest_comm_subseq(int[][] dp,String word1,String word2,int l1,int l2){
        for(int i=1;i<=l1;++i){
            for(int j=1;j<=l2;++j){
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[l1][l2];
    }
}
