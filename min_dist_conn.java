/*Pandavas and Kauravas are ruling two different kingdoms sepertaed by river.
If you connect both the kingdoms they will be in Square shaped land.
Land occupied by the kingdoms, indiacted with 1's and the river, indiacted with 0's.

Now, Pandavas and Kauravas decided to build a bridge on the river for easy 
connectivity. As the cost of building a bridge will be high, they have decided 
to reduce the length of the bridge. You are allowed to build the bridge on 
the river cells, connected by 4 directions only (up, down,left,right).

Your task is to help the Kings, to minimize the occupation of river cells, 
to build the bridge with minimum cost. And return the count of river cells occupied.

Input Format:
-------------
Line-1: An integer N, size of the land.
Next N lines: N space separated integers, either 0 or 1. 

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
4
1 1 1 0
1 0 0 0
1 0 0 1
0 0 1 1

Sample Output-1:
----------------
2


Sample Input-2:
---------------
5
1 1 0 0 0
1 1 0 0 0
0 0 0 0 1
0 0 0 1 1
0 0 1 1 1

Sample Output-2:
----------------
3
*/
import java.util.*;
class bridge{
    static ArrayList<int[]>arr=new ArrayList<>();
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] mat=new int[n][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j) mat[i][j]=sc.nextInt();
        }
        ArrayList<int[]>k1=new ArrayList<>();
        ArrayList<int[]>k2=new ArrayList<>();
        int f=0;
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(mat[i][j]==1){
                    dfs(mat,i,j,n);
                    if(f==0) {
                        for(int[] t:arr) k1.add(t);
                        f=1;
                    }
                    else{
                        for(int[] t:arr) k2.add(t);
                    }
                    arr.clear();
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int[] co1:k1){
            for(int[] co2:k2){
                int dist=Math.abs(co1[0]-co2[0])+Math.abs(co1[1]-co2[1])-1;
                ans=Math.min(ans,dist);
            }
        }
        System.out.println(ans);
        
    }
    public static void dfs(int[][] mat,int i,int j,int n){
        if(i<0 || i>=n || j<0 || j>=n || mat[i][j]==0) return;
        mat[i][j]=0;
        arr.add(new int[]{i,j});
        dfs(mat,i-1,j,n);
        dfs(mat,i+1,j,n);
        dfs(mat,i,j-1,n);
        dfs(mat,i,j+1,n);
    }
}