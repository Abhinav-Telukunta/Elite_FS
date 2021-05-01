/*A merchant has two types of idols, gold and silver.
He has arranged the idols in the form of m*n grid, 
	- the gold idols are represented as 1's 
	- the silver idols are represented as 0's.

Your task is to find the longest consecutive arrangement of gold idols, 
The arrangement can be either horizontal, vertical, diagonal or anti diagonal, 
but not the combination of these.


Input Format:
-------------
Line-1: Two space separated integers m and n, grid size.
Next m lines : n space separated integers, arrangement of idols.

Output Format:
--------------
Print an integer, longest arrangement of gold idols.


Sample Input:
---------------
4 5
1 0 1 1 1
0 1 0 1 0
1 0 1 0 1
1 1 0 1 1

Sample Output:
----------------
4
*/
import java.util.*;
class longest{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int[][] mat=new int[r][c];
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j) mat[i][j]=sc.nextInt();
        }
        int ans=0;
        int[][] hor=new int[r][c];
        int[][] ver=new int[r][c];
        int[][] diag=new int[r][c];
        int[][] anti_diag=new int[r][c];
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j){
                if(mat[i][j]==1){
                    hor[i][j]=ver[i][j]=diag[i][j]=anti_diag[i][j]=1;
                    if(j-1>=0){
                        hor[i][j]=hor[i][j-1]+1;
                        ans=Math.max(ans,hor[i][j]);
                    }
                    if(i-1>=0){
                        ver[i][j]=ver[i-1][j]+1;
                        ans=Math.max(ans,ver[i][j]);
                    }
                    if(i-1>=0 && j-1>=0){
                        diag[i][j]=diag[i-1][j-1]+1;
                        ans=Math.max(ans,diag[i][j]);
                    }
                    if(i-1>=0 && j+1<c){
                        anti_diag[i][j]=anti_diag[i-1][j+1]+1;
                        ans=Math.max(ans,anti_diag[i][j]);
                    }
                }
            }
        }
        System.out.println(ans);
        
    }
}
