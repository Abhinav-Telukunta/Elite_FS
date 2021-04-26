/*The decoration on the wall, made up of led bulbs. When the bulbs turned on, 
the bulbs emit either bule color light or white color light. 
The leds bulbs decorated in the form of a grid of size m*n. 
And when you turned on the bulbs, the bulbs are emiting the light 
in blue color (1) and white color (0).

You are given the current state of the decorated wall of size M*N,
Your task is to find the biggest square can be formed using blue colored bulbs,
and return its area.

Input Format:
-------------
Line-1: Two space separated integers, M and N size of the decoration grid.
Next M lines: N space separated integers ( either 0 or 1 only).

Output Format:
--------------
Print an integer, area of the biggest square grid of blue colored bulbs.


Sample Input:
-------------
5 6
1 0 0 1 0 1
0 1 1 1 1 1
1 1 1 1 0 1
0 1 1 1 0 1
1 0 1 0 1 1 

Sample Output:
--------------
9
*/
import java.util.*;
class max_area{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int[][] mat=new int[r][c];
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j) mat[i][j]=sc.nextInt();
        }
        int[][] dp=new int[r][c];
        int ans=0;
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j){
                if(mat[i][j]==1){
                    dp[i][j]=Math.min(Math.min(j-1>=0?dp[i][j-1]:0,i-1>=0?dp[i-1][j]:0),(i-1>=0 && j-1>=0)?dp[i-1][j-1]:0)+1;
                    ans=Math.max(ans,dp[i][j]);
                }
                
            }
        }
        System.out.println(ans*ans);
        
    }
}