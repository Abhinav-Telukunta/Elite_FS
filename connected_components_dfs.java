/*
A magic box with p rows and r columns is initially filled with silver.
If we invoke a method 'addMagicOperation' which turns the silver at index (r, c)
into gold. 

Given N set of indices to work up on, find the number of gold-blocks which 
are formed after each addMagicOperation. 

A gold-block is a block of gold cells connected horizontally and vertically and 
surrounded by silver. Consider all four edges of the magic box are surrounded by
silver.

Input Format:
--------------
Line-1: Three space separated integers p, r , and n (number of add Magic Operations)
Next N lines: Two space separated integers, cell to perform addMagicOperation 

Output Format:
--------------
Print a list of numbers, number of gold-blocks formed after each addMagicOperation


Sample Input-1:
-----------------
3 3 5
0 0
0 1
1 2
2 1
1 1

Sample Output-1:
-----------------
[1, 1, 2, 3, 1]

Explanation:
-----------
Initially, the magic box is filled with silver. 
(Assume 0 represents silver and 1 represents gold).

0 0 0
0 0 0
0 0 0

Operation #1: addMagicOperation(0, 0) turns the silver at cell[0][0] into gold.

1 0 0
0 0 0   Number of Gold-blocks = 1
0 0 0

Operation #2: addMagicOperation(0, 1) turns the silver at cell[0][1] into gold.

1 1 0
0 0 0   Number of Gold-blocks = 1
0 0 0

Operation #3: addMagicOperation(1, 2) turns the silver at cell[1][2] into gold.

1 1 0
0 0 1   Number of Gold-blocks = 2
0 0 0

Operation #4: addMagicOperation(2, 1) turns the silver at cell[2][1] into gold.

1 1 0
0 0 1   Number of Gold-blocks = 3
0 1 0

Operation #5: addMagicOperation(1, 1) turns the silver at cell[1][1] into gold.

1 1 0
0 1 1   Number of Gold-blocks = 1
0 1 0


 */
import java.util.*;
public class connected_components_dfs{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int n=sc.nextInt();
        int[][] mat=new int[r][c];
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;++i){
            int row=sc.nextInt(),col=sc.nextInt();
            mat[row][col]=1;
            int[][] dup=new int[r][c];
            duplicate(mat,dup,r,c);
            int res=compute(dup,r,c);
            ans.add(res);
        }
        System.out.println(ans);
    }
    public static void duplicate(int[][] mat,int[][] dup,int r,int c){
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j) dup[i][j]=mat[i][j];
        }
    }
    public static int compute(int[][] mat,int r,int c){
        int res=0;
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j){
                if(mat[i][j]==1){
                    dfs(mat,i,j,r,c);
                    res++;
                }
            }
        }
        return res;
    }
    public static void dfs(int[][] mat,int i,int j,int r,int c){
        if(i<0 || j<0 || i>=r || j>=c || mat[i][j]==0) return;
        mat[i][j]=0;
        dfs(mat,i+1,j,r,c);
        dfs(mat,i-1,j,r,c);
        dfs(mat,i,j+1,r,c);
        dfs(mat,i,j-1,r,c);
    }
}
