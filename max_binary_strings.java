/*Mounika is creating the binary strings using P 1's and Q 0's.
A binary string contains only 0's and 1's.
She has given a list of binary strings binStr[] to be formed.

Her task is to find, the maximum number of binary strings can be formed, 
with given P 1's and Q 0's only. She cannot use any more 1's or 0's.

Input Format:
-------------
Line-1 -> A single line of space separated binary strings, binStr[].
Line-2 -> Two integers P and Q, P number of 1's and Q number of 0's


Output Format:
--------------
Print an integer as output, maximum number of binary strings can be formed.


Sample Input-1:
---------------
10 0001 111001 1 0
3 5

Sample Output-1:
----------------
4

Explanation:
------------
She can form 4 strings by the using of 3 1's and 5 0's
strings are 10, 0001, 1, 0.


Sample Input-2:
---------------
10 1 0
1 1

Sample Output-2:
----------------
2

Explanation:
------------
She can form 2 strings by the using of 1 1's and 1 0's
strings are 1, 0.

*/
import java.util.*;
public class max_binary_strings{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String[] sw=sc.nextLine().split(" ");
        int ones=sc.nextInt();
        int zeros=sc.nextInt();
        int[][] dp=new int[zeros+1][ones+1];
        for(String s:sw){
            int[] count=count(s);
            for(int zero=zeros;zero>=count[0];zero--){
                for(int one=ones;one>=count[1];one--){
                    dp[zero][one]=Math.max(1+dp[zero-count[0]][one-count[1]],dp[zero][one]);
                }
            }
        }
        System.out.println(dp[zeros][ones]);
    }
    public static int[] count(String s){
        int[] ans=new int[2];
        for(char c:s.toCharArray()){
            ans[c-'0']++;
        }
        return ans;
    }
}
