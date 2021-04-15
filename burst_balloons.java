/*You are playing a shooting game.
There are N bottles hanging to a rod, i-th bottle numbered bottle[i].

If you shoot i-th bottle, you will get bottle[i-1]*bottle[i]*bottle[i+1] points.
The more points you score, the more rewards you can win.

Your task is to score the maximum points by shooting all the ballons wisely.

Note: After you shoot bottle at i-th index, bottles at i-1 and i+1 positions
become adjacent. if there is no existing 'i-1' or 'i+1' positions for selected bottle.
you can assume that bottle[i-1] = bottle[i+1] = 1.

Input Format:
-------------
N space separated integers bottles[].

Output Format:
--------------
Print an integer, maximum points you can get.


Sample Input:
---------------
3 1 5 8

Sample Output:
----------------
167

Explanation:
------------
Given bottles = [3, 1, 5, 8] 
position 	points
--------------------
1				3*1*5
5				3*5*8
3				1*3*8
8				1*8*1
--------------------
Total = 167


Sample Input:
---------------
2 1 3 5 4

Sample Output:
----------------
102

Explanation:
------------
Given bottles = [2, 1, 3, 5, 4] 

position 	points
--------------------
5				3*5*4
1				2*1*3
3				2*3*4
2				1*2*4
4				1*4*1
--------------------
Total = 102
*/
import java.util.*;
class burst_balloons{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        int[] arr=new int[s.length];
        for(int i=0;i<s.length;++i) arr[i]=Integer.parseInt(s[i]);
        int n=arr.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;++i){
            dp[i][i]=(i-1>=0?arr[i-1]:1)*arr[i]*(i+1<n?arr[i+1]:1);
        }
        for(int len=2;len<=n;++len){
            for(int i=0;i<n-len+1;++i){
                int j=i+len-1;
                int lmax=0,total=0;
                for(int k=i;k<=j;++k){
                    if(k==i) total=dp[i+1][j]+(i-1>=0?arr[i-1]:1)*arr[k]*(j+1<n?arr[j+1]:1);
                    else if(k==j) total=dp[i][j-1]+(i-1>=0?arr[i-1]:1)*arr[k]*(j+1<n?arr[j+1]:1);
                    else total=dp[i][k-1]+dp[k+1][j]+(i-1>=0?arr[i-1]:1)*arr[k]*(j+1<n?arr[j+1]:1);
                    lmax=Math.max(lmax,total);
                }
                dp[i][j]=lmax;
            }
        }
        System.out.println(dp[0][n-1]);
    }
}