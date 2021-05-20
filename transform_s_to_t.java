/*Chitti built a mini robot 'Tiny', which is used to transform
the given string S into a target string T.

Tiny is allowed to perform the given steps to transform S into T:
	- Add a letter to S at any place.
	- Remove any letter from S.
	- Substitute a letter in S with another letter.

Your task is to write a program for Tiny to transform S into T
in minimum number of steps. and return the count of steps.

Input Format:
-------------
Two space separated strings S and T, consist of lowercase letters only.

Output Format:
--------------
Print an integer, minimum number of steps required to transform S into T.


Sample Input-1:
---------------
energy synergy

Sample Output-1:
----------------
2

Explanation:
-----------
energy -> senergy (add 's')
senergy -> synergy (substitute 'y' in place of 'e')


Sample Input-2:
---------------
treatment basement

Sample Output-2:
----------------
5

Explanation:
-----------
treatment -> tretment (remove 'a')
tretment -> trement (remove 't')
trement -> arement (substitute 'a' in place of 't')
arement -> asement (substitute 's' in place of 'r')
asement -> basement (add 'b')
*/
import java.util.*;
class transform{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String t=sc.next();
        int len1=s.length(),len2=t.length();
        int[][] dp=new int[len1+1][len2+1];
        for(int i=1;i<=len1;++i) dp[i][0]=i;
        for(int j=1;j<=len2;++j) dp[0][j]=j;
        for(int i=1;i<=len1;++i){
            for(int j=1;j<=len2;++j){
                if(s.charAt(i-1)==t.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else dp[i][j]=Math.min(dp[i-1][j-1]+1,Math.min(dp[i][j-1]+1,dp[i-1][j]+1));
            }
        }
        System.out.println(dp[len1][len2]);
    }
}